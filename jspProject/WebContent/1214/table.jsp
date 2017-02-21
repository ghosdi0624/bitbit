<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Expression Example</title>
</head>
<h1>Expression Example</h1>
<%
	String name[] = { "java", "jsp", "android", "struts" };
%>
<table border="100" width="200">
	<%
		for (int i = 0; i < name.length; i++) {
	%>
	<tr>
		<td><%=name[i]%></td>
	</tr>
	<%
		}
	%>
</table>
<%
	java.util.Date date = new java.util.Date();
	int hour = date.getHours();
	int one = 10;
	int two = 12;
%>
<%!public int operation(int i, int j) {
		return i > j ? i : j;
	}%><p>
<h1>지금은 오전일까요 오후일까요?</h1>
<h2><%=(hour < 12) ? "오전" : "오후"%></h2>
<p>
<h1>one와 two 둥 중에 큰 숫자는?</h1>
<h2><%=operation(one, two)%></h2>
<p>
	<body>

	</body>
</html>