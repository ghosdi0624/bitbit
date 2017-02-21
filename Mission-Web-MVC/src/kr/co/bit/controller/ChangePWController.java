package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bit.login.vo.LoginVO;
import kr.co.bit.member.dao.MemberDAO;

public class ChangePWController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("utf-8");
		String pw = request.getParameter("newpw");
		LoginVO vo = (LoginVO)session.getAttribute("userVO");
		String id = vo.getId();

		MemberDAO dao = new MemberDAO();
		dao.lastChangePW(id, pw);
		
		return "/member/changePW.jsp";
	}

}
