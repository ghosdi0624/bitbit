<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String strId = "mistarry";
		String strPw = "hello";
		session.setAttribute("logID", strId);
		session.setAttribute("logPW", strPw);
	%>
	세션이 생성되었습니다.<br/>
	<a href = "viewSessionInfo.jsp">세션정보를 확인하는 페이지로 이동
	</a>
</body>
</html>