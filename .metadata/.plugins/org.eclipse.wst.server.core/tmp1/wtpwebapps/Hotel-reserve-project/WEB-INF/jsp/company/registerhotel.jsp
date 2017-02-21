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
	<form method="post" action="${ pageContext.request.contextPath }/company/secondregisterhotel.do">
	<div align="center">
		<h2>숙소 등록</h2>
		<hr width="80%" /><br/>
		<table width="70%">
			<tr>
				<td>호텔 이름</td>
				<td><input type="text" name="hotelName" size="30"/></td>
			</tr>	
			<tr>
				<td>무료 사용 가능 여부</td>
				<td>
					<input type="checkbox" name="internet"/>&nbsp; 인터넷
					<input type="checkbox" name="parking"/>&nbsp; 주차장
					<input type="checkbox" name="breakfast"/>&nbsp;	조식
				</td>
			</tr>
			<tr>
				<td>호텔 주소</td>
				<td><input type="text" name="addr" value="${ userVO.addr }" size="50"/></td>
			</tr>
			<tr>
				<td>호텔 소개</td>
				<td><textarea cols="70" rows="10" name="introduce" ></textarea></td>
			</tr>
		</table><br/>
		<input type="submit" value=" 다음으로 "/>
	</div>
	</form>
	</section>
	
	<footer>
		<c:import url="/include/footer.do" />
	</footer>
</body>
</html>