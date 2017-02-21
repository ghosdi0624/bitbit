package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.board.dao.BoardDAO;

public class deleteController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("sss");
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println(no);
		BoardDAO dao = new BoardDAO();
		dao.delete(no);
		return "/list.do";
	}
}
