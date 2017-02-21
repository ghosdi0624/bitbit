<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:forEach var="i" begin="1" end="2">
	
</c:forEach>
<c:set var="num"><fmt:formatNumber pattern="00">1</fmt:formatNumber></c:set>
		
	num : ${ num }


	이건 없어지면 안됨 마스터꺼
	이건 없어지면 안됨 마스터꺼
	이건 없어지면 안됨 마스터꺼
</body>
</html>