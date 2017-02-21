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
<jsp:useBean id="member" class="Bean.MemberInfo"/>
<jsp:setProperty property="id" name="member" param="id"/>
<jsp:setProperty property="name" name="member" param="name"/>
자바빈 처리완료<br/>
아이디 : <%=member.getId() %>, 이름 : <%=member.getName() %>
</body>
</html>