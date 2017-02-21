package kr.co.bit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PInfoResult extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		String sex = request.getParameter("sex");
		String[] mail = request.getParameterValues("mail");
		String job = request.getParameter("job");
		
		String str = "받지않음";
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		System.out.println(mail.length);
		out.println("<HTML>");
		out.println("<HEAD><TITLE></TITLE></HEAD>");
		out.println("<BODY>");
		out.println("<h1>개인 정보 출력</h1>");
		out.println("이름 : "+name+"<br/>");
		out.println("아이디 : "+id+"<br/>");
		out.println("암호 : "+pw+"<br/>");
		out.println("성별 : "+sex+"<br/>");
		for(int i=0; i<mail.length; i++){
			if(mail[i].equals("공지메일")){
				str = "받음";
			}
		}
		out.println("공지메일 : "+str+"<br/>");
		str="받지않음";
		for(int i=0; i<mail.length; i++){
			if(mail[i].equals("광고메일")){
				str = "받음";
			}
		}
		out.println("광고메일 : "+str+"<br/>");
		str="받지않음";
		for(int i=0; i<mail.length; i++){
			if(mail[i].equals("배송확인메일")){
				str = "받음";
			}
		}
		out.println("배송 확인 메일 : "+str+"<br/>");
		out.println("직업 : "+job+"<br/>");
		out.println("</BODY>");
		out.println("</HTML>");
		
		out.close();
	}

	
}
