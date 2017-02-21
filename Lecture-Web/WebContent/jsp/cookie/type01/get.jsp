<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
	
	StringBuilder data = new StringBuilder();
	if(cookies != null){
		for(Cookie c : cookies){
			String cName = c.getName();
			String cValue = c.getValue();
			
			data.append("쿠키이름 : " + cName + ", ");
			data.append("쿠키값 : " +cValue + "<br/>");
		}
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>설정된 쿠키 정보</h2>
	<%=data.toString() %>
	<a href = "makeForm.jsp">쿠키설정 이동</a>
</body>
</html>