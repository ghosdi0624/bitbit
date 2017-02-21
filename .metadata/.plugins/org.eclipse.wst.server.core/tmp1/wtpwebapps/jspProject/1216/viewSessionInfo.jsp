<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>세션정보 확인</title>
</head>
<body>
	<%
		Enumeration en = session.getAttributeNames();
		while(en.hasMoreElements()){
			String name = (String)en.nextElement();
			String value = (String)session.getAttribute(name);
			out.println("session name : "+name+"<br/>");
			out.println("session value : "+value+"<br/><p>");
		}
	%>
</body>
</html>