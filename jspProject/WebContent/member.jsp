<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor = "#FFF5EE">
<%
	String fulladdr = request.getParameter("fulladdr");
%>
<form method = "post">
<table border = "1" width = "400" align = "center">
<tr><td align = "center" colspan = "2"><h1>회원가입</h1></td></tr>
<tr>
<td>아이디  </td><td><input type = "text" name = "newid" id="newid">
	<!-- <input type = "submit" value = "ID확인" formaction = "idcheck.jsp"> -->
	<button type="button" onclick="idchk()">중복체크</button></td></tr>
<tr>
<td>비밀번호  </td><td><input type = "password" name = "newpw"></td></tr>
<tr>
<td>이름  </td><td><input type = "text" name = "newname"></td></tr>
<tr>
<td>주소  </td><td><input type = "text" name = "newaddr"><input type = "submit" value = "우편번호 검색" formaction = "zipcheck.jsp"></td></tr>
<tr>
<td>이메일  </td><td><input type = "text" name = "newemail"></td></tr>
<tr>
<td align = "center" colspan = "2"><input type = "submit" value = "가입하기" formaction = "memberproc.jsp">
<input type = "reset" value = "다시쓰기"></td></tr>
</table>
</form>
</body>
</html>

<script type="text/javascript">
function idchk(){
	var tmpId = document.getElementById("newid").value;
	window.open("idcheck.jsp?newid="+tmpId);
}
</script>