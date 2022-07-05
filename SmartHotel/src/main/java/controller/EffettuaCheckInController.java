package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Servlet implementation class NavAreaPersonale
 */
@Controller
public class EffettuaCheckInController {

	protected ModelAndView doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("check-in.jsp");
		int idPrenotazione = Integer.parseInt(request.getParameter("idPrenotazione"));
		mv.addObject("idPrenotazione", idPrenotazione);
		
		return mv;
		
		
	}

	@RequestMapping("EffettuaCheckIn")
	protected ModelAndView doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return doGet(request, response);
	}

}
