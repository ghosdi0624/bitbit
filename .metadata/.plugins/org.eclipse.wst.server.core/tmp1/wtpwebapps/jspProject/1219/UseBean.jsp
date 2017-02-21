<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="member" class="Bean.MemberInfo" scope = "request"/>
	<%=member.getName()%>(<%=member.getId() %>)
	회원님 등장.<br/>
	이메일은 <%=member.getEmail() %>입니다.<br/>
	가입 날짜는 <%=member.getRegisterDate() %>입니다.
</body>
</html>