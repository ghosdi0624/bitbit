<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" href="/maps/documentation/javascript/demos/demos.css">
  </head>
  <script src = "js/jquery-3.1.1.min.js"></script>
<style type="text/css">
html, body {
	width: 80%;
	height: 80%;
	margin: 0;
	padding: 0;
}

#map {
	height: 100%;
}
#map1 {
	height: 100%;
}
</style>
    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAF05JCFoefu9jROxjM8TcHc8GIR6YDhuU&callback=initMap">
    </script>
    <script type="text/javascript">
   $(document).ready(function(){
	   $('#btn01').click(function(){
		   
		    var map;
		    function initMap() {
		      map = new google.maps.Map(document.getElementById('map'), {
		        center: {lat: -34.397, lng: 150.644},
		        zoom: 8
		      });
		    }
		    
	   });
   });
    </script>
<body>
    <div id="map"></div>
    <input type="button" id="btn01" value=" 변경 "/>
  </body>
</html>