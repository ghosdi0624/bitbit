<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	목적 : 1값을 가지는 변수 cnt를 공유영역에 등록(page)<br/>
<%-- 	
	<%
		pageContext.setAttribute("cnt", 1);
	%> 
--%>
	<c:set var="cnt" value="1" />
	공유영역에 등록된 cnt 변수 출력(page)<br/>
	page cnt : ${ cnt }<br/>
	
	변수 cnt에 1 증가(scope)<br/>
	<c:set var="cnt" value="${ cnt + 1 }" scope="request" />
	page cnt : ${ cnt }<br/>
	request cnt : ${ requestScope.cnt }<br/>
</body>
</html>
<!--  
	공유영역 4가지
	[JSP]	:	pageContext		request			session			application
	[EL]	: 	PageScope		requestScope	sessionScope	applicationScope
	[JSTL]	: 	page			request			session			application
-->




