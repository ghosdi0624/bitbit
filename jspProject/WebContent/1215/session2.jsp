<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method = "post" action = "session3.jsp">
	<%
		request.setCharacterEncoding("utf-8");
		String ID = request.getParameter("ID");
		
		session.setAttribute("idKey", ID);
		
		session.setMaxInactiveInterval(60*5);
		
	%>
1. 가장 좋아하는 계절은?
<input type = "radio" name = "season" value = "봄">봄
<input type = "radio" name = "season" value = "여름">여름
<input type = "radio" name = "season" value = "가을" checked>가을
<input type = "radio" name = "season" value = "겨울">겨울<p>
2. 가장 좋아하는 과일은?
<input type = "radio" name = "fruit" value = "수박">수박
<input type = "radio" name = "fruit" value = "멜론" checked>멜론
<input type = "radio" name = "fruit" value = "사과">사과
<input type = "radio" name = "fruit" value = "오렌지">오렌지<p>

<input type = "submit" value = "결과보기">

</form>
</body>
</html>