package kr.co.bit.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.bit.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	@RequestMapping("/member/memberInfo.do")
	public ModelAndView memberInfo(){
		
		List<MemberVO> list = service.memberInfo();
		
		ModelAndView mav = new ModelAndView("member/memberInfo");
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping("/member/mypage.do")
	public String myPageForm(HttpSession session, Model model){
		
		MemberVO userVO = (MemberVO)session.getAttribute("userVO");
		MemberVO myInfo = service.mypage(userVO);
		model.addAttribute("list", myInfo);
		
		return "member/mypageform";
	}
	
	@RequestMapping("/member/pwproc.do")
	public String pwproc(HttpSession session, Model model){
		
		MemberVO member = (MemberVO)session.getAttribute("userVO");
		String id = member.getId();
		String pw = service.pwproc(id);
		model.addAttribute("pw",pw);
		
		return "member/pwproc";
	}
	
	@RequestMapping("/member/changePW.do")
	public String changPW(@RequestParam("newpw") String password, HttpSession session, Model model){
		
		MemberVO member = (MemberVO)session.getAttribute("userVO");
		String id = member.getId();
		MemberVO memberVO = new MemberVO();
		memberVO.setId(id);
		memberVO.setPassword(password);
		service.changPW(memberVO);
		
		return "member/changePW";
	}
	
	
}
