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
		String no = request.getParameter("borno");
		String id = request.getParameter("id");
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "scott", "tiger");
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery("SELECT borno,title,reading,hit FROM reply1 where borno = " + no);
		rs.next();
		int hit = rs.getInt("hit");
		hit = hit + 1;
		int borno = rs.getInt("borno");
	%>
	<form method = "post">
	<table border="0" width="700" align="center">
	<tr><td><b><%out.println(rs.getString("title")); %></b></td></tr>
	</table>
	<table border="1" width="700" align="center"></table><br/>
		<table border="1" width="700" align="center">
			<tr><td height = "200" valign = "top"><%out.println(rs.getString("reading"));%></td></tr>
		</table>
		<table border="0" width="700" align="center">
		<tr><td>
		<%
		if(session.getAttribute("myid").equals(id)){%>
		<input type = "submit" value = "수정" formaction = "update.jsp?no=<%=no%>">
		<input type = "submit" value = "삭제" formaction = "delete.jsp?no=<%=no%>">
		<%hit = hit - 1;}%>
		<input type = "submit" value = "목록" formaction = "list.jsp">
		<a href = "reply.jsp?no=<%=borno%>"><input type = "button" value = "답글달기"></a>
		<input type = "submit" value = "로그아웃" formaction = "logout.jsp">
		</td></tr>
		</table>
	</form>
	<%
		rs = stat.executeQuery("update reply1 set hit = "+hit+"where borno = "+no);
	%>
</body>
</html>