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
	<form method="post" action="${ pageContext.request.contextPath }/company/register.do">
	<div align="center">
		<h2>숙소 등록</h2>
		<hr width="80%" /><br/>
		<table width="70%">
			<tr width="30%">
				<td>일반 사항</td>
				<td>
					<input type="checkbox" name="basic" value="장애인 편의시설"/>&nbsp; 장애인 편의시설&nbsp;
					<input type="checkbox" name="basic" value="에어컨"/>&nbsp; 에어컨&nbsp;
					<input type="checkbox" name="basic" value="금연실"/>&nbsp; 금연실&nbsp;
					<input type="checkbox" name="basic" value="헤어드라이어"/>&nbsp; 헤어드라이어&nbsp;
					<input type="checkbox" name="basic" value="TV"/>&nbsp; TV&nbsp;
					<input type="checkbox" name="basic" value="데스크"/>&nbsp; 데스크&nbsp;<br/>
					<input type="checkbox" name="basic" value="장애인 주차시설"/>&nbsp; 장애인 주차시설&nbsp;
					<input type="checkbox" name="basic" value="스위트룸"/>&nbsp; 스위트룸&nbsp;
					<input type="checkbox" name="basic" value="개인욕실"/>&nbsp; 개인욕실&nbsp;
					<input type="checkbox" name="basic" value="비데"/>&nbsp; 비데&nbsp;
					<input type="checkbox" name="basic" value="자판기"/>&nbsp; 자판기&nbsp;
				</td>
			</tr>	
			<tr>
				<td>편의 시설</td>
				<td>
					<input type="checkbox" name="convenience" value="사우나"/>&nbsp; 사우나
					<input type="checkbox" name="convenience" value="정원"/>&nbsp; 정원
					<input type="checkbox" name="convenience" value="거주지"/>&nbsp; 거주지
					<input type="checkbox" name="convenience" value="피트니스센터"/>&nbsp; 피트니스센터
					<input type="checkbox" name="convenience" value="수영장"/>&nbsp; 수영장
					<input type="checkbox" name="convenience" value="마사지/관리 샵"/>&nbsp; 마사지/관리 샵
				</td>
			</tr>
			<tr>
				<td>서비스</td>
				<td>
					<input type="checkbox" name="service" value="비즈니스센터"/>&nbsp; 비즈니스센터
					<input type="checkbox" name="service" value="컨시어지 서비스"/>&nbsp; 컨시어지 서비스
					<input type="checkbox" name="service" value="투어 데스크"/>&nbsp; 투어 데스크
					<input type="checkbox" name="service" value="엘리베이터"/>&nbsp; 엘리베이터<br/>
					<input type="checkbox" name="service" value="24시간 리셉션"/>&nbsp; 24시간 리셉션
					<input type="checkbox" name="service" value="컨퍼런스룸"/>&nbsp; 컨퍼런스룸
					<input type="checkbox" name="service" value="환전"/>&nbsp; 환전
					<input type="checkbox" name="service" value="외국어 구사직원"/>&nbsp; 외국어 구사직원
					<input type="checkbox" name="service" value="안전금고"/>&nbsp; 안전금고<br/>
					<input type="checkbox" name="service" value="모닝콜 서비스"/>&nbsp; 모닝콜 서비스
					<input type="checkbox" name="service" value="회의실"/>&nbsp; 회의실
					<input type="checkbox" name="service" value="복사기"/>&nbsp; 복사기
					<input type="checkbox" name="service" value="물품 보관소"/>&nbsp; 물품 보관소
					<input type="checkbox" name="service" value="흡연구역"/>&nbsp; 흡연구역
				</td>
			</tr>
			<tr>
				<td>인터넷</td>
				<td>
					<input type="checkbox" name="internet" value="무선인터넷"/>&nbsp; 무선인터넷
				</td>
			</tr>
			<tr>
				<td>주차</td>
				<td>
					<input type="checkbox" name="parking" value="무료주차장"/>&nbsp; 무료주차장
					<input type="checkbox" name="parking" value="공항 셔틀버스 제공"/>&nbsp; 공항 셔틀버스 제공
					<input type="checkbox" name="parking" value="발렛파킹"/>&nbsp; 발렛파킹
				</td>
			</tr>
			<tr>
				<td>체크인</td>
				<td>
					<select name="check-in">
						<option value="9:00">9:00</option>
						<option value="10:00">10:00</option>
						<option value="11:00">11:00</option>
						<option value="12:00">12:00</option>
						<option value="13:00">13:00</option>
						<option value="14:00" selected="selected">14:00</option>
						<option value="15:00">15:00</option>
					</select> 이후
				</td>
			</tr>
			<tr>
				<td>체크아웃</td>
				<td>
					<select name="check-out">
						<option value="9:00">9:00</option>
						<option value="10:00">10:00</option>
						<option value="11:00">11:00</option>
						<option value="12:00" selected="selected">12:00</option>
						<option value="13:00">13:00</option>
						<option value="14:00">14:00</option>
						<option value="15:00">15:00</option>
					</select> 이전
				</td>
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