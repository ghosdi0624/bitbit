<%@page import="kr.co.bit.login.vo.LoginVO"%>
<%@page import="kr.co.bit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.bit.member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	
	MemberDAO dao = new MemberDAO();
	LoginVO loginVO = new LoginVO();
	
	loginVO = (LoginVO)session.getAttribute("userVO");
	String id = loginVO.getId();
	
	MemberVO list = dao.selectMyInfo(id);
	pageContext.setAttribute("list", list);
	
%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function changePW(){
		window.open("pwproc.jsp","비밀번호 변경","width=400, height=200");
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Mission-Web/css/layout.css" />
<link rel="stylesheet" href="/Mission-Web/css/board.css" />
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp"></jsp:include>
	</header>
	<section>
		<div align="center">
			<h2>마이페이지</h2>
			<hr width="80%" />
			<br />
			
				<table width="70%">
					<tr>
						<td><b>아이디</b></td>
						<td><c:out value="${ list.id }"/></td>
						<td></td>
					</tr>
					<tr>
						<td><b>비밀번호</b></td>
						<td><c:out value="${ list.password }"/></td>
						<td><input type = "button" value =" 변경 " onclick = "changePW()"/></td>
					</tr>
					<tr>
						<td><b>이름</b></td>
						<td><c:out value="${ list.name }"/></td>
						<td></td>
					</tr>
					<tr>
						<td><b>이메일</b></td>
						<td><c:out value="${ list.emailId }@${ list.emailDomain }"/></td>
						<td></td>
					</tr>
					<tr>
						<td><b>전화번호</b></td>
						<td><c:out value="${ list.tel1 }-${ list.tel2 }-****"/></td>
						<td></td>
					</tr>
					
				</table>
				
		</div>
	</section>
	<footer>
		<%@include file="/jsp/include/footer.jsp" %>
	</footer>
</body>
</html>