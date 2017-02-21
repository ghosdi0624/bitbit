<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/board.css" />
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/layout.css" />
</head>
<body>
	<header>
		<c:import url="/include/topMenu.do" />
	</header>
	
	<section>
	<a href="${ pageContext.request.contextPath }/board/list.do">게시판</a>
	<a href="${ pageContext.request.contextPath }/board/write.do">글등록</a>
	
	<c:if test="${ empty userVO }">
	<a href="${ pageContext.request.contextPath }/login/login.do">로그인</a>
	</c:if>
	<c:if test="${ not empty userVO }">
	<a href="${ pageContext.request.contextPath }/member/mypage.do">마이페이지</a>
	<a href="${ pageContext.request.contextPath }/login/logout.do">로그아웃</a>
	</c:if>
	
	<a href="${ pageContext.request.contextPath }/member/memberInfo.do">회원정보</a>
	</section>
	
	<footer>
		<c:import url="/include/footer.do" />
	</footer>
</body>
</html>