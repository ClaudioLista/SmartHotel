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
import dao.UtenteDAOImpl;
import model.*;

@Controller
public class NavVisualizzaUtenti {

	public ModelAndView doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("VisualizzaUtenti.jsp");

		UtenteDAOImpl utenteDAO = new UtenteDAOImpl();
		ArrayList<Utente> listaUtenti = utenteDAO.listClienti();

		mv.addObject("listaUtenti", listaUtenti);
		return mv;
		
	}
	
	@RequestMapping("/VisualizzaUtenti")
	public ModelAndView  doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return doGet(request, response);
	}
	
}
