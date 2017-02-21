package kr.co.bit.front;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.controller.Controller;

public class FrontController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HandlerMapping mappings;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		String configName = config.getInitParameter("configName");
		//System.out.println("configName : " + configName);
		
		mappings = new HandlerMapping(configName);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {

		String context = request.getContextPath();
		
		String uri = request.getRequestURI();
		uri = uri.substring(context.length());
		
		System.out.println("»£√‚µ» URI : " + uri);
		
		try {
			
			Controller control = mappings.getController(uri);

			String callPage = control.handleRequest(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher(callPage);
			dispatcher.forward(request, response);
//			response.sendRedirect(context + callPage);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	
}