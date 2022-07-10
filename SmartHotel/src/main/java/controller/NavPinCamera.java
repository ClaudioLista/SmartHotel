package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.PrenotazioneDAOImpl;
import model.Prenotazione;
import model.Utente;

/**
 * Servlet implementation class NavPrenotaCamera
 */
@Controller
public class NavPinCamera{

	protected ModelAndView doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessione = request.getSession();
		Utente c = (Utente) sessione.getAttribute("utente");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("PinCamera.jsp");
		
		return mv;
	}

	@RequestMapping("NavPinCamera")
	protected ModelAndView doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return doGet(request, response);
	}

}
