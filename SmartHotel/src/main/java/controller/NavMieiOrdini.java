package controller;

import java.io.IOException;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.ComandaDAOImpl;
//import dao.PrenotazioneDAO;
import dao.PrenotazioneDAOImpl;
import model.*;

@Controller
public class NavMieiOrdini {

	public ModelAndView doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("MieiOrdini.jsp");
		
		HttpSession sessione = request.getSession();
		Utente c = (Utente) sessione.getAttribute("utente");
		
		ComandaDAOImpl comDaoImpl = new ComandaDAOImpl(); 
		ArrayList<Comanda> ordini = comDaoImpl.listAttive(c.getEmail());

		mv.addObject("listaOrdini", ordini);
		
		return mv;
	}
	
	@RequestMapping("NavMieiOrdini")
	public ModelAndView  doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return doGet(request, response);
	}
	
}
