package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TopMenuController implements Controller {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return "/include/topMenu.jsp";
	}

}
