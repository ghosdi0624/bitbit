<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>While Example</h1>
	<%
		request.setCharacterEncoding("EUC-KR");
		String msg = request.getParameter("msg");
		int number = Integer.parseInt(request.getParameter("number"));
		int count = 0;
		while (number > count) {
	%>
	<b><%=msg%></b>
	<br/>
	<%
		count++;
		}
	%>
</body>
</html>