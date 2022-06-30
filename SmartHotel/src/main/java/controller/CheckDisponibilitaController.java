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

import dao.CameraDAOImpl;
import dao.PrenotazioneDAOImpl;
import dao.UtenteDAOImpl;
import model.Utente;

@Controller
public class CheckDisponibilitaController {
	//private static final long serialVersionUID = 1L;
	
	public ModelAndView doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("VisualizzaCamereDisponibili.jsp");
		
		String checkInString = request.getParameter("check-in");
		Date checkIn = Date.valueOf(checkInString);
		
		if (checkIn == null)
			mv.addObject("messaggio", "Errore, campo Check-In non compilato");
		
		
		
		String checkOutString = request.getParameter("check-out");
		Date checkOut = Date.valueOf(checkOutString);
		
		if (checkOut == null)
			mv.addObject("messaggio", "Errore, campo Check-Out non compilato");	
		
		if (checkOut.getTime()-checkIn.getTime()<=0)
		{
			mv.addObject("messaggio", "Errore, il Check-Out deve venire dopo il Check-In");
			mv.setViewName("RicercaDisponibilita.jsp");
		}
		
		else {
		String NumOspitiString = request.getParameter("numOspiti");
		int NumOspiti = Integer.valueOf(NumOspitiString);
				if (NumOspiti == 0)
					mv.addObject("messaggio", "Errore, campo NumOspiti non compilato");
				
				PrenotazioneDAOImpl PrenDao = new PrenotazioneDAOImpl(); 
				ArrayList<model.CameraDisponibile> listaCamere = PrenDao.getCamereDisponibili(checkIn, checkOut, NumOspiti);
				
				mv.addObject("listaCamere", listaCamere);
				System.out.println(listaCamere);
				mv.addObject("checkIn",checkIn);
				mv.addObject("checkOut",checkOut);
				mv.addObject("numOspiti",NumOspiti);
		}		
		return mv;
	}
	
	@RequestMapping("RicercaDisponibilita")
	public ModelAndView doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return doGet(request, response);
	}

}