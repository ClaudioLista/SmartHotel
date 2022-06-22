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
import dao.CameraDAOImpl;
import model.*;

/**
 * Servlet implementation class NavVisualizzaPrenotazioni
 */
@Controller
public class NavGestioneCamera {

	public ModelAndView doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("VisualizzaCamere.jsp");

		CameraDAOImpl CamDAO = new CameraDAOImpl(); 
		ArrayList<model.Camera> listaCamere = CamDAO.list();

		mv.addObject("listaCamere", listaCamere);
		return mv;
		
	}
	
	@RequestMapping("/VisualizzaCamere")
	public ModelAndView  doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return doGet(request, response);
	}
	
}
