<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
#searchResult{
	border : 1px solid red;
	width : 70%;
	height : 800px;
	font-size : 10pt;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src = "http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$(':button').click(function(){
			$.ajax({
				url : "https://apis.daum.net/search/blog",
				type : "GET",
				data : {
					apikey : "046ac75236bb37b591a0184249baa017",
					q : $('#searchWord').val(),
					result : '6',
					output : "json"
				},
				dataType : 'jsonp',
				success : callback
			});
		});
	});
	
	function callback(jsonData){
		$('#searchResult').text("");
		var itemList = jsonData.channel.item;
		
		for(var i=0; i<itemList.length; i++){
			var title = itemList[i].title;
			var link = itemList[i].link;
			var description = itemList[i].description;
			var pubDate = itemList[i].pubDate;
			
			$('#searchResult').append("<br/>");
			$('#searchResult').append('<a href = "' + link + '" target ="_blank">'+title+'</a>');
			$('#searchResult').append("  "+pubDate);
			$('#searchResult').append("<br/>");
			$('#searchResult').append(description+"<br/><hr>");
		}
	}
</script>
</head>
<body>
	<h2>다음 블로그 검색페이지</h2>
	검색어 입력 : <input type = "text" name = "searchWord" id = "searchWord" size = "20" />
	<input type = "button" value = " 검색 "/>
	<br/><br/>
	
	<div id = "searchResult"></div>
</body>
</html>