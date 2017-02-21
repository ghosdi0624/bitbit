<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");

	Calendar cal = Calendar.getInstance(); //현재 시스템이 가지고 있는 날짜 데이터 가지고 오기

	int y = cal.get(Calendar.YEAR);
	int m = cal.get(Calendar.MONTH) + 1;
	int d = cal.get(Calendar.DATE);

	String _y = request.getParameter("y");
	String _m = request.getParameter("m");

	if (_y != null)
		y = Integer.parseInt(_y);
	if (_m != null)
		m = Integer.parseInt(_m);

	//y년 m월 1일의 요일
	cal.set(y, m - 1, 1);
	y = cal.get(Calendar.YEAR);
	m = cal.get(Calendar.MONTH) + 1;

	int w = cal.get(Calendar.DAY_OF_WEEK); //1(일)~7(토) => 일요일일때 w에 1. 메소드를 외우면 된다.
	int last = cal.getActualMaximum(Calendar.DATE);
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/board.css" />
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/layout.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
div#calendar {
	margin-top: 0;
	padding: 0;
	font-famaily: 돋움;
	font-size: 9pt;
}

div#calendar {
	font-size: 9pt;
}

a:HOVER {
	text=decoration: underline;
	color: yellow;
}

</style>

<script type="text/javascript">
	function changeDate() {
		var y = document.getElementById("y").value;
		var m = document.getElementById("m").value;
		var url = "${pageContext.request.contextPath}/reserve/reserveform.do?y=" + y + "&m=" + m + "&hotelName=${hotelName}";
		location.href = url; //url이 가지고 있는 값으로 이동
	}
	
