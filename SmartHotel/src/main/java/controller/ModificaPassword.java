package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.UtenteDAOImpl;
import model.Utente;

@Controller
public class ModificaPassword {

	protected ModelAndView doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ModificaPassword.jsp");

		System.out.println("TEST MODIFICA PASSWORD");

		String email = request.getParameter("email");
		if(email == null)
			mv.addObject("messaggio", "Errore, campo 'Email' non compilato");
		else {

			if (email.length() < 1  ||  email.length() > 254 || !email.matches("^(.+)@(.+)$"))
				mv.addObject("messaggio", "Errore, campo 'Email' compilato male");
			else {

				String passw = request.getParameter("password");
				if(passw == null)
					mv.addObject("messaggio", "Errore, campo 'Password' non compilato");
				else {
				
					if (!passw.matches("^\\w+([\\.-])?\\w+$"))
						mv.addObject("messaggio", "Errore, campo 'Password' compilato male");
					else {

						System.out.println(email);
						System.out.println(passw);

						UtenteDAOImpl userDAO = new UtenteDAOImpl();
						Utente utente = userDAO.getbyKey(email, passw);
						if(utente == null) {
							mv.addObject("messaggio", "Errore, Password corrente invalida");
							System.out.println("Errore, Password corrente invalida");
						}
						else {

							String newPassw = request.getParameter("rpassword");
							if(newPassw == null)
								mv.addObject("messaggio", "Errore, campo 'nuova Password' non compilato");
							else {

								if(!newPassw.matches("^\\w+([\\.-])?\\w+$")) {
									mv.addObject("messaggio", "Errore, nuova Password non valida");
									System.out.println("Errore, nuova Password non valida");
								}
								else {
							
									if(userDAO.updatePassword(email, newPassw) == 0)
										mv.addObject("messaggio", "Modifica non avvenuta");
									else
										mv.addObject("messaggio", "Password modificata con successo");
								}
							}
						}
					}
				}
			}
		}
		
		return mv ;
	}
	
	@RequestMapping("/ModificaPassword")
	protected ModelAndView doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return doGet(request, response);
	}
}
