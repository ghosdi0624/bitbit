<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%--
	1. No. 파라미터를 얻기
	2. No에 해당하는 게시물 조회(t_board) : DAO
	3. 조회된 게시물(VO)을 화면에 출력    
--%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#comm {
	border: 1px solid lightblue;
	width: 100%;
	height: 100px;
	font-size: 10pt;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/board.css" />
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/layout.css" />
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">
	function doAction(type){
		switch(type){
		case 'L' : 
			location.href = "${ pageContext.request.contextPath}/board/list.do"; 
			break;
		case 'D' :
			if(confirm("삭제하시겠습니까?")){
				location.href = "${ pageContext.request.contextPath}/board/"+${board.no}+"/delete.do";
			}
			break;
		}
	}

	$(document).ready(function() {
		$('#comment').click(function() {
			$.ajax({
				url : "commentProc.jsp",
				type : "GET",
				data : {
					no : '${param.no}',
					content : $('#content').val()
				},
				success : callback
			});
		});
	});

	function callback(data) {
		console.log(data);
		var list = eval(data.trim());

		var content = list[0].content;
		var writer = list[0].writer;
		var no = list[0].no;
		var msg = writer + '<br/>' + content + '<br/>' + no + '<br/>';
		var id = document.getElementById("comm");
		id.value = msg;
	}
</script>
</head>
<body>

	<header>
		<c:import url="/include/topMenu.do" />
	</header>
	<section>
		<div align="center">
			<h2>게시물 상세</h2>
			<hr width="80%" />
			<br />

			<table border="1" width="100%">
				<tr>
					<td width="15%">번호</td>
					<td>${ board.no }</td>
				</tr>
				<tr>
					<td>제목</td>
					<td><c:out value="${ board.title }" /></td>
				</tr>
				<tr>
					<td>글쓴이</td>
					<td>${ board.writer }</td>
				</tr>
				<tr>
					<td>내용</td>
					<td style="height: 100px" valign="top">${ board.content }</td>
				</tr>
				<tr>
					<td>조회수</td>
					<td>${ board.viewCnt }</td>
				</tr>
				<tr>
					<td>등록일</td>
					<td>${ board.regDate }</td>
				</tr>
				<%-- 			<tr>
				<td>첨부파일</td>
				<td>
					<c:forEach var="file" items="${ fileList }">
						<a href = "<%=request.getContextPath() %>/upload/${ file.fileSaveName }">
						<c:out value="${ file.fileOriName }"/></a>
						(${ file.fileSize }bytes)<br/>
					</c:forEach>
				</td>
			</tr> --%>
			</table>
			<br />

			<textarea id="comm" cols="5" rows="100%"></textarea>
			<%-- 			<tr>
				<c:forEach var="cList" items="${ cList }">
					<td>${ cList.writer }</td>
					<td>${ cList.content }</td>
					<td>${ cList.regDate }</td>
				</c:forEach>
			</tr> --%>

			<table border="1" width="100%">
				<tr>
					<td width="15%">댓글쓰기</td>
					<td><textarea cols="105" rows="3" id="content"></textarea>&nbsp;
						<input type="button" value=" 등록 " id="comment" /></td>
				</tr>
			</table>
			<br /> <input type="button" value=" 수정 " />&nbsp; 
				<input type="button" value=" 삭제 " onclick="doAction('D')" />&nbsp; 
				<input type="button" value=" 목록 " onclick="doAction('L')" />&nbsp;
		</div>
	</section>
	<footer>
		<c:import url="/include/footer.do" />
	</footer>
</body>
</html>
