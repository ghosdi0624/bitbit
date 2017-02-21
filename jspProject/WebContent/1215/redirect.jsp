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
		// sendreDirect
		// request, response가 유지되지 않고 새로 만들어짐
		// 이동된 url이 화면에 보임
		response.sendRedirect("http://www.google.com");
	%>
</body>
</html>