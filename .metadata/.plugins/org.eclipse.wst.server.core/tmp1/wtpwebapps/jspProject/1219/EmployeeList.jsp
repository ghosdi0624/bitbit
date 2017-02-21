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
		ResultSet rs = stat.executeQuery("SELECT * FROM emp");
	%>
	
	<table border ="1" cellspacing = "0" cellpadding = "0"width = "700">
	<tr>
	<td width = "30" height = "20" bgcolor = "#D2E9F9">
	<p align = "center">
	<span><b>Dept No.</b></span></p>
	</td>
	<td width = "30" height = "20" bgcolor = "#D2E9F9">
	<p align = "center">
	<span><b>Emp no.</b></span></p>
	</td>
	<td width = "30" height = "20" bgcolor = "#D2E9F9">
	<p align = "center">
	<span><b>Emp Name</b></span></p>
	</td>
	<td width = "30" height = "20" bgcolor = "#D2E9F9">
	<p align = "center">
	<span><b>Job</b></span></p>
	</td>
	<td width = "30" height = "20" bgcolor = "#D2E9F9">
	<p align = "center">
	<span><b>Hire Date</b></span></p>
	</td></tr>
	
	<%
		if (rs != null) {
			while (rs.next()) {
				String E_ID = rs.getString("empno");
				String E_NAME = rs.getString("ename");
				String E_JOB = rs.getString("job");
				String E_HIREDATE = rs.getString("hiredate");
				String E_DEPTID = rs.getString("deptno");
	%>
	
	<tr>
	<td width = "30" height="20"><p align = "center">
	<a href = "DepartmentList.jsp?deptid=<%=E_DEPTID %>">
	<%=E_DEPTID %></a></p></td>
	<td width = "30" height="20"><p align = "center">
	<%=E_ID %></p></td>
	<td width = "30" height="20"><p align = "center">
	<%=E_NAME %></p></td>
	<td width = "30" height="20"><p align = "center">
	<%=E_JOB %></p></td>
	<td width = "30" height="20"><p align = "center">
	<%=E_HIREDATE %></p></td>

	<%
		}
		}
	stat.close();
	conn.close();
	} catch(Exception e){
		e.getMessage();
	} 
	
	%>
	
	</table>
	<table cellpadding = "0" cellspacing = "0" width = "400" height = "23">
	<tr>
	<td width = "1350">
	<p align = "right"><b><a href = "EmployeeList.jsp"><font size = "1" face = "돋움체" color = "black">LIST</font></a></b>
	</p></td></tr></table>

</body>
</html>