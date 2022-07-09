package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.ProdottiDAOImpl;
import model.Prodotto;

/**
 * Servlet implementation class NavPrenotaCamera
 */
@Controller
public class NavMenu{

	protected ModelAndView doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView();
		
		ProdottiDAOImpl prodDAO = new ProdottiDAOImpl();
		ArrayList<Prodotto> listaProdotti = new ArrayList<Prodotto>();
		listaProdotti = prodDAO.list();
		
		mv.addObject("listaProdotti",listaProdotti);
		mv.setViewName("Menu.jsp");
		
		return mv;
	}

	@RequestMapping("NavMenu")
	protected ModelAndView doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return doGet(request, response);
	}

}
