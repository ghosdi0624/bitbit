<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/board.css" />
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/layout.css" />

</head>
<body>
	<header>
		<c:import url="/include/topmenu.do" />
	</header>

	<section>
		<form method="post"
			action="${ pageContext.request.contextPath }/company/roomregister.do"
			enctype="multipart/form-data">
			<div align="center">
				<h2>숙소 등록</h2>
				<hr width="80%" />
				<br />
				<table style="border: 1px solid #D4E0EE;">
					<tr>
						<th>호텔 이름</th>
						<td>
							<select name="hotelName">
								<c:forEach var="list" items="${ list }">
									<option value="${ list.hotelName }"> ${list.hotelName }
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<th>방 이름</th>
						<td><input type="text" name="roomName" size="25" /></td>
					</tr>
					<tr>
						<th> 인원</th>
						<td>
						<select name="minCapacity">
								<option value="1" selected="selected">1명
								<option value="2">2명
								<option value="3">3명
								<option value="4">4명
								<option value="5">5명
						</select>~
						<select name="maxCapacity">
								<option value="1" selected="selected">1명
								<option value="2">2명
								<option value="3">3명
								<option value="4">4명
								<option value="5">5명
								<option value="6">6명
								<option value="7">7명
								<option value="8">8명
								<option value="9">9명
						</select></td>
					</tr>
					<tr>
						<th>1박 가격</th>
						<td><input type="text" size="20" name="price"
							placeholder="숫자만 입력" style="text-align: right" />원</td>
					</tr>
					<tr>
						<th>방 소개</th>
						<td><textarea cols="70" rows="5" name="introduce"></textarea></td>
					</tr>
					<tr>
						<th>방 사진</th>
						<td><input type="file" name="room" value=" 사진 등록 " /></td>
					</tr>
				</table>
				<br />
				<br /> <input type="submit" value=" 등록완료 " />
			</div>
		</form>
	</section>

	<footer>
		<c:import url="/include/footer.do" />
	</footer>
</body>
</html>