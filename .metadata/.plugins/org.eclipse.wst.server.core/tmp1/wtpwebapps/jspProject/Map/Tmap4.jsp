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
	width: 500px;
	height: 500px;
	float: left;
	font-size: 10pt;
}
</style>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
<script language="javascript"
	src="https://apis.skplanetx.com/tmap/js?version=1&format=javascript&appKey=8119ac79-8052-3455-96b6-0595b08be4d7"></script>
<script type="text/javascript">
	var startX, startY, endX, endY;
	var map, lonlat, zoom;
	var routeLayer;

	var f = 0;
	function flag() {
		f = !f;
	}
	
	var markers = new Tmap.Layer.Markers( "MarkerLayer" );
	
	function initTmap() {
		centerLL = new Tmap.LonLat(14145677.4, 4511257.6);
		map = new Tmap.Map({
			div : 'map_div',
			width : '500px',
			height : '500px',
			transitionEffect : "resize",
			animation : true
		});
		map.addLayer(markers);
	}; 
	//경로 정보 로드
	function searchRoute() {
		if(routeLayer != null){
			map.removeLayer(routeLayer);
		}
		markers.destroy();
		var routeFormat = new Tmap.Format.KML({
			extractStyles : true,
			extractAttributes : true
		});

		var urlStr = "https://apis.skplanetx.com/tmap/routes?version=1&format=xml";
		urlStr += "&startX=" + startX;
		urlStr += "&startY=" + startY;
		urlStr += "&endX=" + endX;
		urlStr += "&endY=" + endY;
		urlStr += "&appKey=bac4f916-3297-3be4-93ff-e37ae88b8f42";
		var prtcl = new Tmap.Protocol.HTTP({
			url : urlStr,
			format : routeFormat
		});
		routeLayer = new Tmap.Layer.Vector("route", {
			protocol : prtcl,
			strategies : [ new Tmap.Strategy.Fixed() ]
		});
		routeLayer.events.register("featuresadded", routeLayer, onDrawnFeatures);
		console.log(routeLayer);
		f=0;
		map.addLayer(routeLayer);
	}

	//경로 그리기 후 해당영역으로 줌
	function onDrawnFeatures(e) {
		$('#addinfo').children().remove();
		map.zoomToExtent(this.getDataExtent());
		for(var i=0; i<routeLayer.features.length; i++){
			$('#addinfo').append('<div>'+(i+1)+'. '+routeLayer.features[i].attributes.description+'<br/></div>');
		}
	}

	window.onload = function() {
		initTmap();
	}

	function dragStart(event) {
		event.dataTransfer.effectAllowed = 'move';
		event.dataTransfer.setData("Text", event.target.getAttribute('id'));
	}

	function dragEnter(event) {
		var idelt = event.dataTransfer.getData("Text");
		return true;
	}

	function dragOver(event) {
		var idelt = event.dataTransfer.getData("Text");
		var id = event.target.getAttribute('id');
		if (id == 'div_map' && idelt == drag) {
			return true;
		}
		return false;
	}

	function dragDrop(event) {
		return true;
	}

	function startDragEnd(event) {
		f = 1;
		if (f==1) {
			map.events.register("mouseover", map, onClickMap);
			event.dataTransfer.clearData("Text");
		}
		return true;
	}
	
	function EndDragEnd(event){
		f = 2;
		if (f==2) {
			map.events.register("mouseover", map, onClickMap1);
			event.dataTransfer.clearData("Text");
		}
		return true;
	}

	function onClickMap(e) {
		
		if (f!=1) {
			return;
		}
		lonlat = map.getLonLatFromViewPortPx(e.xy);
		lonlat = new Tmap.LonLat(lonlat.lon, lonlat.lat);
		startX = lonlat.lon;
		startY = lonlat.lat;
		if(startX != null && startY != null && endX != null && endY != null){
			searchRoute();
		}
		zoom = 14;

		var size = new Tmap.Size(24,38);
		var offset = new Tmap.Pixel(-(size.w/2), -size.h);
		var icon = new Tmap.Icon('https://developers.skplanetx.com/upload/tmap/marker/pin_b_m_a.png',size,offset);
		var marker = new Tmap.Markers(lonlat,icon);
		if (f==1) {
			markers.addMarker(marker);
			f = 0;
		}	
	}
	function onClickMap1(e) {
		
		if (f!=2) {
			return;
		}
		lonlat = map.getLonLatFromViewPortPx(e.xy);
		lonlat = new Tmap.LonLat(lonlat.lon, lonlat.lat);
		endX = lonlat.lon;
		endY = lonlat.lat;
		if(startX != null && startY != null && endX != null && endY != null){
			searchRoute();
		}
		zoom = 14;

		var size = new Tmap.Size(24,38);
		var offset = new Tmap.Pixel(-(size.w/2), -size.h);
		var icon = new Tmap.Icon('https://developers.skplanetx.com/upload/tmap/marker/pin_b_m_a.png',size,offset);
		var marker = new Tmap.Markers(lonlat,icon);
		if (f==2) {
			markers.addMarker(marker);
			f = 0;
		}	
	}
</script>
<body>
<form name="inputForm">
	<div id="map_div" style="float: left"
		ondragenter="return dragEnter(event)" 
		ondrop="return dragDrop(event)"
		ondragover="return dragOver(event)"></div>
	<div id="rightside">
		&nbsp;
		<h3>길찾기</h3>
		<div id="dragStart" draggable="true" 
			ondragstart="return dragStart(event)"
			ondragend="return startDragEnd(event)">
			<img src="https://developers.skplanetx.com/upload/tmap/marker/pin_b_m_a.png" />출발
		</div>
		<div id="dragEnd" draggable="true" 
			ondragstart="return dragStart(event)"
			ondragend="return EndDragEnd(event)">
			<img src="https://developers.skplanetx.com/upload/tmap/marker/pin_b_m_a.png" />도착
		<br/>--------------------------------------------
		<div id="addinfo"></div>
		</div>
	</div>
</form>
</body>
</html>