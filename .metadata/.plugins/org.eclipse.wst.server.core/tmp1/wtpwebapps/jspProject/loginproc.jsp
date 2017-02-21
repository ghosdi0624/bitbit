<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="Bean.MemberInfo, java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:useBean id="member" class="Bean.MemberInfo" scope="request">	
	<jsp:setProperty property="id" name="member"/>
	<jsp:setProperty property="password" name="member"/>
</jsp:useBean>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method = "post">

	<%
		request.setCharacterEncoding("utf-8");		
		
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "scott", "tiger");
		Statement stat = conn.createStatement();
		ResultSet rs= stat.executeQuery("SELECT * FROM member1 where MEMID = '"+member.getId()+"'"); 

		rs.next();
		
		if(rs.getString("MEMID").equals(member.getId())){
			if(rs.getString("MEMPW").equals(member.getPassword())){%>
			  <table border = "0" width = "200" align = "center"><tr><td>
			  <%out.println("   로그인 성공!!!<br/>");
				session.setAttribute("myid", member.getId());
				%>
				</td></tr>
				<tr><td>
				<img src = "image/photo1.jpg" width = "200" height = "200"></td></tr>
				<tr><td align = "center">
				<a href = "list.jsp" target = "content"><input type = "button" value = "게시판"></a>
				<input type = "submit" value = "로그아웃" formaction = "logout.jsp">
				</td></tr></table>
			<%}
			else{
				out.println("비밀번호 틀림<br/>");%>
				<a href = "login.jsp">초기화면으로</a>
			<%
			}
		} 
		}catch (Exception e){
			out.println("존재 하지 않는 아이디<br/>");%>
			<a href = "login.jsp">초기화면으로</a>
		<%
		}
	%>
</form>
</body>
</html>