</script>
</head>
<body>
	<header>
		<c:import url="/include/topmenu.do" />
	</header>
	<br>
	<br>
	<br>
	<section>
	<form name="inputform">
		<div id="roominfo">
			<h2>객실 정보</h2>
			<c:forEach var="list" items="${ list }">
				<div align="left" style="width: 80%">
					<div style="size: 10px">${ list.roomName } ${ list.price }원</div>
				</div>
				<br />
			</c:forEach> 
		</div>
		<div align="center" id="calendar">
		<div align="right" style="margin-right: 9%">
			<span style="text-align: right"><span style="color: white; background-color: green"><b>가</b></span>예약가능</span>
			<span style="text-align: right"><span style="color: white; background-color: blue"><b>진</b></span>예약진행중</span>
			<span style="text-align: right"><span style="color: white; background-color: red"><b>완</b></span>예약완료</span>
		</div>
		<table style="float:center; bgcolor:#ff22cc">
			<caption style="height: 20px;">

				<select id="y" onchange="changeDate();">
					<c:forEach var="i" begin="${ y-1 }" end="${ y-1 }">
						<option value="${ i }">${ i }년</option>
					</c:forEach>
					<%
						for (int i = y - 1; i <= y - 1; i++) {
					%>
					<option value="<%=i%>"><%=i%>년</option>
					<%
						}
					%>
					<option value="<%=y%>" selected="selected"><%=y%>년</option>
					<%
						for (int i = y + 1; i <= y + 3; i++) {
					%>
					<option value="<%=i%>"><%=i%>년</option>
					<%
						}
					%>
				</select> 
				<select id="m" onchange="changeDate();">
					<%
						for (int i = 1; i <= 12; i++) {
					%>
					<option value="<%=i%>" <%=m == i ? "selected='selected'" : ""%>><%=i%>월</option>
					<%
						}
					%>
				</select>
			
			</caption>

			<tr height="25">
				<td width="100" bgcolor="pink" align="center"><font color="red">일</font></td>
				<td width="100" bgcolor="#c8c8c8" align="center">월</td>
				<td width="100" bgcolor="#c8c8c8" align="center">화</td>
				<td width="100" bgcolor="#c8c8c8" align="center">수</td>
				<td width="100" bgcolor="#c8c8c8" align="center">목</td>
				<td width="100" bgcolor="#c8c8c8" align="center">금</td>
				<td width="100" bgcolor="lightblue" align="center"><font color="blue">토</font></td>
			</tr>

			<%
				//1일 앞부분 공백처리
				out.println("<tr height='25'>");
				for (int i = 1; i < w; i++) {
					out.println("<td bgcolor='#ffffff'>&nbsp;</td>");
				}
				//1~마지막일 계산
				String fc;
				for (int i = 1; i <= cal.getActualMaximum(Calendar.DATE); i++) {
					fc = w % 7 == 1 ? "red" : (w % 7 == 0 ? "blue" : "black");
					out.println("<td bgcolor='#ffffff' style='color:" + fc + ";'>");

					out.print(i+"<br/>");
					
					String fullDate = Integer.toString(y);
					fullDate += "-";
					fullDate += Integer.toString(m).length() == 1 ? "0" + Integer.toString(m) : Integer.toString(m);
					fullDate += "-";
					fullDate += Integer.toString(i).length() == 1 ? "0" + Integer.toString(i) : Integer.toString(i);
					
		  		/*	out.print("</br>");
					out.print(fullDate);
					out.print("</br>");*/  
					
					request.setAttribute("fullDate", fullDate);
			%>

		  <c:if test="${ not empty memberList }">
				<c:forEach var="list" items="${ list }"> 
					<c:set var="flag" value ="true"/>
						<c:forEach var="memberList" items="${ memberList }">
							<c:choose>
							<c:when test="${ memberList.roomName == list.roomName && memberList.checkIn <= fullDate && memberList.checkOut > fullDate}">
								<c:if test="${ memberList.status == 1 }">
									<span style="background-color: blue; color:white"><b>진</b><span style="align: left; color: black; background-color: white">${ list.roomName }</span></span><br/>
									<c:set var="flag" value ="false"/>
								</c:if>
								<c:if test="${ memberList.status == 2 }">
									<span style="background-color: red; color:white"><b>완</b><span style="align: left; color: black; background-color: white">${ list.roomName }</span></span><br/>
									<c:set var="flag" value ="false"/>
								</c:if>
							</c:when>
						</c:choose>
						</c:forEach>
							<c:if test="${ flag eq 'true' }">
								<a href="${pageContext.request.contextPath }/reserve/reserve.do?hotelName=${hotelName}&roomName=${list.roomName}&checkIn=${fullDate}">
									<span style="background-color: green; color:white"><b>가</b><span style="align: left; color: black; background-color: white">${ list.roomName }</span></span><br/>
								</a>
							</c:if>
				</c:forEach>
			</c:if>
			
			<c:if test="${ empty memberList }">
				<c:forEach var="list" items="${ list }">
					<a href="${pageContext.request.contextPath }/reserve/reserve.do?hotelName=${hotelName}&roomName=${list.roomName}&checkIn=${fullDate}">
						<span style="align: left; color: black">(가)${ list.roomName }</span><br/>
					</a>
				</c:forEach>
			</c:if>
			
			<%
					out.print("</td>");
					
					
					w++;
					if (w % 7 == 1 && i != cal.getActualMaximum(Calendar.DATE)) {
						out.println("</tr>");
						out.println("<tr height='100'>"); // 공백 부분
						for (int j = 1; j <= 7; j++)
							out.println("<td align='center' bgcolor='#ffffff';>&nbsp;</td>");
						out.println("</tr>"); //  공백 부분
						out.println("<tr height='25'>");
					}
				}

				// 뒷부분 공백처리
				if (w % 7 != 1) {
					if (w % 7 == 0) {
						out.println("<td bgcolor='#ffffff'>&nbsp;</td>");
					} else {
						for (int i = w % 7; i <= 7; i++)
							out.println("<td bgcolor='#ffffff'>&nbsp;</td>");
					}
					out.println("</tr>");
					out.println("<tr height='100'>");// 맨아랫 부분 공백 
					for (int j = 1; j <= 7; j++)
						out.println("<td align='center' bgcolor='#ffffff';>&nbsp;</td>");
					out.println("</tr>");
				}
			%>
		</table>
	</div>
	</form>
	</section>
<footer>
		<c:import url="/include/footer.do" />
	</footer>
</body>
</html>