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
		String noodle = request.getParameter("noodle");
		String snack = request.getParameter("snack");
		String[] games = request.getParameterValues("game");
	%>
	선택한 항목은 다음과 같습니다.<br/>
	면류 : <%=noodle %><br/>
	빵류 : <%=snack %><br/>
	게임 : <% 
			for(int i=0; i<games.length; i++){
				out.println("<b>"+games[i]+" </b>");
			}
		 %>
</body>
</html>