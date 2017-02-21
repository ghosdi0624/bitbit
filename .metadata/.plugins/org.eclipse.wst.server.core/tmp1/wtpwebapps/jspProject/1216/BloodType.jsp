<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import = "java.net.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		request.setCharacterEncoding("utf-8");
	
		String name = request.getParameter("name");
		session.setAttribute("name", name);
		String bloodType = request.getParameter("blood");
	%>
	<jsp:forward page='<%=bloodType + ".jsp"%>'></jsp:forward>
</body>
</html>