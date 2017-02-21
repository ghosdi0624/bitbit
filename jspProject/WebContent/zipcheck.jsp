<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import = "java.sql.*, java.util.*, Bean.MemberInfo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		MemberInfo member = new MemberInfo();
		request.setCharacterEncoding("utf-8");
		String addr = request.getParameter("newaddr");
	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "scott", "tiger");
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery("SELECT * FROM tblzipcode where area3 = '" + addr + "'");
		
		String fulladdr = null;
		ArrayList<String> arraddr = new ArrayList<String>();
		
		while(rs.next()){
			fulladdr = rs.getString(1)+rs.getString(2)+rs.getString(3)+rs.getString(4)+rs.getString(5);
			%>
			<a href = "javascript:history.go(-1)"><%out.println(fulladdr); %></a><br/>						
	<%	session.setAttribute("addr", fulladdr);
	}
	%>
</body>
</html>
