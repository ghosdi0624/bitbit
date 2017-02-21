<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var = "msg" value="hello jstl"/>	
	length("hello jstl") : ${ fn:length("hello jstl") }<br/>
	substring("hello jstl", 2, 8) : ${ fn:substring("hello jstl",2,8) }<br/>
	
	length("hello jstl") : ${ fn:length(msg) }<br/>
	substring("hello jstl", 2, 8) : ${ fn:substring(msg,2,8) }<br/>
</body>
</html>