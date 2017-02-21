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
		String[] product = request.getParameterValues("product");
	%>
	당신이 선택한 제품은
	<%
		for(int i=0; i<product.length; i++){
			out.println("<b>"+product[i]+",</b>");
		}
	%> 입니다.
</body>
</html>