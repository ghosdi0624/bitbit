package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class writeFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String reply = request.getParameter("reply");
		request.setAttribute("reply", reply);
		return "/board/writeForm.jsp";
	}
}
