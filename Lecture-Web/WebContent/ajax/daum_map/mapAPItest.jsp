<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src = "http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=046ac75236bb37b591a0184249baa017"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		var options = { //지도를 생성할 때 필요한 기본 옵션
			center: new daum.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
			level: 3 //지도의 레벨(확대, 축소 정도)
		};
		
		$('#btn01').click(function(){
			setBounds();
		});

		var map = new daum.maps.Map(container, options); //지도 생성 및 객체 리턴
		
		// 버튼을 클릭하면 아래 배열의 좌표들이 모두 보이게 지도 범위를 재설정합니다 
		var points = [
		    new daum.maps.LatLng(37.404787, 126.907456),
		    new daum.maps.LatLng(37.404787, 126.907456),
		    new daum.maps.LatLng(37.404787, 126.907456)
		];

		// 지도를 재설정할 범위정보를 가지고 있을 LatLngBounds 객체를 생성합니다
		var bounds = new daum.maps.LatLngBounds();    

		var i, marker;
		for (i = 0; i < points.length; i++) {
		    // 배열의 좌표들이 잘 보이게 마커를 지도에 추가합니다
		    marker = new daum.maps.Marker({ position : points[i] });
		    marker.setMap(map);
		    
		    // LatLngBounds 객체에 좌표를 추가합니다
		    bounds.extend(points[i]);
		}

		function setBounds() {
		    // LatLngBounds 객체에 추가된 좌표들을 기준으로 지도의 범위를 재설정합니다
		    // 이때 지도의 중심좌표와 레벨이 변경될 수 있습니다
		    map.setBounds(bounds);
		}
		////////////////////////////////////////////////////////////////////
		
		// 마커가 표시될 위치입니다 
		var markerPosition  = new daum.maps.LatLng(33.450701, 126.570667); 

		// 마커를 생성합니다
		var marker = new daum.maps.Marker({
	    position: markerPosition
		});

		// 마커가 지도 위에 표시되도록 설정합니다
		marker.setMap(map);
	});

</script>
</head>
<body>
	<h2>지도 서비스</h2>
	<div id="map" style="width:1000px;height:450px; border:1px solid red"></div>
	<button id = "btn01">우리집 지도 보기</button> 
	
</body>
</html>