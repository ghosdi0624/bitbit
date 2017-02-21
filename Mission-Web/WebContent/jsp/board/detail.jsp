<%@page import="kr.co.bit.comment.vo.CommentVO"%>
<%@page import="kr.co.bit.comment.dao.CommentDAO"%>
<%@page import="kr.co.bit.board.vo.BoardFileVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.bit.board.vo.BoardVO"%>
<%@page import="kr.co.bit.board.dao.BoardDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.bit.util.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	1. No. 파라미터를 얻기
	2. No에 해당하는 게시물 조회(t_board) : DAO
	3. 조회된 게시물(VO)을 화면에 출력    
--%>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	// 해당 번호의 게시물 조회
	BoardDAO dao = new BoardDAO();
	// 첨부 파일 조회
	List<BoardFileVO> fileList = dao.selectFileByNo(no);
	
	CommentDAO cdao = new CommentDAO();
	List<CommentVO> cList = cdao.selectAll(no);
	
	
	int hit = dao.getViewCnt(no);
	dao.addViewCnt(no, hit);
	BoardVO board = dao.selectByNo(no);

	
	pageContext.setAttribute("board", board);	
	pageContext.setAttribute("fileList", fileList);
	if(cList != null){
		pageContext.setAttribute("cList", cList);
	}
	
	
%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#comm{
	border : 1px solid lightblue;
	width : 100%;
	height : 100px;
	font-size : 10pt;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/Mission-Web/css/layout.css" />
<link rel="stylesheet" href="/Mission-Web/css/board.css" />
<script src = "http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">
	function doAction(type){
		switch(type){
		case 'L' : 
			location.href = "list.jsp"; break;
		case 'D' :
			if(confirm("삭제하시겠습니까?")){
				location.href = "delete.jsp?no=${ param.no }";	
			}
			break;
		}
	}
	
	$(document).ready(function(){
		$('#comment').click(function(){
			$.ajax({
				url : "commentProc.jsp",
				type : "GET",
				data : {
					no : '${param.no}',
					content : $('#content').val()
				},
				success : callback
			});
			$('#content').val("");
		});
	});
	
	function callback(data){
		var list = eval(data.trim());
		
		var content = list[0].content;
		var writer = list[0].writer;
		
		$('#tblcmt > tbody:last').prepend('<tr><td width="15%">'+writer
				+'</td><td width="70%">'+content+'</td><td width="15%">now</td></tr>');
	}
</script>
</head>
<body>

	<header>
		<jsp:include page="/jsp/include/topMenu.jsp"></jsp:include>
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
				<td><c:out value="${ board.title }"/></td>
			</tr>
			<tr>	
				<td>글쓴이</td>
				<td>${ board.writer }</td>
			</tr>
			<tr>	
				<td>내용</td>
				<td style="height:100px" valign = "top">
					<%=board.getContent().replace("\r\n","<br/>")%>
				</td>
			</tr>
			<tr>	
				<td>조회수</td>
				<td>${ board.viewCnt }</td>
			</tr>
			<tr>	
				<td>등록일</td>
				<td>${ board.regDate }</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td>
					<c:forEach var="file" items="${ fileList }">
						<a href = "/Mission-Web/upload/${ file.fileSaveName }">
						<c:out value="${ file.fileOriName }"/></a>
						(${ file.fileSize }bytes)<br/>
					</c:forEach>
				</td>
			</tr>
		</table><br/>
		
		<table border="1" width="100%" id = "tblcmt">
			<tbody></tbody>
		</table>
	
		<c:forEach var="cList" items="${ cList }">
			<table border = "1" width = "100%">
				<tr>
					<td width="15%">${ cList.writer }</td>
					<td width="70%">${ cList.content }</td>
					<td width="15%">${ cList.regDate }</td>
				</tr>
			</table>
		</c:forEach>
		
		<table border="1" width="100%">
			<tr>
				<td width="15%">댓글쓰기</td>
				<td><textarea cols="105" rows="3" id = "content"></textarea>&nbsp;
				<input type = "button" value = " 등록 " id = "comment"/></td>
			</tr>
		</table><br/>
		<input type = "button" value = " 수정 " />&nbsp;
		<input type = "button" value = " 삭제 " onclick = "doAction('D')"/>&nbsp;
		<input type = "button" value = " 목록 " onclick = "doAction('L')"/>&nbsp;
	</div>
	</section>
	<footer>
		<%@include file="/jsp/include/footer.jsp" %>
	</footer>
</body>
</html>