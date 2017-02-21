
<%@page import="kr.co.bit.member.vo.BoardVO"%>
<%@page import="kr.co.bit.member.vo.ResvVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<header> <%@include file="/include/header.jsp"%>
</header>
<body>
<div class="wrapper">
	<div align="center">
		<div class="page-title">예약자 현황</div>
		<table class="table table-striped">
			<tr>
				<th width="5%">예약번호</th>
				<th width="10%">아이디</th>
				<th width="10%">이름</th>
				<th width="10%">전화번호</th>
				<th width="5%">방번호</th>
				<th width="5%">인원수</th>
				<th width="5%">결제내역</th>
				<th width="15%">예약날짜</th>
			</tr>

		</table>
	</div>
</div>
	<footer> <%@include file="/include/footer.jsp"%>
	</footer>
</body>
</html>