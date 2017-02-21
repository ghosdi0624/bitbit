package kr.co.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.vo.BoardFileVO;
import kr.co.bit.board.vo.BoardVO;
import kr.co.bit.comment.dao.CommentDAO;
import kr.co.bit.comment.vo.CommentVO;

public class DetailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int no = Integer.parseInt(request.getParameter("no"));
		// 해당 번호의 게시물 조회
		BoardDAO dao = new BoardDAO();
		// 첨부 파일 조회
		List<BoardFileVO> fileList = dao.selectFileByNo(no);
		
		CommentDAO cdao = new CommentDAO();
		List<CommentVO> cList = cdao.selectAll(no);
		
		
		int hit = dao.getViewCnt(no);
		dao.addViewCnt(no, hit);
		BoardVO board = dao.selectByNo(no);

		String content = board.getContent().replace("\n","<br/>");
		board.setContent(content);
		
		request.setAttribute("board", board);	
		request.setAttribute("fileList", fileList);
		request.setAttribute("brTag", "<br/>");
		request.setAttribute("enter", "\n");
		
		if(cList != null){
			request.setAttribute("cList", cList);
		}
		
		return "/board/detail.jsp";
	}

}
