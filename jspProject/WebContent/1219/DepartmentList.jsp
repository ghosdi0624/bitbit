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
	
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "scott", "tiger");
		Statement stat = conn.createStatement();
		String deptId = request.getParameter("deptid");
		ResultSet rs = stat.executeQuery("SELECT * FROM dept where deptno ='" + deptId + "'");

		if (rs != null) {
			rs.next();
	%>
	
	<table border="1" cellspacing="0" width="200">
	<tr>
	<td width = "80" height = "23" bgcolor = "#D2E9F9">
	<p align = "center"><b>부서번호</b></p></td>
	<td align = "center">
	<p><span style = "font-size:12pt;"><%=rs.getString("deptno") %></span></p>
	</td>
	</tr>
	

		<%
			}
	
		stat.close();
		conn.close();
	} catch (Exception e){
		out.println("해당 부서번호는 없습니다");
	}
		%>
</table>	
</body>
</html>