<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Map<String,String> b = new HashMap<String,String>();
	b.put("no","1");
	b.put("title","test");
	pageContext.setAttribute("board", b);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	no : <%=b.get("no")%><br/>
	title : <%=b.get("title") %><br/>
	
	el no : ${ board.no }<br/>
	el title : ${ board.title }<br/>
	el aaa : ${ board.aaa }
	
</body>
</html>