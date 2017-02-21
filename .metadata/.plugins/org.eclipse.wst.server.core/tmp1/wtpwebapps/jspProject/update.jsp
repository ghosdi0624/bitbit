<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String no = request.getParameter("no");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "scott", "tiger");
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery("SELECT * FROM border1 where borno = " + no);
		rs.next();
	%>
	<form method = "post">
<table border = "0" width = "500" align = "center">
<th><span style = font-size:30pt>글쓰기</span></th>
<tr>
<td><b>제목 : </b>  <%=rs.getString("title") %></td>
</tr>
<tr>
<td><textarea rows=20 cols=100 name = "write"></textarea></td>
</tr>
<tr>
<td><input type = "submit" value = "확인" formaction = "updateproc.jsp?no=<%=no%>">
<input type = "reset" value = "다시쓰기">
<input type = "submit" value = "목록" formaction = "list.jsp"></td>
</tr>
</table>
</form>
</body>
</html>