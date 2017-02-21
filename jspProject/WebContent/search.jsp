<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String search = request.getParameter("search");
	String keyword = request.getParameter("keyword");

	int i=0;
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "scott", "tiger");
	Statement stat = conn.createStatement();

	if(search.equals("이름")){%>
		<form method = "post">
</table>
<table border = "0" width = "850" align = "center" cellpadding = "0" cellspacing = "0">
<tr>
<td align = "right">
<input type = "submit" value = "글쓰기" formaction = "post.jsp"></td>
</tr>
</table>
<table border = "1" width = "850" align = "center">
<tr>
<td align = "center" width = "10" bgcolor = "#D2E9F9"><b>No</b></td>
<td width = "500" align = "center" bgcolor = "#D2E9F9"><b>제목</b></td>
<td align = "center" bgcolor = "#D2E9F9"><b>작성자</b></td>
<td align = "center" bgcolor = "#D2E9F9"><b>작성일</b></td>
<td align = "center" bgcolor = "#D2E9F9"><b>조회수</b></td></tr>

<%
	ResultSet rs = stat.executeQuery("SELECT borno,title,author,bordate,hit FROM border1 where author = '"+keyword+"' order by borno DESC");
	while(rs.next()){ 
	%><tr>
<td align = "center">  <%out.println(rs.getInt("borno"));%></td>
<td align = "center"> <a href = "read.jsp?borno=<%=rs.getInt("borno")%>"><%out.println(rs.getString("title"));%></a></td>		
<td align = "center">  <%out.println(rs.getString("author"));%></td>
<td align = "center">  <%out.println(rs.getString("bordate"));%></td>
<td align = "center">  <%out.println(rs.getString("hit"));%></td>
</tr><%	i++; session.setAttribute("row", i);
	}
%>
</table>
		
		
		
	<%} 
	
	else if(search.equals("제목")){%>
		<form method = "post">
</table>
<table border = "0" width = "850" align = "center" cellpadding = "0" cellspacing = "0">
<tr>
<td align = "right">
<input type = "submit" value = "글쓰기" formaction = "post.jsp"></td>
</tr>
</table>
<table border = "1" width = "850" align = "center">
<tr>
<td align = "center" width = "10" bgcolor = "#D2E9F9"><b>No</b></td>
<td width = "500" align = "center" bgcolor = "#D2E9F9"><b>제목</b></td>
<td align = "center" bgcolor = "#D2E9F9"><b>작성자</b></td>
<td align = "center" bgcolor = "#D2E9F9"><b>작성일</b></td>
<td align = "center" bgcolor = "#D2E9F9"><b>조회수</b></td></tr>

<%
ResultSet rs = stat.executeQuery("SELECT borno,title,author,bordate,hit FROM border1 where title like '"+keyword+"' order by borno DESC");
	while(rs.next()){ 
	
	%><tr>
<td align = "center">  <%out.println(rs.getInt("borno"));%></td>
<td align = "center"> <a href = "read.jsp?borno=<%=rs.getInt("borno")%>"><%out.println(rs.getString("title"));%></a></td>		
<td align = "center">  <%out.println(rs.getString("author"));%></td>
<td align = "center">  <%out.println(rs.getString("bordate"));%></td>
<td align = "center">  <%out.println(rs.getString("hit"));%></td>
</tr><%	i++; session.setAttribute("row", i);
	}
%>
</table>
		
		
		
	<%} 
	
	else if(search.equals("내용")){%>
		<form method = "post">
</table>
<table border = "0" width = "850" align = "center" cellpadding = "0" cellspacing = "0">
<tr>
<td align = "right">
<input type = "submit" value = "글쓰기" formaction = "post.jsp"></td>
</tr>
</table>
<table border = "1" width = "850" align = "center">
<tr>
<td align = "center" width = "10" bgcolor = "#D2E9F9"><b>No</b></td>
<td width = "500" align = "center" bgcolor = "#D2E9F9"><b>제목</b></td>
<td align = "center" bgcolor = "#D2E9F9"><b>작성자</b></td>
<td align = "center" bgcolor = "#D2E9F9"><b>작성일</b></td>
<td align = "center" bgcolor = "#D2E9F9"><b>조회수</b></td></tr>

<%
ResultSet rs = stat.executeQuery("SELECT borno,title,author,bordate,hit FROM border1 where reading like '"+keyword+"' order by borno DESC");
	while(rs.next()){ 
	%><tr>
<td align = "center">  <%out.println(rs.getInt("borno"));%></td>
<td align = "center"> <a href = "read.jsp?borno=<%=rs.getInt("borno")%>"><%out.println(rs.getString("title"));%></a></td>		
<td align = "center">  <%out.println(rs.getString("author"));%></td>
<td align = "center">  <%out.println(rs.getString("bordate"));%></td>
<td align = "center">  <%out.println(rs.getString("hit"));%></td>
</tr><%	i++; session.setAttribute("row", i);
	}
%>
</table>
		
		
		
<%	}
%>

</body>
</html>