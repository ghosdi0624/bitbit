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
	function cancleReserve(roomName, hotelName, checkIn){
		
		if(confirm("정말 취소 하시겠습니까?")){
			alert('취소 되었습니다');
			location.href = '${pageContext.request.contextPath}/reserve/cancleReserve.do?roomName='+roomName+'&hotelName='+hotelName+'&checkIn='+checkIn;
		}		
	
	}
</script>

</head>
<body>
	<header>
		<c:import url="/include/topmenu.do" />
	</header>
	
	<section>
	<div>
		<div style="position: absolute; width: 1000px">
			<c:import url="/include/sidemenu.do" />
		</div>
		<c:forEach var="list" items="${ list }">
		<table width="90%" id="reserve" style="margin-top: 1%; border-bottom: none; margin-left: 5%">
					<tr>
						<td rowspan="5" width="20%" height="30px"></td>
						<th align="left" height="30px">${ list.roomName } <span style="font-size: 8pt">in ${ list.hotelName }</span>
						</th> 				
					</tr>
					<tr>
						<td>
							체크인 : <span style="color: red"><b>${ list.checkIn }</b></span>
						</td>
					</tr>
					<tr>
						<td> 
							체크아웃 : <span style="color: red"><b>${ list.checkOut }</b></span>
						</td>
					</tr>
					<tr>
						<td>
							이용인원 : ${ list.personNum }명
						</td>
					</tr>
					<tr>
						<td>
							이용요금 : ${ list.price }원 &nbsp; 
							<c:if test="${ list.status == 1 }">
								<span style="color: red"><b>미결제</b></span> &nbsp;
								<div align="right">
									<input type="button" value=" 예약취소 " onclick="cancleReserve('${list.roomName}','${list.hotelName}','${list.checkIn}')"> 
								</div>
							</c:if>
							<c:if test="${ list.status == 2 }">
								<span style="color: blue"><b>결제완료</b></span> &nbsp; 
							</c:if>
						</td> 
					</tr>
				</table>
				<br/>
				</c:forEach>
	</div>
	</section>
	
	<footer>
		<c:import url="/include/footer.do" />
	</footer>
</body>
</html>