<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<meta charset="utf-8">
<title>Marker Labels</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
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

.controls {
	margin-top: 10px;
	border: 1px solid transparent;
	border-radius: 2px 0 0 2px;
	box-sizing: border-box;
	-moz-box-sizing: border-box;
	height: 32px;
	outline: none;
	box-shadow: 0 2px 6px rgba(0, 0, 0, 0.3);
	background-color: #fff;
	font-family: Roboto;
	font-size: 15px;
	font-weight: 300;
	margin-left: 12px;
	padding: 0 11px 0 13px;
	text-overflow: ellipsis;
	width: 300px;
}

#type-selector label {
	font-family: Roboto;
	font-size: 13px;
	font-weight: 300;
}
</style>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAF05JCFoefu9jROxjM8TcHc8GIR6YDhuU&libraries=places&callback=initialize"
	async defer></script>
<script>
	f = false; 
	function flag() {
		f = !f;
	}
	// 마커 레이블
	var labels = new Array('1', '2', '3', '4', '5', '6', '7', '8', '9', '10',
			'11', '12', '13', '14', '15');
	var labelIndex = 0;
	var map = "";

	function initialize() {
		// 좌표 등록
		var seoul = {
			lat : 37.6,
			lng : 127
		}; 
		map = new google.maps.Map(document.getElementById('map'), {
			zoom : 13,
			center : seoul,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		});
		
		google.maps.event.addListener(map, 'click', function(event) {

			if (f) {
				addMarker(event.latLng, map);
				f = !f;
			}
		});
		
 		var input = document.getElementById('pac-input');
		var searchBox = new google.maps.places.SearchBox(input);
		
		
	}
	var latlng1, latlng2;
	// 마커 추가
	function addMarker(location, map) {
		alert(location);				

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
	
	
	
	
	function geoCode(faddr) {

	

	 

	 var geocoder;

	 geocoder = new google.maps.Geocoder();

	 geocoder.geocode( { 'address': faddr}, function(results, status) {

	  if (status == google.maps.GeocoderStatus.OK) {

	   var faddr_lat = results[0].geometry.location.lat(); //위도

	   var faddr_lng = results[0].geometry.location.lng(); //경도

	  } else {

	   var faddr_lat = "";

	   var faddr_lng = "";

	  }

	 	/*
	  faddr_lat = faddr_lat * 1;
	  faddr_lng = faddr_lng * 1;
	  */
	  
	  var seoul = {
				lat : faddr_lat,
				lng : faddr_lng
			}; 
	  
	  
	  var output = new google.maps.LatLng(parseFloat(seoul.faddr_lat),parseFloat(seoul.faddr_lng));
	  

		//var output = "(" + faddr_lat + ", " + faddr_lng + ")";
		//var output = {lat: faddr_lat, lng: faddr_lng};
		//var output = { lat: faddr_lat, lng: faddr_lng};
		


	  //alert('주소 : ' + faddr + '\n\n위도 : ' + faddr_lat + '\n\n경도 : ' + faddr_lng);

	  
		
		
		addMarker(output, map);
		

	 });

	

	}
	
	
	
	function convert(){
		
		
		var addr = $("#pac-input").val();
		geoCode(addr);
		
	}
 
</script>
</head>
<body>
	<div id="map"></div>
	<br />
	<input id="pac-input" class="controls" type="text"
		placeholder="Search Box"> &nbsp;
	<button onclick="convert()">테스트</button>
	<input type="button" value=" 마커추가 " onclick="flag()" />
	<input type="button" value=" 출발 " onclick="" />
	<input type="button" value=" 도착 " onclick="" />
</body>
</html>