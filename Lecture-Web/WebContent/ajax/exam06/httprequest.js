// ajax 관련 메소드

var httpRequest = null;

function getXMLHttpRequest() {
	if(window.XMLHttpRequest)
		return new XMLHttpRequest();
	else if(window.ActiveXObject)
		return new ActiveXObject("Microsoft.XMLHTTP");
	else 
		return null;
}

function sendRequest(method, url, params, callback) {
	
	httpRequest = getXMLHttpRequest();
	
	httpRequest.onreadystatechange = callback;
	
	var httpMethod = method;
	if(method != 'GET' && method != 'POST') {
		httpMethod = 'GET';
	}

	var httpParams = "";
	if(params != null && params != "") {
		for(var key in params) {
			if(httpParams != "")
				httpParams += '&';
			httpParams += key + "=" + encodeURIComponent(params[key]);
		}
	}
	
	var httpUrl = url;
	if(httpMethod == "GET" && httpParams != "") {
		httpUrl = httpUrl + '?' + httpParams;
	}
	
	httpRequest.open(httpMethod, httpUrl, true);
	
	if(httpMethod == 'POST') {
		httpRequest.setRequestHeader('Content-type', 
							'application/x-www-form-urlencoded');
	}
	
	httpRequest.send(httpMethod == "GET" ? null : httpParams);
}
