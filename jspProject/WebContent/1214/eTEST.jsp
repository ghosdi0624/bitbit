<%@ page language="java" contentType="text/html; charset=EUC-KR" errorPage = "error.jsp"
    pageEncoding="EUC-KR" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>Driective Example</h1>
<%
int one = 1;
int zero = 0;
/* System.out.println("aaaa"); */
%>
one과 zero의 사칙연산<p>

one + zero = <%=one + zero %><p>
one - zero = <%=one - zero %><p>
one * zero = <%=one * zero %><p>
one / zero = <%=one / zero %><p>
</body>
</html>