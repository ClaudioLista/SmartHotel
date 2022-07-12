package controller;

import java.io.IOException;
import java.nio.channels.NonReadableChannelException;
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
import dao.ComandaDAOImpl;
import dao.GetTodayDate;
import dao.PrenotazioneDAOImpl;
import dao.ProdottiDAOImpl;
import dao.UtenteDAOImpl;
import model.Camera;
import model.Comanda;
import model.Prenotazione;
import model.Prodotto;
import model.Utente;

/**
 * Servlet implementation class EliminaPrenotazione
 */
@Controller
public class InvioComanda {
	
	public ModelAndView doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView("MieiOrdini.jsp");
		Comanda comanda = new Comanda();
		ArrayList<Prodotto> listaProdotti = new ArrayList<Prodotto>();
		
		ProdottiDAOImpl daoImpl = new ProdottiDAOImpl();
		listaProdotti = daoImpl.list();
		
		GetTodayDate gtd = new GetTodayDate();
		comanda.setDataOrdine(gtd.main());
		comanda.setIntestararioOrdine(request.getParameter("intestatario"));
		
		String ordineString = new String();
		
		double totale = 0;
		for (Prodotto p : listaProdotti) {
			
			String temp = request.getParameter(String.valueOf(p.getIdProdotto()));
			
			if (Integer.parseInt(temp) != 0) {
				
				ordineString = ordineString + p.getNome() + ": " + temp + "; ";
				totale = totale + (p.getPrezzo()*Integer.parseInt(temp));
				
			    totale = Math.round(totale*100.0)/100.0;
				System.out.println(totale);
				
			}
			
		}
		if (totale != 0) {
			
			ordineString = ordineString.substring(0, ordineString.length() - 2); 
			
		}
		
		
		PrenotazioneDAOImpl pDaoImpl = new PrenotazioneDAOImpl();
		Prenotazione prenotazioneAttuale = pDaoImpl.getPrenotazioneAttuale(request.getParameter("intestatario"));
		
		comanda.setNumCamera(prenotazioneAttuale.getCamera());
		comanda.setOrdine(ordineString);
		comanda.setTotale(totale);
		comanda.setIdPrenotazione(prenotazioneAttuale.getIdPrenotazione());
		
		double saldo = prenotazioneAttuale.getSaldo();
		saldo = saldo + totale;
		ComandaDAOImpl comDaoImpl = new ComandaDAOImpl();
		
		if (totale == 0) {
			
			mv.addObject("messaggio", "Ordine vuoto.");
			
		} else {
			
			if(comDaoImpl.save(comanda) == 1)
			{
				mv.addObject("messaggio", "Ordine inviato con successo.");
				pDaoImpl.updateSaldo(prenotazioneAttuale.getIdPrenotazione(), saldo);
			}
			else mv.addObject("messaggio", "Ordine fallito.");
		}
		
		ComandaDAOImpl comDaoImpl1 = new ComandaDAOImpl(); 
		ArrayList<Comanda> ordini = comDaoImpl1.listAttive(prenotazioneAttuale.getIntestatario());

		mv.addObject("listaOrdini", ordini);
		
		return mv;
	}

	@RequestMapping("InvioComanda")
	public ModelAndView doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return doGet(request, response);
	}


}
