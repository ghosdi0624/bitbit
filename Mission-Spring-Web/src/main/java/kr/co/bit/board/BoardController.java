package kr.co.bit.board;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.bit.board.service.BoardService;
import kr.co.bit.member.MemberVO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService service;

	@RequestMapping("/list.do")
	public ModelAndView list() {

		List<BoardVO> list = service.list();

		ModelAndView mav = new ModelAndView("board/list");
		mav.addObject("list", list);

		return mav;
	}

	@RequestMapping("/{no}/detail.do")
	public ModelAndView detailNo(@PathVariable("no") int no) {

		BoardVO board = service.detail(no);

		ModelAndView mav = new ModelAndView("board/detail");
		mav.addObject("board", board);

		return mav;
	}

	@RequestMapping("/detail.do")
	public ModelAndView detail(@RequestParam("no") int no) {

		BoardVO board = service.detail(no);

		ModelAndView mav = new ModelAndView("board/detail");
		mav.addObject("board", board);

		return mav;
	}

	@RequestMapping(value="/write.do", method=RequestMethod.GET)
	public String writeForm(Model model, HttpSession session){
		
		BoardVO boardVO = new BoardVO();
		MemberVO userVO = (MemberVO)session.getAttribute("userVO");
		String id = userVO.getId();
		boardVO.setWriter(id);
		model.addAttribute("boardVO", boardVO);
		
		return "board/writeForm";
	}
	
	@RequestMapping(value="/write.do", method=RequestMethod.POST)
	public String write(@ModelAttribute @Valid BoardVO boardVO, BindingResult result){
		
		if(result.hasErrors()){
			System.out.println("오류 발생...");
			return "board/writeForm";
		}
		
		System.out.println(boardVO);
//		service.insert(boardVO);
		return "board/write";
	}
	
	@RequestMapping("/{no}/delete.do")
	public String delete(@PathVariable("no") int no){
		
		service.delete(no);
		
		return "redirect:/board/list.do";
	}
}
