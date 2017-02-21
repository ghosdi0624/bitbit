<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://use.fontawesome.com/70213049c5.js"></script>
<link href="/studyRoom/css/styles.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function goWriteForm() {
		location.href = "${pageContext.request.contextPath}/writeForm.do";
	}
</script>
</head>
<body>
<div class="wrapper">
	<header>
		<%@include file="/include/header.jsp"%>
	</header>
	<section>
		<div align="center">
		<h2>질문 게시판</h2>
			<table class="table table-striped">
				<tr class="header">
					<td>No.</td>
					<td>제목</td>
					<td>작성자</td>
					<td>작성일</td>
					<td>조회수</td>
				</tr>
				<c:forEach var="notice" items="${noticelist }">
					<tr>
						<td bgcolor="red"><c:out value="${notice.no }" /></td>
						<td bgcolor="red"><a
							href="${pageContext.request.contextPath}/detail.do?no=${notice.no }"><c:out
									value="${notice.title }" /></a></td>
						<td bgcolor="red"><c:out value="${notice.writer }" /></td>
						<td bgcolor="red"><c:out value="${notice.regDate }" /></td>
						<td bgcolor="red"><c:out value="${notice.viewCnt }" /></td>
					</tr>
				</c:forEach>
				<c:forEach var="board" items="${list }">
					<tr>
						<td><c:out value="${board.no }" /></td>
						<td><a
							href="${pageContext.request.contextPath}/detail.do?no=${board.no }">
								<c:forEach var="i" begin="2" end="${board.depth }" step="1">
									<c:out value="re: " />
								</c:forEach> <c:out value="${board.title }" />
						</a></td>
						<td><c:out value="${board.writer }" /></td>
						<td><c:out value="${board.regDate }" /></td>
						<td><c:out value="${board.viewCnt }" /></td>
					</tr>
				</c:forEach>

			</table>
			<c:if test="${ pg > block }">
				<a href="${ pageContext.request.contextPath }/list.do?pg=1">[◀◀]</a>
				<a
					href="${ pageContext.request.contextPath }/list.do?pg=${ startpage-1 }">[◀전]</a>
			</c:if>
			<c:forEach var="i" begin="${ startpage }" end="${ endpage }">
				<c:if test="${ i == pg }">
                  [${ i }]
         </c:if>
				<c:if test="${ i != pg }">
					<a href="${ pageContext.request.contextPath }/list.do?pg=${ i }">[${ i }]</a>
				</c:if>
			</c:forEach>
			<c:if test="${ endpage < allpage }">
				<a
					href="${ pageContext.request.contextPath }/list.do?pg=${ endpage+1 }">[다음▶]</a>
				<a
					href="${ pageContext.request.contextPath }/list.do?pg=${ allpage }">[▶▶]</a>
			</c:if>
			<br> <br />
			<c:if test="${ not empty id }">
				<input type="button" class="btn btn-default" value="글 등록"
					onclick="goWriteForm()" />
			</c:if>
		</div>
	</section>
</div>
	<footer>
		<%@include file="/include/footer.jsp"%>
	</footer>
</body>
</html>