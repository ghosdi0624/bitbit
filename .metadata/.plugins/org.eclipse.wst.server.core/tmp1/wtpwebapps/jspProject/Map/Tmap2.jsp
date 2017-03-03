<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
<script language="javascript"
	src="https://apis.skplanetx.com/tmap/js?version=1&format=javascript&appKey=bac4f916-3297-3be4-93ff-e37ae88b8f42"></script>
<script type="text/javascript">
	var map;
	
	window.onload = function(){
		initialize();
	}
	function initialize() {
		map = new Tmap.Map({
			div : 'map_div',
			width : '500px',
			height : '500px'
		}); 
		var lonlat = new Tmap.LonLat(126.9863748550415, 37.560806287625354);
		
		var pr_3857 = new Tmap.Projection("EPSG:3857"); 
		var pr_4326 = new Tmap.Projection("EPSG:4326"); 
		 
		lonlat.transform(pr_4326, pr_3857);
		
		map.setCenter(lonlat, 15);
		var c_ll = map.getCenter();
		loadGetAddressFromLonLat(c_ll);
	}
	
	function loadGetAddressFromLonLat(ll){
	    var tdata = new Tmap.TData();
	    tdata.events.register("onComplete", tdata, onCompleteLoadGetAddressFromLonLat);
	    var optionObj = {version:1};
	    tdata.getAddressFromLonLat(ll, optionObj);
	}

	function onCompleteLoadGetAddressFromLonLat(){
	    console.log($(this.responseXML).find("fullAddress").text());
	}


</script>
<body>
	<div id="map_div"></div>
</body>
</html>