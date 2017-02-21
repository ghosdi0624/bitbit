package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.member.dao.MemberDAO;

public class IdCheckController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		
		MemberDAO dao = new MemberDAO();
		boolean b = dao.selectId(id);
		
		request.setAttribute("b", b);
		request.setAttribute("id", id);
		
		return "/member/idCheck.jsp";
	}

}
