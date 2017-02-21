<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method = "post">
<%session.invalidate(); %>
로그아웃 되었습니다.<p>
<input type = "submit" value = "메인 화면으로" formaction = "login.jsp">
</form>
</body>
</html>