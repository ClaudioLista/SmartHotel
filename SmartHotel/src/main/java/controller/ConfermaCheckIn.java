package controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.ComandaDAOImpl;
import dao.DocumentoDAOImpl;
import dao.GetTodayDate;
import dao.PrenotazioneDAOImpl;
import dao.UtenteDAOImpl;
import model.Comanda;
import model.Documento;
import model.Prenotazione;
import model.Utente;
import java.sql.Date;
import java.util.Random;

@Controller
public class ConfermaCheckIn {
	
	protected ModelAndView doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("StoricoPrenotazioni.jsp");
		
		int idPrenotazione =  Integer.parseInt(request.getParameter("idPrenotazione1"));
		String emailInt = request.getParameter("emailIntestatario");
		String tipoDocumento = request.getParameter("tipoDoc");
		String numDocumento = request.getParameter("numDoc");
		String pathImmagine =request.getParameter("pathImmagine");
		
		Documento doc = new Documento(idPrenotazione, tipoDocumento, numDocumento,emailInt , pathImmagine);
		
		DocumentoDAOImpl docDAO = new DocumentoDAOImpl();
		PrenotazioneDAOImpl pDAO = new PrenotazioneDAOImpl();
		docDAO.save(doc);
		
		if(pDAO.effettuaCheckIn(idPrenotazione, numDocumento) == 1)
		{
			mv.addObject("messaggio", "Check-In effettuato");
		}
		else mv.addObject("messaggio", "Check-In fallito");

		PrenotazioneDAOImpl prenDAO = new PrenotazioneDAOImpl(); 
		ArrayList<model.Prenotazione> listaPrenotazioni = prenDAO.getbyEmail(emailInt);
		
		ComandaDAOImpl comDaoImpl = new ComandaDAOImpl(); 
		ArrayList<Comanda> ordini = comDaoImpl.listAttive(emailInt);
		
		double totaleOrdini = 0;
		
		for (Comanda comanda : ordini) {
			totaleOrdini = totaleOrdini + comanda.getTotale();
		}
		
		mv.addObject("totaleOrdini", totaleOrdini);
		mv.addObject("listaPrenotazioni", listaPrenotazioni);
		
		return mv;

	}

	@RequestMapping("ConfermaCheckIn")
	protected ModelAndView doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return doGet(request, response);
	}
}
