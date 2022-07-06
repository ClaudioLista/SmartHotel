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

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.CameraDAOImpl;
import dao.PrenotazioneDAOImpl;
import dao.UtenteDAOImpl;
import model.Camera;
import model.Utente;

/**
 * Servlet implementation class EliminaPrenotazione
 */
@Controller
public class AggiungiCamera {
	
	public ModelAndView doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView("VisualizzaCamere.jsp");
		Camera cam = new Camera();
	
		int numCamera = Integer.parseInt(request.getParameter("numCamera"));
		CameraDAOImpl camDAO = new CameraDAOImpl();
		
		if (camDAO.getbyNumCamera(numCamera) != null) {
			
			ArrayList<model.Camera> listaCamere = camDAO.list();
			mv.addObject("listaCamere", listaCamere);
			mv.addObject("messaggio", "Numero camera già esistente!");
			
		}
		else {
			
			cam.setNumCamera(numCamera);
			cam.setNumPosti(Integer.parseInt(request.getParameter("numPosti")));
			cam.setTipo(request.getParameter("tipoCamera"));
			cam.setDimensione(Integer.parseInt(request.getParameter("dimCamera")));
			cam.setDescrizione(request.getParameter("desCamera"));
			cam.setPrezzo(Double.parseDouble(request.getParameter("prezzoCamera")));
			cam.setPrenotabile(true);
			
			if (camDAO.save(cam) == 1) {
				
				ArrayList<model.Camera> listaCamere = camDAO.list();
				mv.addObject("listaCamere", listaCamere);
				
				mv.addObject("messaggio", "Camera aggiunta con successo!");
				
			} else {
				mv.addObject("messaggio", "Camera non aggiunta!");
			}
			
		}
		
		return mv;
	}

	@RequestMapping("AggiungiCamera")
	public ModelAndView doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return doGet(request, response);
	}


}
