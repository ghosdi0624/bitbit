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
	
	String id = "";
	Cookie[] cookies = request.getCookies();
	if(cookies != null && cookies.length > 0){
		for(int i=0; i<cookies.length; i++){
			if(cookies[i].getName().equals("Idc"));
				id = cookies[i].getValue();
		}
	}
	
%>
<form method = "post" action = "LoginCookie2.jsp">
관리자 로그인하세요.<br/>
ID : <input type = "text" name = "ID" value = "<%=id%>">
<input type = "checkbox" name = "idstore" value = "store">아이디 기억<br/>
Password : <input Type = "password" name = "PW"><br/>
<input type = "submit" value = "전송">
</form>
</body>
</html>