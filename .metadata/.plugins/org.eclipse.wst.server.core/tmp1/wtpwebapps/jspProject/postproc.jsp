<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*, Bean.MemberInfo"%>
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
		MemberInfo member = new MemberInfo();
		String title = request.getParameter("title");
		String write = request.getParameter("write");
		int row = (Integer)session.getAttribute("row");
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "scott", "tiger");
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery("insert into border1 values ("+(row)
				+",'"+title+"','"+session.getAttribute("myid")+"',sysdate,'"+write+"',0)");
	%>
	
	글쓰기가 정상적으로 완료 되었습니다.<p>
	<input type = "submit" value = "목록" formaction = "list.jsp">
</form>
</body>
</html>