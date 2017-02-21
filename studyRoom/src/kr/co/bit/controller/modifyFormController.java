package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.vo.BoardVO;

public class modifyFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardDAO dao = new BoardDAO();
		// 해당 번호
		int no = Integer.parseInt(request.getParameter("no"));
		// 게시물 조회
		BoardVO board = dao.selectByNo(no);
		// 첨부파일 조회
		// List<BoardFileVO> fileList = dao.selectFileByNo(no);
		request.setAttribute("board", board);
		// request.setAttribute("fileList", fileList);
		
		return "/board/modifyForm.jsp";
	}
}
