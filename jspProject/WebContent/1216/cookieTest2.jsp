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
		Cookie ID = new Cookie("Id", request.getParameter("ID"));
		Cookie PW = new Cookie("Pw", request.getParameter("PW"));
		
		ID.setMaxAge(60*10);
		PW.setMaxAge(60*10);
		
		response.addCookie(ID);
		response.addCookie(PW);
	%>
	<%=request.getParameter("ID") %>
	<%=request.getParameter("PW") %>
</body>
</html>