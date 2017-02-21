<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	function addFavorite(){
		try{
			window.external.addFavorite('http://localhost:8080/Mission-Web','첫번째 나의 웹');
		} catch(e){
			alert("현재 사용중인 브라우저에서는 사용할 수 없는 기능 입니다.\n크롬에서는 ctrl+d를 눌러주세요");
		}
	}
</script>
<table border = "1" width="100%">
	<tr>
		<td rowspan="2" style = "width:210px; height:78px;">
			<a href = "/Mission-Web"><img src="/Mission-Web/images/bubble.jpg" width="210px" height="75px"/></a>
			</td>
		<td align = "right">
		<c:if test="${ not empty sessionScope.userVO }">
			[${ sessionScope.userVO.id }님으로 로그인중]
		</c:if>
		<a href = "#" onclick = "addFavorite()">즐겨찾기</a>
		<!-- <a href="javascript:window.external.addFavorite('http://localhost:8080/Mission-Web','첫번째 나의 웹')">즐겨찾기</a> -->
		</td>
	</tr>
	<tr>
		<td>
		<c:if test="${ userVO.type == 'S' }">
			<a href="/Mission-Web/jsp/member/memberInfo.jsp">회원관리</a>||
		</c:if>
			<a href="/Mission-Web/jsp/board/list.jsp">게시판</a>||
		<c:choose>
			<c:when test="${ empty userVO }">
				<a href="/Mission-Web/jsp/member/newmemberform.jsp">회원가입</a>||
				<a href="/Mission-Web/jsp/member/loginform.jsp">로그인</a>
			</c:when>
			<c:otherwise>
				<a href="/Mission-Web/jsp/member/mypageform.jsp">마이페이지</a>||
				<a href="/Mission-Web/jsp/member/logout.jsp">로그아웃</a>
			</c:otherwise>
		</c:choose>
		</td>
	</tr>
</table>