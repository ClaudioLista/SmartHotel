package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.CameraDAOImpl;
import dao.PrenotazioneDAOImpl;
import model.Utente;
import model.Camera;

@Controller
public class PrenotaCamera {
	
	
	public ModelAndView doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView("RiepilogoPrenotazione.jsp");
		
		Date checkIn = Date.valueOf(request.getParameter("checkIn"));
		Date checkOut = Date.valueOf(request.getParameter("checkOut"));
		int numOspiti = Integer.parseInt(request.getParameter("numOspiti"));
		String camera =request.getParameter("idCamera");
		
		System.out.println(camera);
				
		CameraDAOImpl cameraDAO = new CameraDAOImpl();
		Camera CameraPrenotazione = cameraDAO.get(camera);
		double prezzoCamera = CameraPrenotazione.getPrezzo();
		long diff = checkOut.getTime() - checkIn.getTime();
		TimeUnit time = TimeUnit.DAYS; 
		int numeroNotti = (int) time.convert(diff, TimeUnit.MILLISECONDS);
		double prezzoTotale = numeroNotti*prezzoCamera;
		System.out.println("PrezzoTotale: "+prezzoTotale);
		
		mv.addObject("checkIn", checkIn);
		mv.addObject("checkOut", checkOut);
		mv.addObject("numOspiti", numOspiti);
		mv.addObject("Camera", CameraPrenotazione);
		mv.addObject("PrezzoTotale", prezzoTotale);
		
		
		return mv;
	}

	@RequestMapping("PrenotaCamera")
	public ModelAndView doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return doGet(request, response);
	}


}