package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.vo.BoardVO;

public class writeController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");

		// 게시물 내용
		String reply = request.getParameter("reply");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		String type = request.getParameter("type");
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		board.setType(type);
		// DB저장
		BoardDAO dao = new BoardDAO();
		if (reply.isEmpty())
			dao.insertBoard(board);
		else {
			board.setNo(Integer.parseInt(reply));
			dao.insertReply(board);
		}

		return "/board/write.jsp";
	}

}
