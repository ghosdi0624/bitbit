<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="/studyRoom/css/styles.css" rel="stylesheet" type="text/css">


<title>Insert title here</title>
</head>
<body>
	<!-- 네비게이션 Bar -->
	<div class="header">
		<nav class="navbar navbar-inverse navbar-static-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand"
					href="${ pageContext.request.contextPath }/main.do">노량진스터디룸</a>
			</div>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="${ pageContext.request.contextPath }/about.do">소개</a></li>
				<li><a href="${ pageContext.request.contextPath }/list.do">게시판</a></li>
				<c:if test="${ not empty sessionScope.id }">
				<li><a href="${ pageContext.request.contextPath }/reserveForm.do">예약하기</a></li>
				</c:if>
				<li><a href="${ pageContext.request.contextPath }/join.do"><span
						class="glyphicon glyphicon-user"></span> 회원가입</a></li>

				<c:if test="${ empty sessionScope.id }">
					<li><a
						href="${ pageContext.request.contextPath }/loginForm.do"> <span
							class="glyphicon glyphicon-log-in"></span> 로그인
					</a></li>
				</c:if>
				<c:if test="${ not empty sessionScope.id }">
					<c:if test="${sessionScope.type eq 'u'}">
						<li><a href="${ pageContext.request.contextPath }/myPage.do">마이페이지</a></li>
					</c:if>
					<c:if test="${sessionScope.type eq 'a'}">
						<li><a href="${ pageContext.request.contextPath }/adminPage.do">관리페이지</a></li>
					</c:if>
					<li><a href="${ pageContext.request.contextPath }/logOut.do">
							<span class="glyphicon glyphicon-log-out"></span> 로그아웃
					</a></li>
				</c:if>
			</ul>
		</div>
		</nav>
	</div>
</body>
</html>