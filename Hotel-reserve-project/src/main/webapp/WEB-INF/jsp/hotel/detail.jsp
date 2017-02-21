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
<script type="text/javascript">
	function goReserve(){
		if(${empty userVO}){
			alert("로그인 후 이용 가능합니다.");
			location.href = "${ pageContext.request.contextPath }/login/memberloginform.do";
			return false;
		} else {
		 return true;	
		}
	}
</script>
<body>
	<header>
		<c:import url="/include/topmenu.do" />
	</header>
	
	<section>
		<c:import url="/include/sidemenu.do" />
		<form method="post" action="${pageContext.request.contextPath}/reserve/reserveform.do" onsubmit="return goReserve()">
		<input type="hidden" name="hotelName" value="${ companyInfo.hotelName }"/>
		<div style="margin-left:25%; padding-top:2%; float:center">
			<table width="90%" class="addrInfo">
				<tr>
					<th align = "left">${ companyInfo.hotelName }</th>
				</tr>
				<tr>
					<td>${ companyInfo.addr }
					<div align="right"><input type="submit" value=" 지금 예약하기 "/></div>
					</td>
				</tr>
			</table><br/>
			<table width="90%" height="300px">
				<tr>
					<td>
						<img src="${ pageContext.request.contextPath }/resources/photo/${companyInfo.newMainFile}" width="850px" height="400px"/>
						<c:forEach var="list" items="${ list }">
							<img src="${pageContext.request.contextPath }/resources/photo/${list.newFile}" width="100px" height="100px"/>
						</c:forEach>
					</td>
				</tr>
			</table><br/>
			<table width="90%">
				<tr>
					<th>호텔 소개</th>
				</tr>
				<tr>
					<td>${ companyInfo.introduce }</td>
				</tr>
			</table><br/>
			<table width="90%">
				<tr>
					<th colspan="2">호텔 시설</th>
				</tr>
				<tr>
					<th width="20%">일반 사항</th>
					<td>${ facilities.basic }</td>
				</tr>
				<tr>
					<th>편의 시설</th>
					<td>${ facilities.convenience }</td>
				</tr>
				<tr>
					<th>서비스</th>
					<td>${ facilities.service }</td>
				</tr>
				<tr>
					<th>인터넷</th>
					<td>${ facilities.internet }</td>
				</tr>
				<tr>
					<th>주차</th>
					<td>${ facilities.parking }</td>
				</tr>
				<tr>
					<th>체크인</th>
					<td>· ${ facilities.checkIn } 이후</td>
				</tr>
				<tr>
					<th>체크아웃</th>
					<td>· ${ facilities.checkOut } 이전</td>
				</tr>
			</table><br/>
			
	</div>
	</form>
	</section>
	
	<footer>
		<c:import url="/include/footer.do" />
	</footer>
</body>
</html>