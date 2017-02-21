<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String[] names = {"임꺽정","홍길동","강감찬"};
	pageContext.setAttribute("names", names);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	${ names[0] }<br/>
	${ names[1] }<br/>
	${ names[2] }<br/><p/>

</body>
</html>