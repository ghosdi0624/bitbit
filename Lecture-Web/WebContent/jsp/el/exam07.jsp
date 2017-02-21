<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<String> array = new ArrayList<String>();
	array.add("홍길동");
	array.add("임꺽정");
	array.add("강감찬");
	pageContext.setAttribute("names",array);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= array.get(0) %><br/>
	<%= array.get(1) %><br/>
	<%= array.get(2) %><p/>
	
	${ names[0] }<br/>
	${ names[1] }<br/>
	${ names[2] }<br/>
</body>
</html>