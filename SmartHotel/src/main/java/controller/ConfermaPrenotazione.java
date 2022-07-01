package controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.GetTodayDate;
import dao.PrenotazioneDAOImpl;
import dao.UtenteDAOImpl;
import model.Prenotazione;
import model.Utente;
import java.sql.Date;
import java.util.Random;

@Controller
public class ConfermaPrenotazione {
	//private static final long serialVersionUID = 1L;
	
	protected ModelAndView doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Homepage.jsp");
		
		Date checkIn = Date.valueOf(request.getParameter("checkIn"));
		Date checkOut = Date.valueOf(request.getParameter("checkOut"));
		int numOspiti = Integer.parseInt(request.getParameter("numOspiti"));
		String camera =request.getParameter("numCamera");
		String intestatario = request.getParameter("intestatario");
		double prezzo = Double.parseDouble(request.getParameter("prezzo"));
		GetTodayDate gtd = new GetTodayDate();
		Date dataAttuale = checkIn;
		Prenotazione p = new Prenotazione();
		
		Random rand = new Random();
		int PIN = 10000 + rand.nextInt(89999);
		
		p.setCheckIn(checkIn);
		p.setCheckOut(checkOut);
		p.setNumOspiti(numOspiti);
		p.setCamera(camera);
		p.setIntestatario(intestatario);
		p.setPrezzo(prezzo);
		p.setDataPrenotazione(dataAttuale);
		p.setPINCamera(PIN);
		
		PrenotazioneDAOImpl pDao = new PrenotazioneDAOImpl();
		
		if (pDao.checkDisponibilita(Integer.parseInt(camera), checkIn,checkOut))
		{
			if(pDao.save(p) == 1)
			{
				mv.addObject("messaggio", "Prenotazione effettuata");
			}
			else mv.addObject("messaggio", "Prenotazione fallita");
		}
		else mv.addObject("messaggio", "Prenotazione fallita!, camera già prenotata");
		
		
		
		
		return mv;
		
		//RequestDispatcher view = request.getRequestDispatcher("WEB-INF/Login.jsp");
		//view.forward(request, response);
	}

	@RequestMapping("ConfermaPrenotazione")
	protected ModelAndView doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return doGet(request, response);
	}
}
