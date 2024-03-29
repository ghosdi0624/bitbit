<!DOCTYPE html>
<html lang="en">
<head>
<meta charset=utf-8>
<meta name="viewport" content="width=620">
<title>HTML5 Demo: File API (simple)</title>
<link rel="stylesheet" href="css/html5demos.css">
<script src="js/h5utils.js"></script>
</head>
<body>
	<section id="wrapper">
		<div id="carbonads-container">
			<div class="carbonad">
				<div id="azcarbon"></div>
				<script type="text/javascript">
					var z = document.createElement("script");
					z.type = "text/javascript";
					z.async = true;
					z.src = "http://engine.carbonads.com/z/14060/azcarbon_2_1_0_VERT";
					var s = document.getElementsByTagName("script")[0];
					s.parentNode.insertBefore(z, s);
				</script>
			</div>
		</div>
		<header>
			<h1>File API (simple)</h1>
		</header>

		<article>
			<p id="status">File API & FileReader API not supported</p>
			<p>
				<input type=file>
			</p>
			<p>Select an image from your machine to read the contents of the
				file without using a server</p>
			<div id="holder"></div>
		</article>
		<script>
			var upload = document.getElementsByTagName('input')[0], 
				holder = document.getElementById('holder'), 
				state = document.getElementById('status');

			if (typeof window.FileReader === 'undefined') {
				state.className = 'fail';
			} else {
				state.className = 'success';
				state.innerHTML = 'File API & FileReader available';
			}

			upload.onchange = function(e) {
				e.preventDefault();

				var file = upload.files[0], reader = new FileReader();
				reader.onload = function(event) {
					var img = new Image();
					img.src = event.target.result;
					// note: no onload required since we've got the dataurl...I think! :)
					if (img.width > 560) { // holder width
						img.width = 560;
					}
					holder.innerHTML = '';
					holder.appendChild(img);
				};
				reader.readAsDataURL(file);

				return false;
			};
		</script>
		<a id="html5badge" href="http://www.w3.org/html/logo/"> <img
			src="http://www.w3.org/html/logo/badge/html5-badge-h-connectivity-device-graphics-multimedia-performance-semantics-storage.png"
			width="325" height="64"
			alt="HTML5 Powered with Connectivity / Realtime, Device Access, Graphics, 3D & Effects, Multimedia, Performance & Integration, Semantics, and Offline & Storage"
			title="HTML5 Powered with Connectivity / Realtime, Device Access, Graphics, 3D & Effects, Multimedia, Performance & Integration, Semantics, and Offline & Storage">
		</a>
		<footer>
			<a href="/">HTML5 demos</a>/<a id="built"
				href="http://twitter.com/rem">@rem built this</a>/<a
				href="#view-source">view source</a>
		</footer>
	</section>
	<a href="http://github.com/remy/html5demos"><img
		style="position: absolute; top: 0; left: 0; border: 0;"
		src="http://s3.amazonaws.com/github/ribbons/forkme_left_darkblue_121621.png"
		alt="Fork me on GitHub" /></a>
	<script src="js/prettify.packed.js"></script>
	<script>
		var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl."
				: "http://www.");
		document
				.write(unescape("%3Cscript src='"
						+ gaJsHost
						+ "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
	</script>
	<script>
		try {
			var pageTracker = _gat._getTracker("UA-1656750-18");
			pageTracker._trackPageview();
		} catch (err) {
		}
	</script>
</body>
</html>