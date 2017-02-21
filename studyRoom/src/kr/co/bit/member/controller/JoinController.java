package kr.co.bit.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.controller.Controller;
import kr.co.bit.member.dao.BoardDao;
import kr.co.bit.member.vo.BoardVO;

public class JoinController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		BoardVO board=new BoardVO();
		board.setId(request.getParameter("id"));
		board.setName(request.getParameter("name"));
		board.setPassword(request.getParameter("password"));
		board.setPhone(request.getParameter("phone"));
				
		
		BoardDao dao=new BoardDao();
		dao.insertMember(board);
		return "/main.do";
	}	
	
	
}


