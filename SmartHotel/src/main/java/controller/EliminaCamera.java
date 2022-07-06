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

import dao.CameraDAOImpl;
import dao.PrenotazioneDAOImpl;
import dao.UtenteDAOImpl;
import model.Utente;

/**
 * Servlet implementation class EliminaPrenotazione
 */
@Controller
public class EliminaCamera {
	
	public ModelAndView doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView("VisualizzaCamere.jsp");
		
		String ids = request.getParameter("id");
		if (ids != null) {

			CameraDAOImpl camDAO = new CameraDAOImpl();
			
			camDAO.updateVisibilita(ids, !camDAO.get(ids).isPrenotabile());

			ArrayList<model.Camera> listaCamere = camDAO.list();
			
			request.removeAttribute("listaCamere");
			mv.addObject("listaCamere", listaCamere);
			mv.addObject("messaggio", "Visibilit� modificata ");

//			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/StoricoPrenotazioni.jsp");
//			view.forward(request, response);
		} else {
			mv.addObject("messaggio", "Visibilit� non modificata");

//			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/StoricoPrenotazioni.jsp");
//			view.forward(request, response);
		}
		
		return mv;
	}

	@RequestMapping("EliminaCamera")
	public ModelAndView doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return doGet(request, response);
	}


}
