<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="/studyRoom/css/styles.css" rel="stylesheet" type="text/css">
<title>main</title>
</head>
<body>
<div class="wrapper">
<header>
		<%@include file="/include/header.jsp"%>
</header>
	<!-- 센터 이미지  -->
 	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
		</ol>
		
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img id="image" src="/studyRoom/img/img1.png" alt="study1">
			</div>
			<div class="item">
				<img id="image" src="/studyRoom/img/img2.png" alt="study2">
			</div>
		</div>
		
		<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    		<span class="sr-only">Previous</span>
		</a>
		<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    		<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    		<span class="sr-only">Next</span>
  		</a>
	</div>
	
	<br/>
	<br/>
	
	<!-- 예약하기 버튼   -->
	<div align="center">
		<a href="${ pageContext.request.contextPath }/reserveForm.do" class="main_button">예약하기</a>
	</div>
</div>
<footer>
      <%@include file="/include/footer.jsp"%>
</footer>
</body>
</html>