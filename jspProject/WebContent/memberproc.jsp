<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*, java.util.*, Bean.MemberInfo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method = "post" action = "login.jsp">
	<%
		MemberInfo member = new MemberInfo();
		member.setId(request.getParameter("newid"));
		member.setPassword(request.getParameter("newpw"));
		member.setName(request.getParameter("newname"));
		member.setEmail(request.getParameter("newemail"));
		member.setAddress((String)session.getAttribute("addr"));

		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "scott", "tiger");
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery("insert into member1 values ('"+member.getId()+"','"+
		member.getPassword()+"','"+member.getName()+"','"+member.getAddress()+"','"+member.getEmail()+"',sysdate)");%>
		회원가입이 완료 되었습니다.<br/>

<% 		} catch (Exception e) {
			out.println("사용할수 없는 ID입니다.");
		}
	%>
	메인 화면으로..<a href = "list.jsp" target = "content"><input type = "button" value = "go"></a>
</form>
</body>
</html>