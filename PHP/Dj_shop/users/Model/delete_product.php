<?php 

	require_once '../init.php';

	if (hasPerm ([2], $user->data()->id))
	{
		$db = DB::getInstance();
		$idProduct=Input::get('id');
		$idFilter=is_numeric($idProduct);	
		if($idFilter==true)
		{
			$query = $db->query("SELECT * FROM products WHERE id=$idProduct");
			$result=$query->results();
		
			$path_image="../images/products/".$result[0]->image;
			$path_image2="../images/products/".$result[0]->image2;
			$path_image3="../images/products/".$result[0]->image3;

			if(file_exists($path_image))
				unlink($path_image);
			if(file_exists($path_image2))
				unlink($path_image2);
			if(file_exists($path_image3))
				unlink($path_image3);
			
			
			$query = $db->query("DELETE FROM products WHERE id=$idProduct");
			$result=$query->results();
			
			
			header('Location: ' . $_SERVER['HTTP_REFERER']);
		}
	}else
		header('Location: ' . $_SERVER['HTTP_REFERER']);

		

	
?>