<?php 

require_once '../init.php';

	$db = DB::getInstance();
	$idProduct=$_POST['idProduct'];

	$idFilter=is_numeric($idProduct);	

	if($idFilter==true)
	{
		$userID=$user->data()->id;

		$query = $db->query("DELETE FROM basket WHERE (id_user=$userID AND id_product=$idProduct)");
		$result=$query->results();

		header('Location: ' . $_SERVER['HTTP_REFERER']);
	}else
		header('Location: ' . $_SERVER['HTTP_REFERER']);
