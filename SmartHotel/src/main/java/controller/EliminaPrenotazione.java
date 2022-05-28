package controller;

import java.io.IOException;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.PrenotazioneDAOImpl;
import dao.UtenteDAOImpl;
import model.Utente;

/**
 * Servlet implementation class EliminaPrenotazione
 */
@Controller
public class EliminaPrenotazione {
	
	public ModelAndView doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView("StoricoPrenotazioni.jsp");
		
		String ids = request.getParameter("id");
		if (ids != null) {
			int id = Integer.parseInt(ids);

			HttpSession sessione = request.getSession();
			Utente c = (Utente) sessione.getAttribute("utente");

			// prende la data corrente
//			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//			LocalDate localDate = LocalDate.now();
//			System.out.println(dtf.format(localDate));

			PrenotazioneDAOImpl prenDAO = new PrenotazioneDAOImpl(); 
			//Date dtf = new Date();
			prenDAO.delete(id);

			//ArrayList<Model.Prenotazione> listaPrenotazioni = prenDAO.getbyDate(c.getEmail(),dtf.format(localDate));
			ArrayList<model.Prenotazione> listaPrenotazioni = prenDAO.getbyDate(c.getEmail());
			
			request.removeAttribute("listaPrenotazioni");
			mv.addObject("listaPrenotazioni", listaPrenotazioni);
			mv.addObject("messaggio", "Eliminazione effettuata");

//			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/StoricoPrenotazioni.jsp");
//			view.forward(request, response);
		} else {
			mv.addObject("messaggio", "Eliminazione non effettuata");

//			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/StoricoPrenotazioni.jsp");
//			view.forward(request, response);
		}
		
		return mv;
	}

	@RequestMapping("EliminaPrenotazione")
	public ModelAndView doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return doGet(request, response);
	}


}
