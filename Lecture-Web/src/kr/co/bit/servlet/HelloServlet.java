package kr.co.bit.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class HelloServlet extends HttpServlet{
	
	
	public void init(ServletConfig config) throws ServletException{
		System.out.println("한번만 실행되는 메소드 입니다.");
	}
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException{
		System.out.println("실제 작업이 수행되는 메소드 입니다.");
		System.out.println("사용자 요청을 처리하는 메소드 입니다.");
	}
}
