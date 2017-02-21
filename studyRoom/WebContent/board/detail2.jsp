<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://use.fontawesome.com/70213049c5.js"></script>
<link href="/studyRoom/css/styles.css" rel="stylesheet" type="text/css">
<title><c:out value="${board.title }" escapeXml="false" /></title>
<script type="text/javascript">
	function doList() {
		location.href = "${pageContext.request.contextPath}/list.do";
	}
	function doModify() {
		location.href = "${pageContext.request.contextPath}/modifyForm.do?no=${param.no }";
	}
	function doDel() {
		location.href = "${pageContext.request.contextPath}/delete.do?no=${param.no }";
	}
	function doReply() {
		location.href = "${pageContext.request.contextPath}/writeForm.do?reply=${param.no }";
	}
</script>
<script type="text/javascript"
	src="/jspProject3/jsp/jQuery/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$.ajax({
			url : "comment.do",
			type : "get",
			data : "no=${param.no }&cmtText=" + $("#cmtText").val(),
			success : callback
		});
		$("#cmtBtm").click(function() {
			$.ajax({
				url : "comment.do",
				type : "get",
				data : "no=${param.no }&cmtText=" + $("#cmtText").val(),
				success : callback
			});
		});
	});
	function callback(data) {
		$("#cmt").html(data);
		$("#cmtText").val("")
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
	<h2><c:out value="${board.title }"/></h2>
		<table class="table table-striped">
			<tr class="title">
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>등록일</th>
				<th>조회수</th>
			</tr>
			<tr>
				<td><c:out value=" ${param.no }" /></td>
				<td><c:out value="${board.title }"/></td>
				<td><c:out value="${board.writer }" /></td>
				<td><c:out value="${board.regDate }" /></td>
				<td><c:out value="${board.viewCnt }" /></td>
			</tr>
			<tr>
				<td colspan="5"><c:out value="${board.content }" escapeXml="false" /></td>
			</tr>
		</table>
		<table>
			<tr>
				<td id="cmt"></td>
			</tr>
		</table>
		<c:if test="${sessionScope.id eq board.writer}">
			<input type="button" class="btn btn-default" value="수정" onclick="doModify()" /> 
			<input type="button" class="btn btn-default" value="삭제" onclick="doDel()" /> 
		</c:if>
		<c:if test="${ not empty id }">
		<input type="button" class="btn btn-default" value="답글" onclick="doReply()" />
		</c:if>
		<input type="button" class="btn btn-default" value="목록" onclick="doList()" />
	</div>
		<div align="center" class="comment-area no-padding blank">
		<div class="status-upload">
		<div class="form">
		<textarea placeholder="댓글을 입력해주세요" id="cmtText"></textarea>
		<input type="button" class="btn btn-success green" value="등록"
						id="cmtBtm" />
		</div>
		</div>
		</div>
</section>
</div>
   <footer>
      <%@include file="/include/footer.jsp"%>
   </footer>

</body>
</html>