<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<FORM METHOD = "post" ACTION = "gugudan.html">
	<h1>Gugudan~~</h1>
	<%
		request.setCharacterEncoding("EUC-KR");
		int number = Integer.parseInt(request.getParameter("dan"));
	%>
	<table border="3" width="150">
		<%
			for (int j = 1; j <= 9; j++) {
		%>
		<tr>
			<td><b> <%
 	out.println(number + " x " + j + " = " + (number * j));
 %>
			</b></td>
		</tr>
		<%
			}
		%>
	</table><br/>
	<Input Type = "submit" value = "돌아가기">
</body>
</html>