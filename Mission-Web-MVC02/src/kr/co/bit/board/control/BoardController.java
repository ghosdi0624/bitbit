package kr.co.bit.board.control;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.service.BoardService;
import kr.co.bit.board.vo.BoardVO;
import kr.co.bit.framwork.ModelAndView;
import kr.co.bit.framwork.annotation.Controller;
import kr.co.bit.framwork.annotation.RequestMapping;

@Controller
public class BoardController {
	
	@RequestMapping("/board/list.do")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response){
		
		ServletContext sc = request.getServletContext();
		BoardService service = (BoardService)sc.getAttribute("boardService");

		List<BoardVO> list = service.selectAllBoard();
		
		ModelAndView mav = new ModelAndView();
		mav.setView("/board/list.jsp");
		mav.addAttribute("list", list);			// 모델객체에 추가
			
		return mav;
	}
	
	
	@RequestMapping("/board/writeForm.do")
	public void writeForm(HttpServletRequest request, HttpServletResponse response){
		System.out.println("게시판 등록 호출");
	}
}
