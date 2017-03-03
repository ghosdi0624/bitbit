<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
#rightside {
	position: static;
	border: 1px solid;
	width: 300px;
	height: 800px;
	float: left;
}
</style>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
<script language="javascript"
	src="https://apis.skplanetx.com/tmap/js?version=1&format=javascript&appKey=8119ac79-8052-3455-96b6-0595b08be4d7"></script>
<script type="text/javascript">

	var map, lonlat, zoom;
	var firstLonLat, secondLonLat;
	
	f = false;
	function flag() {
		f = !f;
	}
	
	//벡터레이어 생성
	var vector_layer = new Tmap.Layer.Vector('Tmap Vector Layer');
	//마커레이어 생성
	var markers = new Tmap.Layer.Markers( "MarkerLayer" );
		
		// 초기 맵설정
		function init() {
		
			 map = new Tmap.Map({div:'map_div', width:'800px', height:'800px'});
			
			 lonlat = new Tmap.LonLat(126.9863748550415, 37.560806287625354);
			
			 var pr_3857 = new Tmap.Projection("EPSG:3857"); //EPSG3857 좌표계 객체
			 var pr_4326 = new Tmap.Projection("EPSG:4326"); //EPSG4326 좌표계 객체
			 
			 lonlat.transform(pr_4326, pr_3857);
			 zoom = 14;
			 
			 map.setCenter(lonlat, zoom);          
			
			 map.addLayer(markers);
			  
			 var size = new Tmap.Size(24,38);
			 var offset = new Tmap.Pixel(-(size.w/2), -size.h);
			 var icon = new Tmap.Icon('https://developers.skplanetx.com/upload/tmap/marker/pin_b_m_a.png',size,offset);
			 var label = new Tmap.Label('<div>최초 시작지점</div>');
			 var marker = new Tmap.Markers(lonlat,icon,label);
			/*  map.events.register("mouseup", map, onClickMap); */
	 }  
		
	window.onload = function(){
		init();
	}
	  
