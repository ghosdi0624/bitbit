package kr.co.bit.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.bit.member.MemberVO;
import kr.co.bit.member.service.MemberService;

@SessionAttributes("userVO")
@Controller
public class LoginController {
	
	@Autowired
	private MemberService service;
	
	@RequestMapping(value="/login/login.do", method=RequestMethod.GET)
	public String loginform(){
		
		return "login/loginform";
	}
	
	@RequestMapping(value="/login/login.do", method=RequestMethod.POST)
	public String login(@ModelAttribute MemberVO member, Model model, HttpSession session){
		
		MemberVO userVO = service.login(member);
		if(userVO!=null){
			session.setAttribute("userVO", userVO);
			return "redirect:/";
		} else {
			model.addAttribute("msg", "로그인을실패 하였습니다.");
		}
		return "login/login";
	}
	
	@RequestMapping("/login/logout.do")
	public String logout(SessionStatus session){
		
		session.setComplete();
		
		return "redirect:/";
	}
	
/*	@RequestMapping("/login/logout.do")
	public String logout(HttpSession session){
		
		session.invalidate();
		
		return "redirect:/";
	}
	*/
}
