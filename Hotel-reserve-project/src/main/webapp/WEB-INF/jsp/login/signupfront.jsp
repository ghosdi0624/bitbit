<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/board.css" />
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/layout.css" />
</head>
<body>
	<header>
		<c:import url="/include/topmenu.do" />
	</header>
	
	<section>
	<div align="center">
		<table width = "80%" height ="400px" style="margin-top: 50px">
			<tr>
				<td align = "center" width="50%">
					<input type="button" value=" 일반 회원 가입 " style="width: 300px; height: 200px" 
						onclick="javascript:location.href='${ pageContext.request.contextPath }/member/memberform.do'"/>
				</td>
				<td align = "center" width="50%">
					<input type="button" value=" 기업 회원 가입 " style="width: 300px; height: 200px" 
						onclick="javascript:location.href='${ pageContext.request.contextPath }/company/companyform.do'"/>
				</td>
			</tr>
		</table>
	</div>
	</section>
	
	<footer>
		<c:import url="/include/footer.do" />
	</footer>
</body>
</html>