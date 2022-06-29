package controller;

import java.io.IOException;
import java.sql.Date;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.UtenteDAOImpl;
import model.Utente;

@Controller
public class RegistrazioneController {
	//private static final long serialVersionUID = 1L;
	
	protected ModelAndView doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login.jsp");
		
		System.out.println("TEST REGISTRAZIONE");

		String nome = request.getParameter("nome");
		if (nome == null)
			mv.addObject("messaggio", "Errore, campo Nome non compilato");
		else {
			if (nome.length() < 2 || nome.length() > 25 || !nome.matches("^[a-zA-Z]+$"))
				mv.addObject("messaggio", "Errore, campo Nome compilato male");
			else {

				String cognome = request.getParameter("cognome");
				if (cognome == null)
					mv.addObject("messaggio", "Errore, campo Cognome non compilato");
				else {
					if (cognome.length() < 2 || cognome.length() > 25 || !cognome.matches("^[a-zA-Z]+$"))
						mv.addObject("messaggio", "Errore, campo Cognome compilato male");
					else {

						String email = request.getParameter("email");
						if (email == null)
							mv.addObject("messaggio", "Errore, campo Email non compilato");
						else {
							if (email.length() < 1 || email.length() > 254)
								mv.addObject("messaggio", "Errore, campo Email compilato male");
							else {

								String password = request.getParameter("password");
								if (password == null)
									mv.addObject("messaggio", "Errore, campo Password non compilato");
								else {
									
									System.out.println("CONTROLLO PASSWORD");
									
									if (!password.matches("^\\w+([\\.-])?\\w+$"))
										mv.addObject("messaggio", "Errore, campo Password compilato male");
									else {
										
										String dataString = request.getParameter("data");
										Date dataNascita = Date.valueOf(dataString);
										
										System.out.println("CONTROLLO DATA");
										
										if (dataNascita == null)
											mv.addObject("messaggio", "Errore, campo Data Nascita non compilato");
										else {
											
											//TO-DO aggiustare matches
											if (!dataString.matches("^\\d{4}-\\d{2}-\\d{2}$"))
												mv.addObject("messaggio", "Errore, campo data compilato male");
											else {
												
												String indirizzo = request.getParameter("indirizzo");
 												if (indirizzo == null)
 													mv.addObject("messaggio", "Errore, campo Indirizzo non compilato");
 												else {
													
 													System.out.println("CONTROLLO INDIRIZZO");
 													
 													String telefono = request.getParameter("tel");
 													if (telefono == null)
 	 													mv.addObject("messaggio", "Errore, campo Telefono non compilato");
 													else {
														
 														UtenteDAOImpl userDAO = new UtenteDAOImpl();

 														if (userDAO.getbyEmail(email) == null) {
 																
 															Utente user = new Utente();
 															user.setNome(nome);
 															user.setCognome(cognome);
 															user.setEmail(email);
 															user.setPassword(password);
 															user.setDataNascita(dataNascita);
 															user.setIndirizzo(indirizzo);
 															user.setTelefono(telefono);
 															user.setTipoUtente(1);
 															
 															System.out.print(user.toString());
 															
 															try {
 																if (userDAO.save(user) != 0)
 																	mv.addObject("messaggio", "Registrazione avvenuta");
 																else
 																	mv.addObject("messaggio", "Registrazione fallita");
 															} catch (Exception e) {
 																mv.addObject("messaggio", "Registrazione fallita");
 															}
 															
 														} else
 															mv.addObject("messaggio", "Utente già esistente");
 														
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		return mv;
		
		//RequestDispatcher view = request.getRequestDispatcher("WEB-INF/Login.jsp");
		//view.forward(request, response);
	}

	@RequestMapping("/Registrazione")
	protected ModelAndView doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return doGet(request, response);
	}
}
