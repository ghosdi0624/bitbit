<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
<script language="javascript"
	src="https://apis.skplanetx.com/tmap/js?version=1&format=javascript&appKey=bac4f916-3297-3be4-93ff-e37ae88b8f42"></script>
<script type="text/javascript">
var map, lonlat, zoom;
var markers = new Tmap.Layer.Markers( "MarkerLayer" );
	function init() {
	
	map = new Tmap.Map({div:'map_div', width:'500px', height:'500px'});
	
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
	 map.events.register("click", map, onClickMap);


} 

window.onload = function(){
init();
}

function routeSearch(x, y){ 

	   markers.clearMarkers(); 

	   var routeFormat = new Tmap.Format.KML({extractStyles:true, extractAttributes:true}); 

	   var urlStr = "https://apis.skplanetx.com/tmap/routes?version=1"; 

	   urlStr += "&startX="+x; 

	   urlStr += "&startY="+y; 

	   urlStr += "&endX="+$('#endX').val(); 

	   urlStr += "&endY="+$('#endY').val(); 

	   urlStr += "&searchOption="+$('#searchOption').val(); 

	   urlStr += "&appKey=bac4f916-3297-3be4-93ff-e37ae88b8f42"; 

	    var prtcl = new Tmap.Protocol.HTTP({ 

	        url: urlStr+"&format=xml", 

	        format:routeFormat 

	    }); 
	    
	    function onClickMap(e) {

			lonlat = map.getLonLatFromViewPortPx(e.xy);
			
			lonlat = new Tmap.LonLat(lonlat.lon, lonlat.lat);
			zoom = 14;
		
			
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
</script>
<body>

</body>
</html>