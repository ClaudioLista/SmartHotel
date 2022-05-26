package controller;


import java.io.IOException;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;


import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.UtenteDAOImpl;
import model.Utente;

/**
 * Servlet implementation class Login
 */
@Controller
public class LoginController {
	//private static final long serialVersionUID = 1L;
	
	public ModelAndView doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("LoginAvvenuto.jsp");
		
		String email = request.getParameter("email");
		if (email == null)
			mv.addObject("messaggio", "Errore, campo Email non compilato");
		else {
			//TO-DO aggiustare matches, aggiuntere controllo email
			if (email.length() < 1  ||  email.length() > 254 )
				mv.addObject("messaggio", "Errore, campo Email non valido");
			else {
				
				
				String password = request.getParameter("password");
				if (password == null)
					mv.addObject("messaggio", "Errore, campo Password non compilato");
				else {
					if (!password.matches("^\\w+([\\.-])?\\w+$"))
						mv.addObject("messaggio", "Errore, campo Password non valido");
					else {
						
						System.out.println(email);
						System.out.println(password);
						UtenteDAOImpl userDAO = new UtenteDAOImpl();
						
						Utente utente = userDAO.getbyKey(email, password);
						if(utente == null) {
							mv.addObject("messaggio", "Login fallito");
							System.out.println("Login fallito");
						}
						else {
							
							mv.addObject("utente", utente);
							mv.addObject("nomeUtente", utente.getNome() + " " + utente.getCognome());
				
							System.out.println("Login Avvenuto");
							mv.addObject("messaggio", "Login avvenuto");
							
						}
					}
				}
			}	
		}
		
		return mv;
	}
	
	@RequestMapping("login")
	public ModelAndView doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return doGet(request, response);
	}

}
