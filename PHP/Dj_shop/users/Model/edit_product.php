<?php 

	require_once '../init.php';

	if (hasPerm ([2], $user->data()->id))
		{
			$db = DB::getInstance();
			$idProduct=$_POST['idProduct'];
			echo $idProduct;

		}else
			header('Location: ' . $_SERVER['HTTP_REFERER']);

		

	
?>