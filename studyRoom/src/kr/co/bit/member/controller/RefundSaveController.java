package kr.co.bit.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.controller.Controller;
import kr.co.bit.member.dao.ResvDao;

public class RefundSaveController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ResvDao dao = new ResvDao();
		String[] no = request.getParameterValues("no");
		String[] payment = request.getParameterValues("payment");
		for (int i = 0; i < no.length; i++) {
			dao.updateResv(no[i], payment[i]);
		}
		
		return "/admin/admin.jsp";
	}

}
