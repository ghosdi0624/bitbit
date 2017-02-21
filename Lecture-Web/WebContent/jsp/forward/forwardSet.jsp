<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 
<script type="text/javascript">
	if(${param.id} == 'admin'){
		location.href = "admin.jsp";
	} else{
		location.href = "user.jsp";
	}
</script>
-->
</head>
<body>
<%
	request.setAttribute("id", request.getParameter("id"));
%>
	<h2>결과화면</h2>
	
	<c:if test="${param.id == 'admin'}">
		<jsp:forward page="admin.jsp" />
	</c:if>
	
	<c:if test="${param.id != 'admin'}">
		<jsp:forward page="user.jsp">
			<jsp:param name="id" value = "${ param.id }"></jsp:param>
		</jsp:forward>
	</c:if>
	
</body>
</html>