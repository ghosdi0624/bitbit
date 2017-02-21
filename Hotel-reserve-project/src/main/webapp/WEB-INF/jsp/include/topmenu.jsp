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
<table width="100%" class="topmenu">
	<tr>
		<td rowspan="2" style = "width:210px; height:78px;">
			<a href = "${ pageContext.request.contextPath }/">
			<img src="${ pageContext.request.contextPath }/resources/images/headerlogo.jpg" width="210px" height="75px"/></a>
			</td>
		<td align = "right">
		<c:if test="${ not empty sessionScope.userVO }">
			[${ sessionScope.userVO.id }님으로 로그인중]
		</c:if>
		<a href = "#" onclick = "addFavorite()">즐겨찾기</a>
		</td>
	</tr>
	<tr>
		<td align="right">
		<c:if test="${ userVO.type == 'S' }">
			<a href="${ pageContext.request.contextPath }/memberInfo.do"><span style="color: white">회원관리</span></a>||
		</c:if>
		<c:if test="${ userVO.type == 'c' }">
			<a href="${ pageContext.request.contextPath }/company/registerHotel.do"><span style="color: white">숙소등록하기</span></a>||
			<a href="${ pageContext.request.contextPath }/company/roomregister.do"><span style="color: white">방등록하기</span></a>||
			<a href="${ pageContext.request.contextPath }/company/companypage.do"><span style="color: white">마이페이지</span></a>||
		</c:if>
		<c:choose>
			<c:when test="${ empty userVO }">
				<a href="${ pageContext.request.contextPath }/login/signup.do"><span style="color: white">회원가입</span></a>||
				<a href="${ pageContext.request.contextPath }/login/login.do"><span style="color: white">로그인</span></a>
			</c:when>
			<c:otherwise>
				<c:if test="${ userVO.type=='u' }">
					<a href="${ pageContext.request.contextPath }/member/mypage.do"><span style="color: white">마이페이지</span></a>||
				</c:if>	
					<a href="${ pageContext.request.contextPath }/login/logout.do"><span style="color: white">로그아웃</span></a>
			</c:otherwise>
		</c:choose>
		</td>
	</tr>
</table>