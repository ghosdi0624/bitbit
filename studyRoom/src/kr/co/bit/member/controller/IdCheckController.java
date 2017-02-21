package kr.co.bit.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.controller.Controller;
import kr.co.bit.member.dao.BoardDao;

public class IdCheckController implements Controller {

   @Override
   public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

      request.setCharacterEncoding("utf-8");
      String id = request.getParameter("id");
      
      BoardDao dao = new BoardDao();
      boolean b = dao.selectId(id);
      
      request.setAttribute("b", b);
      request.setAttribute("id", id);
      
      return "/join/IdCheck.jsp";
   }

}