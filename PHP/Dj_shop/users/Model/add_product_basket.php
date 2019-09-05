<?php 
	require_once '../init.php';

 
	$db = DB::getInstance();
	$idProduct=Input::get('id');
	$idFilter=is_numeric($idProduct);	
	if($idFilter==true)
	{
		$query = $db->query("SELECT id, price, price_after_discount, promotion FROM products WHERE id=$idProduct");
		$result=$query->results();

		if(!$result)
		{
			header("location: index.php");
		}
		$userID=$user->data()->id;
		$priceProduct= $result[0]->price;

		$price_after_discountProduct=$result[0]->price_after_discount;
		$promotion_product=$result[0]->promotion;
		
		if($promotion_product==0)
			$query = $db->query("INSERT INTO basket (id_user, id_product, quantity, price) VALUES ($userID, $idProduct, 1, $priceProduct)");
		else
			$query = $db->query("INSERT INTO basket (id_user, id_product, quantity, price) VALUES ($userID, $idProduct, 1, $price_after_discountProduct)");
		

		$result=$query->results();

		header('Location: ' . $_SERVER['HTTP_REFERER']);



	}else
		header('Location: ' . $_SERVER['HTTP_REFERER']);
