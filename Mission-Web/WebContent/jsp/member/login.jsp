<%@page import="kr.co.bit.login.dao.LoginDAO"%>
<%@page import="kr.co.bit.login.vo.LoginVO"%>
<%@page import="kr.co.bit.util.JDBCClose"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.co.bit.util.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	LoginVO loginVO = new LoginVO();
	loginVO.setId(id);
	loginVO.setPw(pw);
	
	LoginDAO dao = new LoginDAO();
	LoginVO userVO = dao.login(loginVO);
		
	String msg = "";
	String url = "";
	if(userVO == null){
		msg = "아이디 또는 패스워드가 잘못 입력되었습니다.";
		url = "/Mission-Web/jsp/member/loginform.jsp";
	} else{
		if(userVO.getType().equals("S")){
			msg = "관리자님 환영합니다.";
		} else{
			msg = userVO.getId()+"님 환영합니다.";	
		}
		url = "/Mission-Web";
		//세션 영역에 등록
		session.setAttribute("userVO", userVO);
	}
	pageContext.setAttribute("msg", msg);
	pageContext.setAttribute("url", url);
%>
<script>
	alert("${msg}");
	location.href = "${url}";
</script>
