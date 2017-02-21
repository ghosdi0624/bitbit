<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
td.lefttd{
	background: #C1B9C6;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/board.css" />
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/layout.css" />
<script src="/webjars/jquery/3.1.1/dist/jquery.min.js" ></script>
<script type="text/javascript">
	

	$(document).ready(function() {
		$('#target').keyup(function() {
			idCheck();
		});
	});

	var httpRequest = null;
	function getXMLHttpRequest() {
		if (window.XMLHttpRequest) {
			return new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			return new ActiveXObject("Microsoft.XMLHTTP");
		} else {
			return null;
		}
	}

	function idCheck() {
		if (document.inputForm.id.value.length < 5) {
			document.getElementById("msgView").innerText = "";
			return;
		}

		httpRequest = getXMLHttpRequest();
		var id = document.inputForm.id;
		sendRequest("GET", "${ pageContext.request.contextPath }/company/idcheck.do?id="+ id.value, null, callback);
	}

	function sendRequest(method, url, params, callback) {
		httpRequest.onreadystatechange = callback;

		httpRequest.open(method, url, true)
		httpRequest.send(null);
	}

	function callback() {
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				var msgView = document.getElementById("msgView");
				msgView.innerHTML = httpRequest.responseText;
			}
		}
	}
	

	function checkForm() {
		var form = document.inputForm;
		if (form.id.value == "") {
			alert("아이디를 입력하세요");
			form.id.focus();
			return false;
		}
		if(document.getElementById("msgView").innerText.substring(0,4) != '사용가능'){
			alert("아이디를 다시 확인하세요");
			form.id.focus();
			return false;
		}
		if (form.password.value == "") {
			alert("비밀번호를 입력하세요");
			form.password.focus();
			return false;
		}
		if (form.password.value != form.pwcheck.value) {
			alert("비밀번호가 일치하지 않습니다");
			form.password.focus();
			return false;
		}
		if (form.companyName.value == "") {
			alert("사업장을 입력하세요");
			form.companyName.focus();
			return false;
		}
		if (form.addr.value == "") {
			alert("사업장 주소를 입력하세요");
			form.addr.focus();
			return false;
		}
		if (form.bankName.value == "") {
			alert("은행명을 입력하세요");
			form.bankName.focus();
			return false;
		}
		if (form.bankAccount.value == "") {
			alert("계좌번호를 입력하세요");
			form.bankAccount.focus();
			return false;
		}

		return true;
	}
</script>
</head>
<body>
	<header>
		<c:import url="/include/topmenu.do" />
	</header>
	<section>
		<form name = "inputForm" onsubmit = "return checkForm()" action = "${ pageContext.request.contextPath }/company/company.do">
	<div align="center">
		<h2>회원 가입</h2>
		<hr width="80%" />
		<br />
		<table width="70%">
			<tr>
				<td class = "lefttd"><b>아이디</b></td>
				<td><input type = "text" name = "id" size = "30" id = "target"></td>
				<td width = "30%" id = "msgView"></td>
			</tr>
			<tr>
				<td class = "lefttd"><b>비밀번호</b></td>
				<td><input type = "password" name = "password" size = "30"></td>
				<td></td>
			</tr>
			<tr>
				<td class = "lefttd"><b>비밀번호확인</b></td>
				<td><input type = "password" name = "pwcheck" size = "30"></td>
				<td></td>
			</tr>
			<tr>
				<td class = "lefttd"><b>기업명</b></td>
				<td><input type = "text" name = "companyName" size = "30"></td>
				<td></td>
			</tr>
			<tr>
				<td class = "lefttd"><b>사업장 주소</b></td>
				<td><input type = "text" name = "addr" size = "30"></td>
				<td></td>
			</tr>
			<tr>
				<td class = "lefttd"><b>은행명</b></td>
				<td><input type = "text" name = "bankName" size = "30"></td>
				<td></td>
			</tr>
			<tr>
				<td class = "lefttd"><b>은행 계좌번호</b></td>
				<td><input type = "text" name = "bankAccount" size = "30"></td>
				<td></td>
			</tr>
		</table>
		<br/>
		<input type = "submit" value = " 가입 " />&nbsp;
		<input type = "reset" value = " 다시쓰기 " />&nbsp;
		<input type = "button" value = " 처음으로 " onclick = "location.href = '${ pageContext.request.contextPath }'"/>
	</div>
</form>
	</section>
	<footer>
		<c:import url="/include/footer.do" />
	</footer>
</body>
</html>
