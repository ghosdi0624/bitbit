<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.co.bit.util.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Mission-Web/css/layout.css" />
<link rel="stylesheet" href="/Mission-Web/css/board.css" />

<script type="text/javascript">
	function doAction() {
		location.href = "newmemberform.jsp";
	}

	function isNull(obj, msg){
		if(obj.value == ""){
			alert(msg);
			obj.focus();
			return true;
		}
		return false;
	}
	
	function memberCheck() {
		var form = document.inputForm;
		
		if(isNull(form.id, "아이디를 입력하세요"))
			return false;
		
		if(isNull(form.pw, "비밀번호를 입력하세요"))
			return false;
	
		return true;
	}
</script>
</head>
<body>

	<header>
		<jsp:include page="/jsp/include/topMenu.jsp"></jsp:include>
	</header>

	<section>
		<div align="center">
			<h2 style="background-color: lightblue">로그인 화면</h2>
			<hr width="80%" />
			<br />
			<form name="inputForm" action="login.jsp" method="post"
				onsubmit="return memberCheck()">
				<table width="50%">
					<tr>
						<th width="50%">아이디</th>
						<td><input type="text" name="id" size="30"></td>
					</tr>
					<tr>
						<th width="50%">비밀번호</th>
						<td><input type="password" name="pw" size="30"></td>
					</tr>
				</table>
				<br /> <input type="submit" value=" 로그인 " />&nbsp; 
				<input type="button" value=" 회원가입 " onclick="doAction()" />
			</form>
		</div>
	</section>

	<footer>
		<%@include file="/jsp/include/footer.jsp"%>
	</footer>
</body>
</html>
