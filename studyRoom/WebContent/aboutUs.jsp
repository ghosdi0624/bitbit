<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://use.fontawesome.com/70213049c5.js"></script>
<link href="/studyRoom/css/styles.css" rel="stylesheet" type="text/css">
<title>소개</title>
</head>

<body>


<div class="wrapper">
	<header> 
		<%@include file="/include/header.jsp"%>
	</header>

		<div class="introTitle">노량진스터디룸 소개</div>
		<hr><br/><br/>
		
		

		<div id="myCarousel2" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#myCarousel2" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel2" data-slide-to="1"></li>
				<li data-target="#myCarousel2" data-slide-to="2"></li>
				<li data-target="#myCarousel2" data-slide-to="3"></li>
			</ol>
			
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img id="image2" src="/studyRoom/img/aboutUs0.png" alt="aboutUs0">
				</div>				
				<div class="item">
					<img id="image2" src="/studyRoom/img/aboutUs1.png" alt="aboutUs1">
				</div>
				<div class="item">
					<img id="image2" src="/studyRoom/img/aboutUs2.png" alt="aboutUs2">
				</div>
				<div class="item">
					<img id="image2" src="/studyRoom/img/aboutUs4.jpg" alt="aboutUs4">
				</div>
			</div>
			
			<a class="left carousel-control" href="#myCarousel2" role="button" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	    		<span class="sr-only">Previous</span>
			</a>
			<a class="right carousel-control" href="#myCarousel2" role="button" data-slide="next">
	    		<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	    		<span class="sr-only">Next</span>
	  		</a>
	</div>

		<br/><br/>
		<!-- 찾아오는길 -->
		
		<center>
		<div class="map" id="map" style="width: 500px; height: 400px;"></div>
		</center>
		<br/>

				<script type="text/javascript"
			src="//apis.daum.net/maps/maps3.js?apikey=f32352081b1cce6ebd6b726114e25dee"></script>
		<script>
			var container = document.getElementById('map');
			var options = {
				center : new daum.maps.LatLng(37.513294, 126.945136),
				level : 3
			};

			var map = new daum.maps.Map(container, options);
			
			var marker = new daum.maps.Marker({ 
			    // 지도 중심좌표에 마커를 생성합니다 
			    position: map.getCenter() 
			}); 
			// 지도에 마커를 표시합니다
			marker.setMap(map);
		</script>

		<center>
			<div >
				<br/><br/>
				영업시간 <br />
			</div>
			<div >
				09:00 ~ 22:00 (월 ~ 토)<br /> 09:00 ~ 18:00 (일)<br /> <br /> 카카오톡 아이디 :
				nstudyroom<br /> 전화번호 : 010-4488-7949<br /> 주소: <br/>서울특별시 동작구 노량진동 126-12
				지하1층<br /> <br />
			</div>
		</center>
			
			
			<div class="center">
			<a href="http://map.daum.net/link/to/노량진스터디룸,37.513294,126.945136" class="btn btn-default btn-lg">길찾기 바로가기</a>
			</div>
		</div>

		
	<footer> <%@include file="/include/footer.jsp"%>
	</footer>
</body>
</html>