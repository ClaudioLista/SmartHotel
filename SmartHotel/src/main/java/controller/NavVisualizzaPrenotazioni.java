package controller;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class NavVisualizzaPrenotazioni
 */
@Controller
public class NavVisualizzaPrenotazioni {

	public ModelAndView doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("VisualizzaPrenotazioni.jsp");

		PrenotazioneDAOImpl prenDAO = new PrenotazioneDAOImpl(); 
		ArrayList<model.Prenotazione> listaPrenotazioni = prenDAO.list();

		mv.addObject("listaPrenotazioni", listaPrenotazioni);
		return mv;
		
	}
	
	@RequestMapping("/VisualizzaPrenotazioni")
	public ModelAndView  doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return doGet(request, response);
	}
	
}
