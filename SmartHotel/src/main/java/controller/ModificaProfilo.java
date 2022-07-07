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
public class ModificaProfilo {

	protected ModelAndView doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ModificaProfilo.jsp");

		System.out.println("TEST MODIFICA PROFILO");

		String email = request.getParameter("email");
		if(email == null)
			mv.addObject("messaggio", "Errore, campo 'Email' non compilato");
		else {

			if (email.length() < 1  ||  email.length() > 254 || !email.matches("^(.+)@(.+)$"))
				mv.addObject("messaggio", "Errore, campo 'Email' compilato male");
			else {

				String newindirizzo = request.getParameter("newindirizzo");
				if (newindirizzo == null)
						mv.addObject("messaggio", "Errore, campo Indirizzo non compilato");
					else {
					
						System.out.println("CONTROLLO INDIRIZZO");
						
						String newtelefono = request.getParameter("newtel");
						if (newtelefono == null)
							mv.addObject("messaggio", "Errore, campo Telefono non compilato");
						else {
							UtenteDAOImpl userDAO = new UtenteDAOImpl();
							
							if(userDAO.updateDati(email, newindirizzo, newtelefono)== 0)
								mv.addObject("messaggio", "Modifica non avvenuta");
							else
								mv.addObject("messaggio", "Profilo modificato con successo");
						    }
				
				
			
			            }
				
			}
		}
		return mv ;
	}
	
	@RequestMapping("/ModificaProfilo")
	protected ModelAndView doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return doGet(request, response);
	}
}
