package kr.co.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {

	private HandlerMapping mappings;
	
	public void init(ServletConfig config) throws ServletException {

		String configName = config.getInitParameter("configName");
		mappings = new HandlerMapping(configName);
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String context = request.getContextPath(); // --> /Mission-Web-MVC
		String uri = request.getRequestURI(); // --> /Mission-Web-MVC/*.do
		uri = uri.substring(context.length()); // --> /*.do
		
		try {
			Controller control = mappings.getController(uri);
		
			String callPage = control.handleRequest(request, response);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(callPage);
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
