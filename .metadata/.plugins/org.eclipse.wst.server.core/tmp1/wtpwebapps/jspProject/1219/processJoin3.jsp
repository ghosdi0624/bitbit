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
	%>
	<jsp:useBean id="member" class="Bean.MemberInfo" />
	<jsp:setProperty property="*" name="member" />

	아이디 :
	<jsp:getProperty property="id" name="member" /><br /> 비밀번호 :
	<jsp:getProperty property="password" name="member" /><br /> 이름 :
	<jsp:getProperty property="name" name="member" /><br /> 이메일 :
	<jsp:getProperty property="email" name="member" /><br /> 주소 :
	<jsp:getProperty property="address" name="member" /><br />
</body>
</html>