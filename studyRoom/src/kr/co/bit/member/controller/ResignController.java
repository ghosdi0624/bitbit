package kr.co.bit.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bit.controller.Controller;
import kr.co.bit.member.dao.BoardDao;

public class ResignController implements Controller {

   @Override
   public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
      HttpSession session = request.getSession();
      BoardDao dao = new BoardDao();
      String id = (String)session.getAttribute("id");
      dao.deleteMember(id);
      session.invalidate();
      return "/mainPage.jsp";
   }
}