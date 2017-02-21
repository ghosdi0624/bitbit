package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.vo.BoardVO;

public class modifyController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");

		// 게시물 내용
		int no = Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		BoardVO board = new BoardVO();
		board.setNo(no);
		board.setTitle(title);
		board.setContent(content);
		// DB저장
		BoardDAO dao = new BoardDAO();
		dao.modifyByNo(board);

		// return "/list.do";
		request.setAttribute("no", no);
		return "/board/modify.jsp";
	}
}
