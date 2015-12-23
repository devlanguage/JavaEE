// <script type="text/javascript">
function ajaxFunction() {
	var xmlHttp;
	try {
		// Firefox, Opera 8.0+, Safari
		xmlHttp = new XMLHttpRequest();
	} catch (e) {
		// Internet Explorer 6.0+
		try {
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			// Internet Explorer 5.5+
			try {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				alert("Browser Can't support AJAX");
				return false;
			}
		}// IE
	}// FireFox, Oper8.0+
}
// </script>
