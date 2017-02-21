package kr.co.bit.member.service;

import kr.co.bit.framwork.ModelAndView;
import kr.co.bit.framwork.annotation.RequestMapping;

public class MemberController {

	@RequestMapping("/member/newmemberform.do")
	public ModelAndView newmember(){
		ModelAndView mav = new ModelAndView("/member/newmemberform.jsp");
		return mav;
	}
}
