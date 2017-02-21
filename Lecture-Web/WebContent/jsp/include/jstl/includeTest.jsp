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
	<c:set var="id" value="hong" scope = "request" />
	
	<h1>인클루드전</h1>
	
	<h2>파라미터 미설정</h2>
		<c:import url="one.jsp" />
	<h2>파라미터 설정</h2>	
		<c:import url="one.jsp">
			<c:param name="name" value="hong gil-dong"></c:param>
			<c:param name="age" value="25"></c:param>
		</c:import>
	<h1>인클루드후</h1>
		<c:import url="http://www.naver.com" />
</body>
</html>


