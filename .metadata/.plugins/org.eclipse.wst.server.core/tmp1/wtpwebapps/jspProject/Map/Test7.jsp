<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script language="javascript"
	src="https://apis.skplanetx.com/tmap/js?version=1&format=javascript&appKey=bac4f916-3297-3be4-93ff-e37ae88b8f42"></script>
<script type="text/javascript">
	//초기화 함수
	function initTmap() {
		centerLL = new Tmap.LonLat(14145677.4, 4511257.6);
		map = new Tmap.Map({
			div : 'map_div',
			width : '100%',
			height : '400px',
			transitionEffect : "resize",
			animation : true
		});
		searchRoute();
	}
	//경로 정보 로드
	function searchRoute() {

		var form = document.inputForm;
		var routeFormat = new Tmap.Format.KML({
			extractStyles : true,
			extractAttributes : true
		});
		var startX = form.startlon.value;
		var startY = form.startlat.value;
		var endX = form.endlon.value;
		var endY = form.endlat.value;
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
		var routeLayer = new Tmap.Layer.Vector("route", {
			protocol : prtcl,
			strategies : [ new Tmap.Strategy.Fixed() ]
		});
		routeLayer.events
				.register("featuresadded", routeLayer, onDrawnFeatures);
		map.addLayer(routeLayer);
	}
	//경로 그리기 후 해당영역으로 줌
	function onDrawnFeatures(e) {
		map.zoomToExtent(this.getDataExtent());
	}
	
	document.onload = function(){
		initTmap();
	}
</script>
<body>
	<form name="inputForm">
		<div id="map_div"></div>
		출발지<br /> 위도 : <input type="text" name="startlon" /><br /> 경도 : <input
			type="text" name="startlat" /><br /> <br /> 도착지<br /> 위도 : <input
			type="text" name="endlon" /><br /> 경도 : <input type="text"
			name="endlat" /><br /> <input type="button" value=" 경로보기"
			onclick="script:initTmap()" />
	</form>
</body>
</html>