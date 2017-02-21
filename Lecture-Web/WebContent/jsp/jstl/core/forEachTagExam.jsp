<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String[] names = {"홍길동","고길동","최길동","박길동"};
	pageContext.setAttribute("length", names.length);
	pageContext.setAttribute("names", names);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:forEach var = "element" items="${ names }" varStatus="loop">
		${ loop.first }:${ loop.last }:${ loop.index }:${ loop.count }<br/>
	</c:forEach>
	
	<br/>
	<c:forEach var="name" items="${ names }" varStatus="loop">
		<c:if test="${ !loop.first }">
			,
		</c:if>
		${ name }
	</c:forEach>
	
	<br/>
	<c:forEach var="i" begin="0" end="${ length-1 }">
		<c:if test="${ i != 0 }">
			,
		</c:if>
		${ names[i] }<%-- <c:if test="${ i != length-1 }">,</c:if> --%>
	</c:forEach>


	<h2>1 - 10 사이의 정수 출력</h2>
	<c:forEach var="i" begin="1" end="10">
		<c:out value="${ i }"></c:out>
	</c:forEach>
	<br/>
	
	년도 선택
	<select>
		<c:forEach var="year" begin="1950" end="2017" step = "2">
			<option>${ year }</option>
		</c:forEach>
	</select>
		
</body>
</html>