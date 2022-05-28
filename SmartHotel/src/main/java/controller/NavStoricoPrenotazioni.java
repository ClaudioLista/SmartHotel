package controller;

import java.io.IOException;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//import dao.PrenotazioneDAO;
import dao.PrenotazioneDAOImpl;
import model.*;

/**
 * Servlet implementation class NavStoricoPrenotazioni
 */
@Controller
public class NavStoricoPrenotazioni {

	public ModelAndView doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("StoricoPrenotazioni.jsp");
		
		HttpSession sessione = request.getSession();

		Utente c = (Utente) sessione.getAttribute("utente");

//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//		LocalDate localDate = LocalDate.now();
//		Date dtf = new Date();
//		System.out.println(dtf);

		PrenotazioneDAOImpl prenDAO = new PrenotazioneDAOImpl(); 
		//ArrayList<model.Prenotazione> listaPrenotazioni = prenDAO.getbyDate(c.getEmail(), dtf.format(localDate));
		ArrayList<model.Prenotazione> listaPrenotazioni = prenDAO.getbyDate(c.getEmail());

		mv.addObject("listaPrenotazioni", listaPrenotazioni);

		//RequestDispatcher view = request.getRequestDispatcher("WEB-INF/StoricoPrenotazioni.jsp");
		//view.forward(request, response);
		
		return mv;
	}
	
	@RequestMapping("/NavStoricoPrenotazioni")
	public ModelAndView  doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return doGet(request, response);
	}
	
}
