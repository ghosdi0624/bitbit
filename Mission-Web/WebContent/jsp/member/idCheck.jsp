<%@page import="kr.co.bit.member.dao.MemberDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.co.bit.util.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	
	MemberDAO dao = new MemberDAO();
	boolean b = dao.selectId(id);
	
	pageContext.setAttribute("b", b);
	pageContext.setAttribute("id", id);
	
	

%>
<c:if test="${ not empty id }">
	<c:if test="${ b }">
		<div style="font-size:8pt; color:red">사용불가</div>
	</c:if>
	<c:if test="${ !b }">
		<div style="font-size:8pt">사용가능</div>
	</c:if>
</c:if>


<%-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${ empty id }">
		<div align = "center">
		ID를 입력하세요.
		<input type = "button" value = "확인" onclick = "window.close()"/></div>
	</c:if>
	<c:if test="${ not empty id }">
	<c:if test="${ b }">
		<div align = "center">
		${ id }는 <span style='color:red'>사용할수 없는 ID</span>입니다.
		<input type = "button" value = "확인" onclick = "window.close()"/></div>
	</c:if>
	<c:if test="${ !b }">
		<div align = "center">
		${ id }는 사용 가능한 ID입니다.<p>
		<input type = "button" value = "확인" onclick = "window.close()"/></div>
	</c:if>
	</c:if>
</body>
</html> --%>