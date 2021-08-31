<?php

	$link = @mysqli_connect("127.0.0.1", "root", "") or die("nie udało się połączyć");

	@mysqli_select_db($link, "test") or die ("nie udało się wybrać bazy danych");
	//@mysqli_query("SET NAMES 'utf8'");

	$result=mysqli_query($link, "SELECT id, name, function FROM fields") or die ("nie udało się wybrać bazy danych");

	$data_all=array();
	$data = array();
	while($row  = mysqli_fetch_assoc($result))
	{
		$data[]=$row;
	}

	echo json_encode($data);

	/*$result2=mysqli_query($link, "SELECT id, name FROM data_name") or die ("nie udało się wybrać bazy danych");

	$data2 = array();
	while($row  = mysqli_fetch_assoc($result2))
	{
		$data2[]=$row;
	}

	echo json_encode($data2);

*/
	//mysqli_close($link);

	/*$mysqli = new mysqli("127.0.0.1","root","","test");

	if ($mysqli -> connect_errno) {
	  echo "Failed to connect to MySQL: " . $mysqli -> connect_error;
	  exit();
	}

	$sql = "SELECT id, name, function FROM fields;";
	$sql .= "SELECT id, name FROM data_name";

	$data = array();
	$data2 = array();
	// Execute multi query
	if ($mysqli -> multi_query($sql))
	{
	  do {
	    // Store first result set
	    if ($result = $mysqli -> store_result())
	    {
	    	if(empty($data))
	    	{
				while ($row = $result -> fetch_assoc())
				{
					$data[]=$row;
				}
	    	}else
	    	{
	    		while ($row = $result -> fetch_assoc())
				{
					$data2[]=$row;
				}
	    	}
	     $result -> free_result();
	    }
	    // if there are more result-sets, the print a divider
	   /* if ($mysqli -> more_results())
	    {
	      printf("-------------\n");
	    }
	     //Prepare next result set
	  } while ($mysqli -> next_result());
	}
	echo json_encode($data);
	echo json_encode($data2);
	*/
	$mysqli -> close();
?>