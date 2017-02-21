<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
hr{
	border-color:yellow;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="msg" value="Hello JSTL"></c:set>
	value 속성만 지정<c:out value="JSTL"></c:out><br/>
	msg변수 설정/미설정<c:out value="${ msg }" default = "msg 찾을 수 없음"></c:out><br/>
	
	value속성에 tag가 들어간 경우(escapeXml=true) : 
	<c:out value="<hr/>" escapeXml = "false"></c:out>
</body>
</html>