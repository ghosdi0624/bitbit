package kr.co.bit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MethodServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//	System.out.println("doGet()메소드 호출...");
		
		response.setContentType("text/html; charset=utf-8");
		
		String id = request.getParameter("id");
		System.out.println("id : " + id);
		String method = request.getMethod();
		StringBuffer url = request.getRequestURL();
		String uri = request.getRequestURI();
		
		
		PrintWriter pw = response.getWriter();
		pw.println("<HTML>");
		pw.println("<HEAD><TITLE>출력결과</TITLE></HEAD>");
		pw.println("<BODY>");
		pw.println("================================================<br/>");
		pw.println("&nbsp;&nbsp;&nbsp;&nbsp;출력결과<br/>");
		pw.println("================================================<br/>");
		pw.println("파라미터(id) : " + id + "<br/>");
		pw.println("메소드 : " + method + "<br/>");
		pw.println("요청URL : " + url + "<br/>");
		pw.println("요청URI : " + uri + "<br/>");
		pw.println("================================================<br/>");
		pw.println("</BODY>");
		pw.println("</HTML>");
		
		pw.close();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			request.setCharacterEncoding("utf-8");
		
			String id = request.getParameter("id");
			System.out.println("id : " + id);
			String method = request.getMethod();
			StringBuffer url = request.getRequestURL();
			String uri = request.getRequestURI();
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.println("<HTML>");
			pw.println("<HEAD><TITLE>출력결과</TITLE></HEAD>");
			pw.println("<BODY>");
			pw.println("================================================<br/>");
			pw.println("&nbsp;&nbsp;&nbsp;&nbsp;출력결과<br/>");
			pw.println("================================================<br/>");
			pw.println("파라미터(id) : " + id + "<br/>");
			pw.println("메소드 : " + method + "<br/>");
			pw.println("요청URL : " + url + "<br/>");
			pw.println("요청URI : " + uri + "<br/>");
			pw.println("================================================<br/>");
			pw.println("</BODY>");
			pw.println("</HTML>");
			
			pw.close();
		}

	

	
	
}
