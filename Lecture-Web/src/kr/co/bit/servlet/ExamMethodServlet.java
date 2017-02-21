package kr.co.bit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ExamMethodServlet extends HttpServlet {


	protected long getLastModified(HttpServletRequest req) {
		return super.getLastModified(req);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name = request.getParameter("name");
		String hobby[] = request.getParameterValues("hobby");
		
		System.out.println("이름 : " + name);
		System.out.print("취미 : ");
		for(int i=0; i<hobby.length; i++){
			System.out.print(hobby[i]+" ");
		}
		
		PrintWriter pw = response.getWriter();
		
	}

	
}
