<?php

	$link = @mysqli_connect("127.0.0.1", "root", "") or die("nie udało się połączyć");
		
	@mysqli_select_db($link, "test") or die ("nie udało się wybrać bazy danych");
	//@mysqli_query("SET NAMES 'utf8'");


	$result2=mysqli_query($link, "SELECT id, name FROM data_name") or die ("nie udało się wybrać bazy danych");

	$data2 = array();
	while($row  = mysqli_fetch_assoc($result2))
	{
		$data2[]=$row;
	}

	echo json_encode($data2);


	mysqli_close($link);

?>