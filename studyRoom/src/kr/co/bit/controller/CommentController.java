package kr.co.bit.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.vo.BoardCommentVO;

public class CommentController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardCommentVO cmt = new BoardCommentVO();
		BoardDAO dao = new BoardDAO();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		int no = Integer.parseInt(request.getParameter("no"));
		if (request.getParameter("cmtText") != "") {
			cmt.setBoardNo(no);
			cmt.setWriter(id);
			cmt.setComent(request.getParameter("cmtText"));
			dao.insertCmt(cmt);
		}
		ArrayList<BoardCommentVO> cmtList = new ArrayList<>();
		cmtList = dao.selectCmtByNo(no);
		request.setAttribute("cmtList", cmtList);
		
		return "/board/comment.jsp";
	}
}
