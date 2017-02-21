package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bit.login.vo.LoginVO;
import kr.co.bit.member.dao.MemberDAO;
import kr.co.bit.member.vo.MemberVO;

public class MyPageFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		
		MemberDAO dao = new MemberDAO();
		LoginVO loginVO = new LoginVO();
		
		loginVO = (LoginVO)session.getAttribute("userVO");
		String id = loginVO.getId();
		
		MemberVO list = dao.selectMyInfo(id);
		request.setAttribute("list", list);
		
		return "/member/mypageform.jsp";
	}

}
