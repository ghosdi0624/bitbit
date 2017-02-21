<%@page import="kr.co.bit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.bit.member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="kr.co.bit.util.ConnectionFactory, 
    java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet, kr.co.bit.util.JDBCClose"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.memberinfo tr:nth-child(odd){
	background-color:#F7F9FC;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Mission-Web/css/layout.css" />
<link rel="stylesheet" href="/Mission-Web/css/board.css" />
</head>
<body>

	<header>
		<jsp:include page="/include/topMenu.jsp"></jsp:include>
	</header>
	<section>
		<div align = "center">
	<h2>회원 정보</h2>
	<hr width = "80%" />
	<br/>
	<table width = "100%" class = "memberinfo">
	<tr style="background-color:lightblue">
		<th>ID</th>
		<th>이름</th>
		<th>비밀번호</th>
		<th>이메일</th>
		<th>전화번호</th>
		<th>우편번호</th>
		<th>주소</th>
		<th>type</th>
	</tr>
	<c:forEach var = "list" items="${ list }">
	<tr>
		<td>${ list.id }</td>
		<td>${ list.name }</td>
		<td>${ list.password }</td>
		<td>${ list.emailId }@${ list.emailDomain }</td>
		<td>${ list.tel1 }-${ list.tel2 }-${ list.tel3 }</td>
		<td>${ list.post }</td>
		<td>${ list.basicAddr }&nbsp;${ list.detailAddr }</td>
		<td>${ list.type }</td>
	</tr>
	</c:forEach>
	</table>
</div>
	</section>
	<footer>
		<%@include file="/include/footer.jsp" %>
	</footer>
</body>
</html>


