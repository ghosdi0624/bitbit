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
		String ID = request.getParameter("ID");
		String PW = request.getParameter("PW");
		String AdminId = application.getInitParameter("AdminId");
		String AdminPw = application.getInitParameter("AdminPw");
		
		session.setAttribute("ID", ID);
		session.setAttribute("PW", PW);
		
		if(ID.equals(AdminId)){
			out.println("로그인에 성공했습니다.");%>
		<a href = "loginTest3.jsp">로그인체크</a>
	<%	} else{ 
			out.println("아이디 불일치");%>
		<a href = loginTest1.jsp>처음부터</a>			
	<%	}
	%>

</body>
</html>