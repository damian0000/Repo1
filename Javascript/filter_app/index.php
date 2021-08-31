<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>AJAX</title>
		<script type="text/javascript" src="js/ajax.js"></script>
		<link rel="stylesheet" href="css/style.css" type="text/css">
	</head>
	<body >
		<form id="formWojewodztwo" onsubmit="return false;" onkeyup="showHint()">
			<fieldset id="filtrWojewodztw">
				<legend>Filtr</legend>
				Powierzchnia min:
				<input type="text" class="filtry" id="powierzchniamin">
				Powierzchnia max:
				<input type="text" class="filtry" id="powierzchniamax">
				Ludność min:
				<input type="text" class="filtry" id="ludnoscmin">
				Ludność max:
				<input type="text" class="filtry" id="ludnoscmax">
				
				
			</fieldset>
		</form>
		<div id="tekst"></div>
	</body>
</html>