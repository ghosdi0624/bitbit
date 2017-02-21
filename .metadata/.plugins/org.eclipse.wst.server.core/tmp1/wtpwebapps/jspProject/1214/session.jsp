<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if(session.isNew()){
		out.println("NEW<br/>");
		out.println("SessionID:"+session.getId()+"<br/>");
		out.println("CreationTime:"+new Date(session.getCreationTime())+"<br/>");
		out.println("LastAccessTime:"+new Date(session.getLastAccessedTime())+"<br/>");
		out.println("Max Inactive Interval:"+session.getMaxInactiveInterval()+"<br/>");
	} else {
		out.println("OLD<br/>");
	}
%>

</body>
</html>