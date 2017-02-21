<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="Bean.MemberInfo, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		MemberInfo member = new MemberInfo();
		member.setId(request.getParameter("id"));
		member.setPassword(request.getParameter("password"));
		member.setName(request.getParameter("name"));
		member.setEmail(request.getParameter("email"));
		member.setAddress(request.getParameter("address"));
		member.setRegisterDate(new Date());
	%>
	아이디 : <%=member.getId() %><br/>
	비밀번호 : <%=member.getPassword() %><br/>
	이름 : <%=member.getName() %><br/>
	이메일 : <%=member.getEmail() %><br/>
	주소 : <%=member.getAddress() %><br/>
	등록일 : <%=member.getRegisterDate() %><br/>
</body>
</html>