package kr.co.bit.error;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ErrorServlet")
public class ErrorServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<HTML>");
		out.println("<HEAD><TITLE>오류처리페이지</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("<h1>오류내용</h1>");
		Exception e = (Exception)request.getAttribute("exception");
		out.println(e.getMessage()+"<br/>");
		out.println("</BODY>");
		out.println("</HTML>");
	}
}
