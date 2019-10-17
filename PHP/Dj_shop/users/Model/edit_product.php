<?php 

	require_once '../init.php';

	if (hasPerm ([2], $user->data()->id))
		{
			$db = DB::getInstance();

			$idProduct=$_POST['idProduct'];
			$name=FILTER_VAR($_POST['name'], FILTER_SANITIZE_STRING);
			$comment=FILTER_VAR($_POST['comment'], FILTER_SANITIZE_STRING);
			$price=$_POST['price'];
			$promotion=$_POST['promotion'];
			$promotion_price=$_POST['promotion_price'];
			$category_select=$_POST['category_select'];
			$image1=$_POST['image1'];
			$image2=$_POST['image2'];
			$image3=$_POST['image3'];
			

			if(empty($image1 && $image2 && $image3))
			{
				$query = $db->query("UPDATE products SET name='$name', description='$comment', price=$price, promotion=$promotion, price_after_discount=$promotion_price, id_categories=$category_select WHERE id=$idProduct");
				$result=$query->results();
				
			}
			else if(!empty($image1 && $image2 && $image3))
			{
				echo "wszystkie";
			}
			else if(empty($image2 && $image3))
			{
				echo "miniaturka";
				/*
				$file_tmp = $_FILES[$image1]['tmp_name'];
				$file_name = $_FILES[$image1]['name'];
				$file_size = $_FILES[$image1]['size'];

				echo $image1;	
				echo $file_name."<br>";
				echo $file_tmp."<br>";
				echo $file_size;

			
				if(is_uploaded_file($plik_tmp)) {
				     move_uploaded_file($plik_tmp, "upload/$plik_nazwa");
				    echo "Plik: <strong>$plik_nazwa</strong> o rozmiarze 
   					<strong>$plik_rozmiar bajtów</strong> został przesłany na serwer!";
   				*/
			}
			else if(empty($image1 && $image2))
			{
				echo "image3";
			}
			else if(empty($image1 && $image3))
			{
				echo "image2";
			}

			
		

		}else
			header('Location: ' . $_SERVER['HTTP_REFERER']);

		

	
?>