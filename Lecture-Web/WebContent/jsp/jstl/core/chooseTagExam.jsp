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
	<!-- http://localhost:8080/Lecture-Web/jsp/jstl/core/ifTagExam.jsp?num=12  -->
	<c:choose>
		<c:when test="${ empty param.num }">
			<c:out value="파라미터가 전송되지 않았습니다."></c:out>
		</c:when>
		<c:when test="${ param.num % 2 == 0 }">
			<c:out value="${ param.num }은 짝수 입니다."></c:out>
		</c:when>
		<c:otherwise>
			<c:out value="${ param.num }은 홀수 입니다."></c:out>
		</c:otherwise>
	</c:choose>
</body>
</html>