package kr.co.bit.login.control;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bit.framwork.ModelAndView;
import kr.co.bit.framwork.annotation.Controller;
import kr.co.bit.framwork.annotation.RequestMapping;
import kr.co.bit.login.service.LoginService;
import kr.co.bit.login.vo.LoginVO;

@Controller
public class LoginController {

	@RequestMapping("/login/loginForm.do")
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mav = new ModelAndView("/login/loginform.jsp");
		return mav;
	}
	
	@RequestMapping("/login/login.do")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		String idSave = request.getParameter("idSave");
		
		Cookie cookie = new Cookie("loginId", id);
		cookie.setPath("/");
		if(idSave==null){
			cookie.setMaxAge(0);
		} else {
			cookie.setMaxAge(60*60*24);
		}
		response.addCookie(cookie);
		
		LoginVO loginVO = new LoginVO();
		loginVO.setId(id);
		loginVO.setPw(pw);
		
		ServletContext sc = request.getServletContext();
		LoginService service = (LoginService)sc.getAttribute("loginService");
		LoginVO userVO = service.login(loginVO);
		
		// 로그인 성공/실패에 따른 페이지 이동
		
		ModelAndView mav = new ModelAndView();
		
		if(userVO==null){
			mav.setView("redirect:" + request.getContextPath()+"/login/loginForm.do");
		} else {
			mav.setView("redirect:" + request.getContextPath());
			HttpSession session = request.getSession();
			session.setAttribute("userVO", userVO);
		}
/*	
		if(userVO == null){
			mav.addAttribute("msg", "로그인을 실패하였습니다.");
			mav.addAttribute("url", request.getContextPath()+"/login/loginForm.do");
		} else {
			mav.addAttribute("msg", "로그인을 성공하였습니다.");
			mav.addAttribute("url", request.getContextPath());			
		}
		mav.setView("/login/login.jsp");
		
*/		return mav;
	}
	
	@RequestMapping("/login/logout.do")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("로그아웃 호출");
	}
}
