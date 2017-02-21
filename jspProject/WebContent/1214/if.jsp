<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>if~else Example</h1>
	<%!String msg;%>
	<%
		String name = request.getParameter("name");
		String color = request.getParameter("color");

		if (color.equals("blue")) {
			msg = "파란색";
		} else if (color.equals("brown")) {
			msg = "갈색";
		} else if (color.equals("red")) {
			msg = "빨간색";
		} else {
			color = "white";
			msg = "기타색";
		}
	%>

<body bgcolor=<%=color%>>
	<b><%=name%></b>님이 좋아하는 색깔은
	<b><%=msg%></b>입니다.
</body>
</html>