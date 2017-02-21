<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Date lastAccessTime = new Date(session.getLastAccessedTime());

	String title = "재방문 환영";
	Integer visitCount = new Integer(0);
	String visitCountKey = new String("visitCount");
	String userIDKey = new String("userID");
	String userID = new String("ABCD");
	
	session.setMaxInactiveInterval(3);
	
	if(session.isNew()){
		title = "방문 환영";
		session.setAttribute(userIDKey, userID);
		session.setAttribute(visitCountKey, visitCount);
	}
	visitCount = (Integer)session.getAttribute(visitCountKey);
	visitCount++;
	userID = (String)session.getAttribute(userIDKey);
	session.setAttribute(visitCountKey, visitCount);
%>

<center>
<h1>Session 예제</h1>
<h2><%=title%></h2>
</center>
<table border = "1" align = "center">
<tr bgcolor = "#949494">
<th>Session info</th>
<th>Value</th>
</tr>
<tr>
<td>id</td>
<td><% out.println(session.getId()); %></td>
</tr>
<tr>
<td>마지막 접속 시간</td>
<td><% out.println(lastAccessTime); %></td>
</tr>
<tr>
<td>User Id</td>
<td><% out.println(userID); %></td>
</tr>
<tr>
<td>방문 회수</td>
<td><%out.println(visitCount); %></td>
</tr>
</table>
</body>
</html>