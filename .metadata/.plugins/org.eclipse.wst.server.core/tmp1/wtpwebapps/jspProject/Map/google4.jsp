<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<meta charset="utf-8">
<title>Marker Labels</title>
<style>
html, body {
	height: 500px;
	margin: 0;
	padding: 0;
}

#map {
	height: 500px;
	width: 500px;
}
</style>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAF05JCFoefu9jROxjM8TcHc8GIR6YDhuU"></script>
<script>
	
	var checkPoint = new Array();

	f = false;
	function flag() {
		f = !f;
	}
	// 마커 레이블
	var labels = new Array('1', '2', '3', '4', '5', '6', '7', '8', '9', '10',
			'11', '12', '13', '14', '15');
	var labelIndex = 0;

	function initialize() {
		// 좌표 등록
		var bangalore = {
			lat : 37.56461982743129,
			lng : 126.9823439963945 
		};
		var map = new google.maps.Map(document.getElementById('map'), {
			zoom : 15,
			center : bangalore
		});

		google.maps.event.addListener(map, 'click', function(event) {

			if (f) {
				addMarker(event.latLng, map);
				f = !f;
			}
		});
		
		newLine(map);
	}
	
	function newLine(map){
		
	}

	var latlng1, latlng2;
	// 마커 추가
	function addMarker(location, map) {

		var marker = new google.maps.Marker({
			position : location,
			label : labels[labelIndex++],
			map : map
		});
		
		
		latlng1 = location;
		var flightPlanCoordinates = [ latlng1, latlng2 ];
		var flightPath = new google.maps.Polyline({
			path : flightPlanCoordinates,
			geodesic : true,
			strokeColor : '#FF0000',
			strokeOpacity : 1.0,
			strokeWeight : 2
		});

		flightPath.setMap(map);

		latlng2 = latlng1;

	}

	google.maps.event.addDomListener(window, 'load', initialize);
</script>
</head>
<body>
	<div id="map"></div>
	<br />
	<input type="button" value=" 마커추가 " onclick="flag()" />
	<input type="button" value=" 출발 " onclick="" />
	<input type="button" value=" 도착 " onclick="" />
</body>
</html>