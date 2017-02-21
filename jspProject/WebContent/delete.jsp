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
		ResultSet rs = stat.executeQuery("delete from border1 where borno = " + no);
	%>
	<form method = "post">
	<table border = "1" width = "200" align = "center">
	<tr><td>
	게시물 삭제가 완료되었습니다. <br/></td></tr>
	<tr><td align = "center">
	<input type = "submit" value = "목록" formaction = "list.jsp">
	</td></tr>
	</table>
	</form>
</body>
</html>