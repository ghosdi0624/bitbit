package kr.co.bit.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bit.controller.Controller;
import kr.co.bit.member.dao.BoardDao;

public class ChangePWController implements Controller {

   @Override
   public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

      HttpSession session = request.getSession();
      
      request.setCharacterEncoding("utf-8");
      String pw = request.getParameter("newpw");
      String id = (String)session.getAttribute("id");

      BoardDao dao = new BoardDao();
      dao.lastChangePW(id, pw);
      
      return "/join/changePW.jsp";
   }

}