<%@page import="kr.co.bit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
/* 	String id = (String)session.getAttribute("id");
	String pw = (String)session.getAttribute("pw"); */
	
	MemberVO member = (MemberVO)session.getAttribute("member");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>세션 결과</h2>
	<%if(member!=null){%>
		
	세션에 등록된 id : <%=member.getId() %><br/>
	세션에 등록된 pw : <%=member.getPw() %><br/>
<%}else{%>
	세션에 등록된 id : 정보 없음<br/>
	세션에 등록된 pw : 정보 없음<br/>
<%}%><br/>
	
	<c:choose>
	<c:when test="${ not empty member }">
	세션에 등록된 id : ${ sessionScope.member.id }<br/>
	세션에 등록된 pw : ${ sessionScope.member.pw }<br/><br/>
	
	세션에 등록된 id : <c:out value="${ sessionScope.member.id }" /><br/>
	세션에 등록된 pw : <c:out value="${ sessionScope.member.pw }" /><br/></br>
	</c:when>
	<c:otherwise>
	설정된 세션이 없습니다.
	</c:otherwise>
	</c:choose>
	<br/>
	
	<a href = "remove.jsp">설정된 세션 삭제</a>
</body>
</html>