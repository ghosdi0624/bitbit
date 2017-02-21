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
		String[] chks = request.getParameterValues("chk");
		String[] ltes = request.getParameterValues("LTE");
	%>	
	
	당신의 관심제품은 <br/>
	<%
		for(int i=0; i<chks.length; i++){
			out.println("<b>"+chks[i]+"</b>");
		}
	%> 이고 <br/>
	요금제는
	<%
		for(int i=0; i<ltes.length; i++){
			out.println("<b>"+ltes[i]+"</b>");
		}
	%> 를 선택하셨습니다.
	
</body>
</html>