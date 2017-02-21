package kr.co.bit.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.controller.Controller;

public class LoginFormController implements Controller {

   @Override
   public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
      return "/join/loginForm.jsp";
   }

}