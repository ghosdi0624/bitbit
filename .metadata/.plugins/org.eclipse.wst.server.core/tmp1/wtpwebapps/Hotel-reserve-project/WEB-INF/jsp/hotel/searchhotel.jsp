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
	<c:import url="/include/sidemenu.do" />
	<div style="margin-left:20%; padding-top:2%">
		<table width="90%">
		<c:forEach var="list" items="${ list }">
			<tr>
				<td rowspan="2" width="20%" height="30px">
					<img width="260px" height="200px" src="${ pageContext.request.contextPath }/resources/photo/${list.newMainFile}">
				</td>
				<th align = "left">
					<a href="${ pageContext.request.contextPath }/hotel/detail.do?name=${list.hotelName}">
					${ list.hotelName }</a>
				</th>
			</tr>
			<tr>
				<td>
				<c:if test="${ list.internet != 'no' }">☞ free internet<br/></c:if>
				<c:if test="${ list.parking != 'no' }">☞ free parking<br/></c:if>
				<c:if test="${ list.breakfast != 'no' }">☞ free breakfast</c:if>
				<div align="right">
					<c:forEach var="roomList" items="${ roomList }">
						<c:if test="${ list.hotelName == roomList.hotelName }">
							최저가 : <span style="color: red"><b>￦${ roomList.price }</b></span>
						</c:if>
					</c:forEach>
				</div>
				</td>
			</tr>
		</c:forEach>
		</table>
	</div>
	</section>	
	<footer>
		<c:import url="/include/footer.do" />
	</footer>
</body>
</html>