package kr.co.bit.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.bit.member.service.MemberService;
import kr.co.bit.member.vo.MemberVO;
import kr.co.bit.member.vo.reserve.MemberReserveVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	@RequestMapping("/member/member.do")
	public String memberform(@ModelAttribute MemberVO memberVO, HttpServletRequest request){

		
		String emailDomain = request.getParameter("selectMail");
		String email = memberVO.getEmail();
		
		if(email!=null)
			memberVO.setEmail(email+"@"+emailDomain);
		
		service.memberform(memberVO);
		
		return "redirect:/";
	}

	@RequestMapping("member/idcheck.do")
	public String idcheck(@RequestParam("id") String id, Model model){
	
		String result = service.idcheck(id);
		
		boolean b = true;
		if(result==null){
			b = false;
		}
		
		model.addAttribute("b", b);
		model.addAttribute("id", id);
		
		return "member/idCheck";
	}
	
	@RequestMapping("/login/memberlogin.do")
	public String memberlogin(@ModelAttribute MemberVO memberVO, HttpSession session, Model model){
		
		MemberVO userVO = service.memberlogin(memberVO);
		if(userVO!=null){
			session.setAttribute("userVO", userVO);
			return "redirect:/";
		} else {
			model.addAttribute("msg", "로그인을실패 하였습니다.");
		}
		return "login/memberloginform";

	}
	
	@RequestMapping("/login/logout.do")
	public String logout(HttpSession session){
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	@RequestMapping("member/mypage.do")
	public String myPage(HttpSession session, Model model){
		
		MemberVO memberVO = (MemberVO)session.getAttribute("userVO");
		String id = memberVO.getId();
		
		List<MemberReserveVO> list = service.myPage(id);
		
		model.addAttribute("list", list);
		
		return "member/mypage";
	}
}