/* 	// 마커 추가
 	function addMarker(lonlat){

			map.addLayer(markers);
			var size = new Tmap.Size(24,38);
			var offset = new Tmap.Pixel(-(size.w/2), -size.h);
			var icon = new Tmap.Icon('https://developers.skplanetx.com/upload/tmap/marker/pin_b_m_a.png',size,offset);
//			var iconHtml = new Tmap.IconHtml('<div style="border:red solid 1px; background-color:#FF91DC;">1</div>',size,offset);
			var label = new Tmap.Label('<div>'+document.inputForm.comment.value+'</div>');
			var marker = new Tmap.Markers(lonlat,icon,label);
			
			markers.addMarker(marker);
 			
			// 레이어 다시 위로 올리기
			map.removeLayer(markers);
			map.addLayers([vector_layer]);
			map.addLayers([markers]);
	}  */

	function onOverMarker(evt) {
		this.popup.show();
	}

	function onMarkerOut(evt) {
		this.popup.hide();
	}

	// 지도 클릭해서 마커 추가
	function onClickMap(e) {

		if(!f){
			return;
		}
		lonlat = map.getLonLatFromViewPortPx(e.xy);
		lonlat = new Tmap.LonLat(lonlat.lon, lonlat.lat);
		zoom = 14;
		
		loadGetAddressFromLonLat(lonlat);

/* 		var size = new Tmap.Size(24,38);
		var offset = new Tmap.Pixel(-(size.w/2), -size.h);
		var icon = new Tmap.Icon('https://developers.skplanetx.com/upload/tmap/marker/pin_b_m_a.png',size,offset);
		var label = new Tmap.Label("<div>"+addr+"</div>");
		var marker = new Tmap.Markers(lonlat,icon,label);
		marker.events.register("mouseover", marker, onOverMarker);
		marker.events.register("mouseout", marker, onMarkerOut);
		marker.events.register("click", marker, removeMarker);
		 
		if (f) {
			markers.addMarker(marker);
			lineDrawing(lonlat);
			f = !f;
		}	
		// 레이어 다시 위로 올리기
		map.removeLayer(markers);
		map.addLayers([vector_layer]);
		map.addLayers([markers]); */
	}
	
	// 선 숨기기
	function removeLine(){
		map.removeLayer(vector_layer);
	}
	//선 보이기
	function drawLine(){
		if(markers != null)
			map.removeLayer(markers);
		map.addLayers([vector_layer]);
		map.addLayers([markers]);
	}
	//선택 마커 삭제
	function removeMarker(){
		
		var markerNum;
		for(var i=0; i<markers.markers.length; i++){
			if(markers.markers[i] == this){
				markerNum = i;
			}
		}

		$('#addinfo').children().eq(markerNum).remove();
		
		markers.removeMarker(markers.markers[markerNum]);
		
		vector_layer.removeAllFeatures();
 		
		if(markerNum == 0 && markers.markers.length == 0) {
 			secondLonLat = null;
 		}
		
 		if(markerNum >= markers.markers.length){
 			secondLonLat = markers.markers[markerNum-1].lonlat;
 		} 
		
 		
 		reLine();

	}

	// 마커 추가할때 선 긋기
	function lineDrawing(lonlat) {
		
	 	map.addLayers([ vector_layer ]);
	 	map.addLayers([ markers ]);

		firstLonLat = lonlat;
 
		//polyline 좌표 배열.
		var pointList = [];

		if(secondLonLat != null)
			pointList.push(new Tmap.Geometry.Point(secondLonLat.lon, secondLonLat.lat));
		pointList.push(new Tmap.Geometry.Point(firstLonLat.lon, firstLonLat.lat));
 
		//좌표 배열 객체화
		var lineString = new Tmap.Geometry.LineString(pointList);

		//polyline(Collection) 객체 정의
		var lineCollection = new Tmap.Geometry.Collection(lineString);

		//vector feature 객체화
		var style_bold = {strokeWidth: 5};
		var mLineFeature = new Tmap.Feature.Vector(lineCollection, null, style_bold);

		//벡터 레이어에 등록
		vector_layer.addFeatures([ mLineFeature ]);	
		
		secondLonLat = firstLonLat;
	} 
	
	// 삭제된 마커 제외 후 선긋기
	function reLine(){
		
		map.addLayers([ vector_layer ]);
	 	map.addLayers([ markers ]);
	 	
	 	var pointList = [];

	 	for(var i=0; i<markers.markers.length; i++){
	 		var markerLonLat = markers.markers[i].lonlat;
	 		pointList.push(new Tmap.Geometry.Point(markerLonLat.lon, markerLonLat.lat));
	 	}
	 	

		var lineString = new Tmap.Geometry.LineString(pointList);

		var lineCollection = new Tmap.Geometry.Collection(lineString);

		var style_bold = {strokeWidth: 5};
		var mLineFeature = new Tmap.Feature.Vector(lineCollection, null, style_bold);

		vector_layer.addFeatures([ mLineFeature ]);	
		
	}
	
	function loadGetAddressFromLonLat(ll){
	    var tdata = new Tmap.TData();
	    tdata.events.register("onComplete", tdata, onCompleteLoadGetAddressFromLonLat);
	    var optionObj = {version:1};
	    tdata.getAddressFromLonLat(ll, optionObj);
	}

	var number;
	// 마커에 맞는 주소 레이블에 등록
	function onCompleteLoadGetAddressFromLonLat(){
	    
		var info;
		
		var addr = $(this.responseXML).find("fullAddress").text();
	    
		var size = new Tmap.Size(24,38);
		var offset = new Tmap.Pixel(-(size.w/2), -size.h);
		var icon = new Tmap.Icon('https://developers.skplanetx.com/upload/tmap/marker/pin_b_m_a.png',size,offset);
		var label = new Tmap.Label("<div>"+addr+"</div>");
		var marker = new Tmap.Markers(lonlat,icon,label);
		marker.events.register("mouseover", marker, onOverMarker);
		marker.events.register("mouseout", marker, onMarkerOut);
		marker.events.register("click", marker, removeMarker);
		
		if (f) {
			markers.addMarker(marker);
			lineDrawing(lonlat);
			$('#addinfo').append('<div>'+addr+'<br/>--------------------------------------------</div>');
			
			f = !f;
		}	
		// 레이어 다시 위로 올리기
		map.removeLayer(markers);
		map.addLayers([vector_layer]);
		map.addLayers([markers]);
	}
	
	function dragStart(event){
		event.dataTransfer.effectAllowed='move';
		event.dataTransfer.setData("Text", event.target.getAttribute('id'));
	}
	
	function dragEnter(event) {
		var idelt = event.dataTransfer.getData("Text");
	    return true;
	}
	
	function dragOver(event) {
	    var idelt = event.dataTransfer.getData("Text");
	    var id = event.target.getAttribute('id');
	    if(id == 'div_map' && idelt == drag){
	    	return true;
	    }
		return false;
	}
	
	function dragDrop(event) {
		return true;
		
	}
	
	function dragEnd(event){
		f=!f;
		if(f){
			map.events.register("mouseover", map, onClickMap);
			event.dataTransfer.clearData("Text");
		}
		return true;
	}
</script>

<body>
	<form name="inputForm">
		<div id="map_div" style="float: left"
			ondragenter="return dragEnter(event)" ondrop="return dragDrop(event)"
			ondragover="return dragOver(event)"></div>

		<!-- 	<input type="button" onclick="flag()" value = "marker"></input> -->
		<div id="rightside">
			&nbsp;
			<h3>Timeline</h3>
			-------------------------------------------- &nbsp;
			<div id="drag" draggable="true" ondragstart="return dragStart(event)"
				ondragend="return dragEnd(event)">
				<img
					src="https://developers.skplanetx.com/upload/tmap/marker/pin_b_m_a.png" />마커표시
			</div>
			--------------------------------------------
			<div id="addinfo"></div>
			<div>
				<input type="button" value=" 선 숨기기 " onclick="removeLine()" />
				&nbsp; <input type="button" value=" 선 보이기 " onclick="drawLine()" />
			</div>
		</div>
	</form>
</body>
</html>