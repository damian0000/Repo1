<?php 

	require_once '../init.php';

	if (hasPerm ([2], $user->data()->id))
	{
		$db = DB::getInstance();
		$idProduct=Input::get('id');
		$idFilter=is_numeric($idProduct);	
		if($idFilter==true)
		{
			$query = $db->query("SELECT image, FROM products WHERE id=$idProduct");
			$result=$query->results();


			/*
			$query = $db->query("DELETE * FROM products WHERE id=$idProduct");
			$result=$query->results();0
			*/

		}
	}else
		header('Location: ' . $_SERVER['HTTP_REFERER']);

		

	
?>