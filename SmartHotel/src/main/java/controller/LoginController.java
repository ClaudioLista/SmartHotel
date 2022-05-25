package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	
	@RequestMapping("/login")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	{
	
		System.out.println("test ok");
		
		
	}
	
	
}
