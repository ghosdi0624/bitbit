<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String ID = (String)session.getAttribute("ID");

	out.println("아이디 "+ID+"로 로그인 한 상태<br/>");
%>
<a href = "loginTest4.jsp">로그아웃</a>
</body>
</html>