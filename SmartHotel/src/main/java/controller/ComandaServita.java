package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.ComandaDAOImpl;
import model.Comanda;

@Controller
public class ComandaServita {

	protected ModelAndView doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("OrdiniDaServire.jsp");
		
		int idComanda = Integer.parseInt(request.getParameter("idPrenotazione"));
		String addettoBar  = request.getParameter("addettoBar");
		
		
		ComandaDAOImpl comDAOImpl = new ComandaDAOImpl();
		
		if (comDAOImpl.update(idComanda, addettoBar) == 1) {
			mv.addObject("messaggio", "Ordine aggiornato.");
		} else {
			mv.addObject("messaggio", "Errore ordine.");
		}
		
		ComandaDAOImpl comDaoImpl = new ComandaDAOImpl(); 
		ArrayList<Comanda> ordini = comDaoImpl.listNonServiti();

		mv.addObject("listaOrdini", ordini);
		
		return mv;
		
		
	}

	@RequestMapping("ComandaServita")
	protected ModelAndView doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return doGet(request, response);
	}

}
