package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.PrenotazioneDAOImpl;
import model.Utente;

@Controller
public class AggiungiPrenotazioneController {
	
	
	public ModelAndView doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView("VisualizzaPrenotazioni.jsp");
		
		Date checkIn = Date.valueOf(request.getParameter("checkIn"));
		Date checkOut = Date.valueOf(request.getParameter("checkOut"));
		
		long differenza = checkOut.getTime()-checkIn.getTime();
				if(differenza<0) {
					mv.addObject("messaggio", "Il checkOut deve venire dopo il checkIn");
				}
		int camera =Integer.parseInt(request.getParameter("numCamera"));
		
		return mv;
	}

	@RequestMapping("AggiungiPrenotazione")
	public ModelAndView doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return doGet(request, response);
	}


}