<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = session.getId();
	long Time = session.getLastAccessedTime();
	String pattern = "yyyy년 MM월 dd일 hh시 mm분 ss초";
	SimpleDateFormat sdf = new SimpleDateFormat(pattern);

	int interval = session.getMaxInactiveInterval();	
	
	// 세션 유효시간 변경
	session.setMaxInactiveInterval(2);
	int interval2 = session.getMaxInactiveInterval();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	기존의 유효시간 : <%=interval %>초<br/>
	변경된 유효시간 : <%=interval2 %>초<br/>
	세션ID(JSESSION) : <%=id %><br/>
	마지막 접속시간 : <%=sdf.format(new Date(Time)) %><br/>
</body>
</html>