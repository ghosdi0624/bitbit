package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.member.dao.MemberDAO;

public class MemberProcController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String selectmail = request.getParameter("selectMail");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String post = request.getParameter("post");
		String basic_addr = request.getParameter("basic_addr");
		String addr = request.getParameter("addr");
		
		
		MemberDAO member = new MemberDAO();
		member.insertMember(id, pw, name, email, selectmail, tel1, tel2, tel3, post, basic_addr, addr);
		
		return "/member/memberproc.jsp";
	}

}
