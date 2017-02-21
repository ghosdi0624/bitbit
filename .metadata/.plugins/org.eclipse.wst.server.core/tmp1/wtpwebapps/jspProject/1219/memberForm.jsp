<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method = "post" action = "processJoin3.jsp">
<table border = "1" cellpadding = "0" cellspacing = "0" align = "center">
<tr>
<td colspan = "4" align = "center">회원가입</td></tr>
<tr>
<td>아이디</td>
<td><input type = "text" name = "id"></td>
<td>비밀번호</td>
<td><input type = "text" name = "password"></td></tr>
<tr>
<td>이름</td>
<td><input type = "text" name = "name"></td>
<td>이메일</td>
<td><input type = "text" name = "email"></td></tr>
<tr>
<td>주소</td>
<td colspan = "4"><input type = "text" name = "address" size = "55"></td></tr>
<tr>
<td colspan = "4" align = "center"><input type = "submit" value = "전송"></td></tr>
</table>

</form>
</body>
</html>