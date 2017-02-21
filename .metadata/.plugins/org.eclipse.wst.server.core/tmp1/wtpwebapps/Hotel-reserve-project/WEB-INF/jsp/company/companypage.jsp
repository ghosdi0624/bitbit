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
<script type="text/javascript">
	if("${msg}"){
		alert("${msg}");
	}
</script>

</head>
<body>
	<header>
		<c:import url="/include/topmenu.do" />
	</header>
	
	<section>
		<div style="margin-left:10%; padding-top:2%" >
		<table width="90%" id="reserve">
				<tr>
					<th>호텔이름</th>
					<th>예약자ID</th>
					<th>방이름</th>
					<th>체크인</th>					
					<th>체크아웃</th>					
					<th>숙박인원</th>
					<th>금액</th>
					<th>결제상태</th>
				</tr>	
				<c:forEach var="list" items="${ list }">
					<tr>
						<td align="center">${ list.hotelName }</td>
						<td align="center">${ list.memberNo }</td>
						<td align="center">${ list.roomName }</td>
						<td align="center">${ list.checkIn }</td>
						<td align="center">${ list.checkOut }</td>
						<td align="center">${ list.personNum }명</td>
						<td align="right">${ list.price }원</td>
						<td align="center">
							<c:if test="${ list.status == 1 }">
								<span style="color: red"><b>미결제</b></span>
							</c:if>
							<c:if test="${ list.status == 2 }">
								<span style="color: blue"><b>결제완료</b></span>
							</c:if>
						</td>
					</tr>
				</c:forEach>
		</table><br/> 
		<div align="right" style="margin-right: 11%"><input type="submit" value=" 수정완료 "/></div>
		</div>
	</section>
	
	<footer>
		<c:import url="/include/footer.do" />
	</footer>
</body>
</html>