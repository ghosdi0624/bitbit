<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
	};
	//경로 정보 로드
	function searchRoute() {
		var routeFormat = new Tmap.Format.KML({
			extractStyles : true,
			extractAttributes : true
		});
		var startX = 14129105.461214;
		var startY = 4517042.1926406;
		var endX = 14136027.789587;
		var endY = 4517572.4745242;
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
</script>
</head>

<body onload="initTmap()">

	<div id="map_div"></div>
</body>
</html>