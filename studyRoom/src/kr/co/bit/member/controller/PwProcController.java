package kr.co.bit.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bit.controller.Controller;
import kr.co.bit.member.dao.BoardDao;

public class PwProcController implements Controller {

   public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

      HttpSession session = request.getSession();

      String id = (String) session.getAttribute("id");
      BoardDao member = new BoardDao();
      String pw = member.changePW(id);

      request.setAttribute("pw", pw);

      return "/join/pwproc.jsp";
   }

}