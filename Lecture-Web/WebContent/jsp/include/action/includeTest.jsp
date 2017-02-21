<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setAttribute("id", "hong");
%>
	msg : <%=msg %><br/>
	
	<h1>인클루드전</h1>
	
	<h2>파라미터 미설정</h2>
	<jsp:include page="one.jsp" />
	
	<h2>파라미터 설정</h2>	
	<jsp:include page="one.jsp">
		<jsp:param value="hong gil-dong" name="name"/>
		<jsp:param value="25" name="age"/>
	</jsp:include>
	
	<h1>인클루드후</h1>
</body>
</html>