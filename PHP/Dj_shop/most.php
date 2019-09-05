<?php
if(file_exists("install/index.php")){
	//perform redirect if installer files exist
	//this if{} block may be deleted once installed
	header("Location: install/index.php");
}
require_once 'users/init.php';
require_once $abs_us_root.$us_url_root.'users/includes/template/prep.php';
if(isset($user) && $user->isLoggedIn()){
}
?>


<div id="page-wrapper">
	<?php  
		require_once("users/header_jumbotron.php");
	?>
	<div class="container">
	<?php 
		require_once('users/Model/Functions/product_view.php');

		$db = DB::getInstance();
		$id=Input::get('id');
		$idFilter=is_numeric($id);	
		if($idFilter==true)
		{
			$query = $db->query("SELECT id, name, description, price, price_after_discount, promotion, image, image2, image3 FROM products WHERE id=$id");
			$result=$query->results();

			if(!$result)
			{
				header("location: index.php");
			}
			$promotion_product=$result[0]->promotion;

			if(isset($user) && $user->isLoggedIn())
			{
				$userID=$user->data()->id;  
					
				if($promotion_product==0)
					products_view_most_page_LoggedIn($result, $userID, $db);
				else
					products_view_most_page_promotion_LoggedIn($result, $userID, $db);
			}else
			{
				if($promotion_product==0)
					products_view_most_page($result);
				else
					products_view_most_page_promotion($result);
			}
		}
	?>
	</div>
	<div class="container">
		<div class="col-12">
			<h1 class="text-center">Opis</h1><hr>
			<p class="description_most"><?php echo $result[0]->description; ?> </p><br>
			<img src='../users/images/products/<?php echo $result[0]->image3; ?>' class='img-responsive center-block'/>;
		</div>
	</div>
</div>


<!-- Place any per-page javascript here -->


<?php require_once $abs_us_root . $us_url_root . 'users/includes/html_footer.php'; ?>