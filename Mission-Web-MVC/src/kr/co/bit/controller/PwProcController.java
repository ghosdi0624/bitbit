package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bit.login.vo.LoginVO;
import kr.co.bit.member.dao.MemberDAO;

public class PwProcController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("id");
		MemberDAO member = new MemberDAO();
		String pw = member.changePW(id);
		
		request.setAttribute("pw", pw);
		
		return "/member/pwproc.jsp";
	}

}
