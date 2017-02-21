<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	
		String season[] = request.getParameterValues("season");
		String fruit[] = request.getParameterValues("fruit");
		String id = (String)session.getAttribute("idKey");
		
		String sessionId = session.getId();
		int time = session.getMaxInactiveInterval();
		
	%>
	<%=id %>님이 좋아하는 계절과 과일은<p>
	<%
	for(int i = 0; i<season.length; i++)
		out.println("<b>"+season[i]+"</b>");
	%>과 
	<%
	for(int i = 0; i<fruit.length; i++)
		out.println("<b>"+fruit[i]+"</b>");
	%> 입니다. <p>
	
	세션 ID :	<%=sessionId%><p>
	세션 유지 시간 : <%=time%>초
</body>
</html>