<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// JSP 공유영역 4가지 : pageContext, request, session, application
	// 객체등록 --> 공유영역.setAttribute("이름", "값");
	pageContext.setAttribute("msg", "page영역에 등록");
	request.setAttribute("id", "aaa");
	request.setAttribute("msg", "request 메세지");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String message = (String)pageContext.getAttribute("msg");
%>
	msg : ${ msg } <br />
	msg : ${ requestScope.msg }<br />
	msg : <%=message %><br />
	id : ${ id }
	
</body>
</html>