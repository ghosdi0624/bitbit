<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="javascript"
	src="https://apis.skplanetx.com/tmap/js?version=1&format=javascript&appKey=bac4f916-3297-3be4-93ff-e37ae88b8f42"></script>
<script type="text/javascript">
	function initialize() {
		var map = new Tmap.Map({
			div : "map_div",
			width : '500px',
			height : '500px'
		});
		//  map.addControl(new Tmap.Control.KeyboardDefaults());		// 키보드 조작
		map.addControl(new Tmap.Control.MousePosition()); // 좌표 표시
		//  map.addControl(new Tmap.Control. OverviewMap());			// 미니맵

		var markers = new Tmap.Layer.Markers("MarkerLayer");
		map.addLayer(markers);

		var size = new Tmap.Size(24, 38);
		var offset = new Tmap.Pixel(-(size.w / 2), -size.h);
		var icon = new Tmap.Icon(
				'https://developers.skplanetx.com/upload/tmap/marker/pin_b_m_a.png',
				size, offset);

		var marker = new Tmap.Marker(new Tmap.LonLat(14134074.680985,
				4517814.0870894), icon);
		markers.addMarker(marker);

	}

	function onClickMap(evt) {
		alert("x : " + evt.clientX + "\n" + "y : " + evt.clientY);
	}

	window.onload = function() {
		initialize();
	}
</script>
</head>
<body>
	<div id="map_div"></div>
</body>
</html>