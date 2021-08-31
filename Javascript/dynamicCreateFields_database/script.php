<?php 

	$name = $_POST['name'];
	$name=json_decode($name);
	
	$function_name = $_POST['function_name'];
	$function_name=json_decode($function_name);
	
	$data = $_POST['data'];
	$data=json_decode($data);
	//echo $data;

	$link = @mysqli_connect("127.0.0.1", "root", "") or die("nie udało się połączyć");
	
	@mysqli_select_db($link, "test") or die ("nie udało się wybrać bazy danych");
	@mysqli_query("SET NAMES 'utf8'");

	$query="INSERT INTO data_name(name) VALUES ('".mysqli_real_escape_string($link, $data)."')";

	mysqli_query($link, $query)or die("nie udało się dodać rekordów");

	//$query="SELECT MAX(id) FROM data_name";
	$result=mysqli_query($link, "SELECT MAX(id) FROM data_name");

	$data_name_id=mysqli_fetch_row($result);
	//echo $data_name_id[0];

	foreach($name AS $key => $value)
	{
		$query="INSERT INTO fields(id_data_name, name, function) VALUES ('".$data_name_id[0]."','".mysqli_real_escape_string($link, $value)."','".mysqli_real_escape_string($link, $function_name[$key])."')";

		mysqli_query($link, $query)or die("nie udało się dodać rekordów");
	}

	
	mysqli_close($link);

?>