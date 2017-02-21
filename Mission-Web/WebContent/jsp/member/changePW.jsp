<%@page import="kr.co.bit.login.vo.LoginVO"%>
<%@page import="kr.co.bit.member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String pw = request.getParameter("newpw");
	LoginVO vo = (LoginVO)session.getAttribute("userVO");
	String id = vo.getId();

	MemberDAO dao = new MemberDAO();
	dao.lastChangePW(id, pw);
%>

<script>
	alert("비밀번호가 정상적으로 변경되었습니다.");
	window.close();
</script>