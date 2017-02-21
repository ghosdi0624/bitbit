<%@page import="kr.co.bit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.bit.board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	BoardDAO dao = new BoardDAO();
	// 페이지 나누기
	
	String pgstr = request.getParameter("pg");
	if(pgstr == null){
		pgstr = "1";
	}
	
	int pg = Integer.parseInt(pgstr);
	int block = 5;
	int rowpage = 10;
	int total = dao.totalBoard();
	int allpage = total/rowpage+1;
	int startpage = ((pg-1)/block*block)+1;
	int endpage = 0;
	if((total/rowpage)+1 < ((pg-1)/block*block)+block){
		endpage = (total/rowpage)+1;
	} else{
		endpage = ((pg-1)/block*block)+block;
	}

	List<BoardVO> list = dao.selectAllBoard(pg, rowpage);

	pageContext.setAttribute("list", list);
	pageContext.setAttribute("pg", pg);
	pageContext.setAttribute("startpage", startpage);
	pageContext.setAttribute("endpage", endpage);
	pageContext.setAttribute("block", block);
	pageContext.setAttribute("allpage", allpage);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Mission-Web/css/layout.css" />
<link rel="stylesheet" href="/Mission-Web/css/board.css" />
<script>
	function goWriteForm() {
		//      location.href = "writeForm.jsp";
		location.href = "/Mission-Web/jsp/board/writeForm.jsp";
	}

	function doAction(boardNo) {
		<c:choose>
		<c:when test="${ not empty userVO}" >
		location.href = "detail.jsp?no=" + boardNo;
		</c:when>
		<c:otherwise>
		if (confirm('로그인 후 사용가능합니다\n로그인하시겠습니까?'))
			location.href = "/Mission-Web/jsp/login/login.jsp";
		</c:otherwise>
		</c:choose>
	}
</script>

</head>
<body>

	<header>
		<jsp:include page="/jsp/include/topMenu.jsp"></jsp:include>
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
						<td><a href="javascript:doAction('${ board.no}')"> <c:out
									value="${ board.title }" />
						</a></td>
						<td>${ board.writer }</td>
						<td>${ board.regDate }</td>
						<td>${ board.viewCnt }</td>

					</tr>
				</c:forEach>

			</table>
			<br /> <br />
			<div align = "right">
			<c:if test="${ not empty userVO }">
				<input type="button" value="새글등록" onclick="goWriteForm()"/>
			</c:if>
			</div>
			<div class = "pageNum">
			<c:if test="${ pg > block }">
				<a href="list.jsp?pg=1">[◀◀]</a>
				<a href="list.jsp?pg=${ startpage-1 }">[◀]</a>
			</c:if>
			<c:forEach var="i" begin="${ startpage }" end="${ endpage }">
				<c:if test="${ i == pg }">
						[${ i }]
			</c:if>
				<c:if test="${ i != pg }">
					<a href="list.jsp?pg=${ i }">[${ i }]</a>
				</c:if>
			</c:forEach>
			<c:if test="${ endpage < allpage }">
				<a href="list.jsp?pg=${ endpage+1 }">[▶]</a>
				<a href="list.jsp?pg=${ allpage }">[▶▶]</a>
			</c:if>
			</div>
		</div>


	</section>
	<footer>
		<%@include file="/jsp/include/footer.jsp"%>
	</footer>
</body>
</html>