<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script language="javascript" src="https://apis.skplanetx.com/tmap/js?version=1&format=javascript&appKey=bac4f916-3297-3be4-93ff-e37ae88b8f42"></script>
<script type="text/javascript">

	var map, markers, lonlat, zoom, index;

		// 초기 맵설정
		function init() {
		
			 map = new Tmap.Map({div:'map_div', width:'500px', height:'300px'});
			
			 lonlat = new Tmap.LonLat(126.9863748550415, 37.560806287625354);
			
			 var pr_3857 = new Tmap.Projection("EPSG:3857"); //EPSG3857 좌표계 객체
			 var pr_4326 = new Tmap.Projection("EPSG:4326"); //EPSG4326 좌표계 객체
			 
			 lonlat.transform(pr_4326, pr_3857);
			 zoom = 14;
			 
			 map.setCenter(lonlat, zoom);          
			
			 markers = new Tmap.Layer.Markers( "MarkerLayer" );
			 map.addLayer(markers);
			  
			 var size = new Tmap.Size(24,38);
			 var offset = new Tmap.Pixel(-(size.w/2), -size.h);
			 var icon = new Tmap.Icon('https://developers.skplanetx.com/upload/tmap/marker/pin_b_m_a.png',size,offset);
			 var label = new Tmap.Label('<div>최초 시작지점</div>');
			 var marker = new Tmap.Markers(lonlat,icon,label);
			 marker.events.register("mouseover", marker, onOverMarker);
			 marker.events.register("mouseout", marker, onMarkerOut);
			 map.events.register("click", map, onClickMap);

	 } 

	window.onload = function(){
		init();
	}
	 
	// 마커 추가
 	function addMarker(){
			
			var form = document.inputForm;
			var lon = form.lon.value;
			var lat = form.lat.value;
			
			lonlat = new Tmap.LonLat(lon, lat);
			
			var pr_3857 = new Tmap.Projection("EPSG:3857"); //EPSG3857 좌표계 객체
			var pr_4326 = new Tmap.Projection("EPSG:4326"); //EPSG4326 좌표계 객체
			 
			lonlat.transform(pr_4326, pr_3857);
			zoom = 14;
			
			map.setCenter(lonlat, zoom); 
			markers = new Tmap.Layer.Markers( "MarkerLayer" );
			map.addLayer(markers);
			var size = new Tmap.Size(24,38);
			var offset = new Tmap.Pixel(-(size.w/2), -size.h);
//			var icon = new Tmap.Icon('https://developers.skplanetx.com/upload/tmap/marker/pin_b_m_a.png',size,offset);
			var iconHtml = new Tmap.IconHtml('<div style="border:red solid 1px; background-color:#FF91DC;">1</div>',size,offset);
			var label = new Tmap.Label('<div>'+document.inputForm.comment.value+'</div>');
			var marker = new Tmap.Markers(lonlat,iconHtml,label);
			markers.addMarker(marker);
	} 
 	

	function onOverMarker(evt) {
		this.popup.show();
	}

	function onMarkerOut(evt) {
		this.popup.hide();
	}
	
	// 지도 클릭해서 마커 추가
	function onClickMap(e) {

		lonlat = map.getLonLatFromViewPortPx(e.xy);
		
		lonlat = new Tmap.LonLat(lonlat.lon, lonlat.lat);
		
		zoom = 14;
		
		map.setCenter(lonlat, zoom); 
		markers = new Tmap.Layer.Markers( "MarkerLayer" );
		map.addLayer(markers);
		var size = new Tmap.Size(24,38);
		var offset = new Tmap.Pixel(-(size.w/2), -size.h);
		var icon = new Tmap.Icon('https://developers.skplanetx.com/upload/tmap/marker/pin_b_m_a.png',size,offset);
		var label = new Tmap.Label('<div>'+document.inputForm.comment.value+'</div>');
		var marker = new Tmap.Markers(lonlat,icon,label);
		marker.events.register("mouseover", marker, onOverMarker);
		marker.events.register("mouseout", marker, onMarkerOut);
	}
	
	

	
</script>


<body>
	<form name = "inputForm">
	<div id="map_div"></div>
	<br/>
	위도 : <input type="text" name="lon"/><br/>
	경도 : <input type="text" name="lat"/><br/>
	코멘트 : <input type="text" name="comment"/><br/>
	<input type="button" value=" 마커추가 " onclick="addMarker()"/> 
	</form>
</body>
</html>