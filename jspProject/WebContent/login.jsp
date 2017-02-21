<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body  bgcolor = "pink">
<form method = "post">
<table border = "0" width = "250" align = "center" height = "40"></table>
<table border = "0" width = "250" align = "center">
<tr>
<th colspan = "2"><b><font size = "4" face = "휴먼엽서체">로그인</font></b></th></tr></table>
<table border = "0" width = "250" align = "center" height = "10"></table>
<table border = "0" width = "250" align = "center">
<tr>
<td>아이디  </td><td><input type = "text" name = "id" style = "width:150px"></td></tr>
<tr>
<td>비밀번호  </td><td><input type = "password" name = "password" style = "width:150px"></td></tr>
<tr>
<td></td>
<td>
<input type = "submit" value = "로그인" formaction = "loginproc.jsp">
<a href = "member.jsp" target = "content"><input type = "button" value = "회원가입"></a>
<%--<input type = "submit" value = "회원가입" formaction = "member.jsp">--%>
</td></tr>
</table>
</form>
</body>
</html>