<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="BloodType.jsp">
		이름을 입력하세요<input type="text" name="name"><br /> 당신의 혈액형은 ? <br />
		<input type="radio" name="blood" value="O">O형<br /> <input
			type="radio" name="blood" value="A">A형<br /> <input
			type="radio" name="blood" value="B">B형<br /> <input
			type="radio" name="blood" value="AB">AB형<br /> <input
			type="submit" value="보내기">
	</form>
</body>
</html>