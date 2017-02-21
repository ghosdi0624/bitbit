<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String id = (String)session.getAttribute("id");
	String pw = (String)session.getAttribute("pw");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>세션 결과</h2>
	세션에 등록된 id : ${ sessionScope.id }<br/>
	세션에 등록된 pw : ${ sessionScope.pw }<br/><br/>
	
	세션에 등록된 id : <c:out value="${ sessionScope.id }"/><br/>
	세션에 등록된 pw : <c:out value="${ sessionScope.pw }"/><br/></br>
	
	<a href = "remove.jsp">설정된 세션 삭제</a>
</body>
</html>