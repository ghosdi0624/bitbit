package kr.co.bit.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bit.controller.Controller;
import kr.co.bit.member.dao.ResvDao;
import kr.co.bit.member.vo.ResvVO;

public class MyPageController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		ResvDao dao = new ResvDao();
		String id = (String) session.getAttribute("id");
		List<ResvVO> list = dao.getResvById(id);
		request.setAttribute("info", list);
		
		return "/join/myPage.jsp";

	}
}
