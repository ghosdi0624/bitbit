<%@page import="kr.co.bit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	// 객체 생성 및 초기화
	MemberVO member = new MemberVO();
	member.setId(id);
	member.setPw(pw);
	
	session.setAttribute("member", member);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>세션 등록 완료</h2>
	<a href= "get.jsp">세션 보기</a>
</body>
</html>