<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("EUC-KR");
		String ID = request.getParameter("ID");
		String PW = request.getParameter("Password");
		String intro = request.getParameter("introduce");
	%>
	<b>입력한 정보 입니다. ID : <%=ID%></b><p>
	<b>Password : <%=PW%></b><p>
	<b>자기소개 : <%=intro%></b>

</body>
</html>