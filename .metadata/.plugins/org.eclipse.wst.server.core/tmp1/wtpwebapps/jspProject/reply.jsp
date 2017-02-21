<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method = "post">
<%
	request.setCharacterEncoding("utf-8");
	String no = request.getParameter("no");	
	session.setAttribute("no", no);
%>
<table border = "0" width = "500" align = "center">
<th><span style = font-size:30pt>답글쓰기</span></th>
<tr>
<td><b>제목</b>  <input type = "text" size = "100" name = "title1"></td>
</tr>
<tr>
<td><textarea rows=20 cols=100 name = "write1"></textarea></td>
</tr>
<tr>
<td><input type = "submit" value = "확인" formaction = "replyproc.jsp">
<input type = "reset" value = "다시쓰기">
<input type = "submit" value = "목록" formaction = "list.jsp"></td>
</tr>
</table>
</form>
</body>
</html>