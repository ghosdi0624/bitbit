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
<script src="/webjars/jquery/3.1.1/dist/jquery.min.js" ></script>
<style type="text/css">
table#reserve tr{
	border-bottom: 1px solid #D4E0EE;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		
	});
	
	function changeprice(){
		var form = document.inputform;
		var day = form.day.value;
		form.price.value='${roomVO.price}'*day;
	}
</script>
</head>
<body>
	<header>
		<c:import url="/include/topmenu.do" />
	</header>
	
	<section>
		<form name="inputform" action="${pageContext.request.contextPath}/reserve/reserve.do" method="post">
		<input type="hidden" name="hotelName" value="${hotelName }"/>
		<input type="hidden" name="roomName" value="${roomName }"/>
		<input type="hidden" name="checkIn" value="${checkIn }"/>
		<div id="roominfo">
			<h2>객실 정보</h2>
			<c:forEach var="list" items="${ list }">
				<div align="left" style="width: 80%">
					<div style="size: 10px">${ list.roomName } ${ list.price }원</div>
				</div>
				<br />
			</c:forEach> 
		</div>
		<div style="margin-left:25%; float:center; padding-top:2%" >
		<table width="90%" id="reserve">
					<tr>
						<td rowspan="5" width="20%" height="30px">
						<img  width="260px" height="200px" src="${ pageContext.request.contextPath }/resources/photo/${roomVO.newRoomFile}" /></td>
						<th align="left" height="30px">${ roomName } <span style="font-size: 8pt">in ${ hotelName }</span></th> 
					</tr>
					<tr>
						<td>
							이용시작일 : <span style="color: red"><b>${ checkIn }</b></span>
						</td>
					</tr>
					<tr>
						<td>
							이용기간 : 
							<select name="day" onchange="changeprice()">
								<c:forEach var="i" begin="1" end="${ num }">
									<option value=${ i }>${ i }박
								</c:forEach>
							</select>&nbsp;	
							이용인원 : 
							<select name="personNum">
								<c:forEach var="i" begin="1" end="${roomVO.maxCapacity}">
									<option value=${ i }>${ i }명
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							기준 : ${ roomVO.minCapacity }명  /  최대 : ${ roomVO.maxCapacity }명
						</td>
					</tr>
					<tr>
						<td>
							이용요금 : 
							<input type="text" name="price" value="${ roomVO.price }" size="15" style="text-align: right" readonly="readonly"/>원
						</td>
					</tr>
				</table><br/>
				<div style="width:90%" align="right"><input type="submit" value=" 예약하기 "/></div>
		</div>
	</form>
	</section>
	<footer>
		<c:import url="/include/footer.do" />
	</footer>
</body>
</html>