<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/board.css" />
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/layout.css" />
<script type="text/javascript">	
	
	function goWriteForm() {
		location.href = "${ pageContext.request.contextPath }/writeForm.do";
	}

	function doAction(boardNo) {
//		location.href = "${ pageContext.request.contextPath }/board/detail.do?no="+ boardNo;
		location.href = "${ pageContext.request.contextPath }/board/" + boardNo
				+ "/detail.do";

		/* 	<c:choose>
		 <c:when test="${ not empty userVO}" >
		 location.href = "${ pageContext.request.contextPath }/board/detail.do?no=" + boardNo;
		 </c:when>
		 <c:otherwise>
		 if (confirm('로그인 후 사용가능합니다\n로그인하시겠습니까?'))
		 location.href = "${ pageContext.request.contextPath }/loginform.do";
		 </c:otherwise>
		 </c:choose> */
	}
</script>
</head>
<body>
	<header>
		<c:import url="/include/topMenu.do" />
	</header>
	<section>
	<div align="center">
		<br />
		<h2>게시물 목록</h2>
		<hr width="80%" />
		<br />

		<table border="1" width="100%" class="list">
			<tr>
				<th width="7%">번호</th>
				<th>제목</th>
				<th width="16%">글쓴이</th>
				<th width="20%">등록일</th>
				<th width="10%">조회수</th>
			</tr>
			<c:forEach var="board" items="${ list }" varStatus="loop">
				<tr <c:if test="${ loop.count mod 2 eq 0 }">class="even"</c:if>>
					<td>${ board.no }</td>
					<td><a href="javascript:doAction('${ board.no}')"> 
					<c:out value="${ board.title }" />
					</a></td>
					<td>${ board.writer }</td>
					<td>${ board.regDate }</td>
					<td>${ board.viewCnt }</td>

				</tr>
			</c:forEach>

		</table>
		<br /> <br />
	</div>
	</section>
	<footer>
		<c:import url="/include/footer.do" />
	</footer>

</body>
</html>