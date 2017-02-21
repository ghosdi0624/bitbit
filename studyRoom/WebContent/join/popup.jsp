<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	alert("${param.id}")
</script>


</head>
<body>
	<div align="center">
		<form method="get"
			action="${ pageContext.request.contextPath }/join/myPage.jsp">
			탈퇴하시겠습니까??<br />
			<br /> <input type="submit" value="예" name="answer" />&nbsp; <input
				type="submit" value="아니오" name="answer" />
		</form>
	</div>



</body>
</html>