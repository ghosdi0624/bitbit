package kr.co.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.member.dao.MemberDAO;
import kr.co.bit.member.vo.MemberVO;

public class MemberInfoController implements Controller {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.selectAllMember();
		
		request.setAttribute("list", list);
		
		return "/member/memberInfo.jsp";
	}

    

}
