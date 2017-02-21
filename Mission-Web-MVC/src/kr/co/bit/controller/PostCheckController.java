package kr.co.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.zipcode.dao.ZipCodeDAO;
import kr.co.bit.zipcode.vo.ZipCodeVO;

public class PostCheckController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		String post = request.getParameter("post");	

		ZipCodeDAO dao = new ZipCodeDAO();
		List<ZipCodeVO> list = dao.getAddr(post);
		
		request.setAttribute("list", list);
		
		return "/member/postCheck.jsp";
	}

}
