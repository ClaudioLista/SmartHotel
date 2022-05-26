package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * Servlet implementation class Logout
 */
@Controller
public class LogoutController {

	public ModelAndView doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView();
		
		request.getSession().invalidate();
		
		mv.setViewName("Homepage.jsp");
		
		
		return mv;
		
		//DA CANCELLARE LE COSE SOTTO
		//request.getSession().removeAttribute("utente");
		//request.getSession().removeAttribute("storicoPrenotazioni");

		//RequestDispatcher view = request.getRequestDispatcher("WEB-INF/Homepage.jsp");
		//view.forward(request, response);

	}

	@RequestMapping("logout")
	public ModelAndView doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return doGet(request, response);
	}

}
