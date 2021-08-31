<?php

	function correctValue($value)
	{
		if(is_numeric($value))
			return $value;
		else
			return null;
	}

	$link = @mysqli_connect("127.0.0.1", "root", "") or die("nie udało się połączyć");
		
	@mysqli_select_db($link, "test") or die ("nie udało się wybrać bazy danych");
	//@mysqli_query("SET NAMES 'utf8'");

	$powierzchniamin=correctValue($_GET["powierzchniamin"]);
	$powierzchniamax=correctValue($_GET["powierzchniamax"]);
	$ludnoscmin=correctValue($_GET["ludnoscmin"]);
	$ludnoscmax=correctValue($_GET["ludnoscmax"]);
	
	$query="SELECT nazwa, powierzchnia, ludnosc FROM wojewodztwa";

	if($powierzchniamin != null || $powierzchniamax != null || $ludnoscmin != null || $ludnoscmax != null)
		$query.=" WHERE id > 0";

	if($powierzchniamin != null)
		$query.=" AND powierzchnia >= ".$powierzchniamin;
	if($powierzchniamax != null)
		$query.=" AND powierzchnia <= ".$powierzchniamax;
	if($ludnoscmin != null)
		$query.=" AND ludnosc >= ".$ludnoscmin;
	if($ludnoscmax != null)
		$query.=" AND ludnosc <= ".$ludnoscmax;
	

	$result=mysqli_query($link, $query) or die ("nie udało się wybrać bazy danych");





	echo '<table id="table_wojewodztwa">';

	echo '
	<tr>
		<th>Województwo</th>
		<th>Pow.: (km2)</th>
		<th>Ludność</th>
	</tr>
	';
	while($row=$result->fetch_array(MYSQLI_ASSOC))
	{
		echo '<tr>';
		foreach($row as $key => $value)
		{
			if($key == "nazwa")
				echo '<td class="record">'.$value.'</td>';
			else if($key == "powierzchnia")
				echo '<td class="record">'.$value.'</td>';
			else if($key == "ludnosc")
				echo '<td>'.$value.'</td>';
		}
		echo '</tr>';
	}

	echo '</table>';
	mysqli_close($link);







?>