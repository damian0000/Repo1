<?php

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
		<h1 class="text-center">Głośniki</h1><hr>
		<?php 
			require_once('users/Model/Functions/product_view.php');
			$db = DB::getInstance();
			$userID=$user->data()->id;  
			if (hasPerm ([2], $user->data()->id))
			{
				$result = $db->query("SELECT id, name, price, image FROM products WHERE promotion=0 AND id_categories=3 ORDER BY id DESC");
				if($result->results())
					products_view_LoggedIn_admin($result, $userID, $db);
			}
			else if(isset($user) && $user->isLoggedIn())
			{
				$result = $db->query("SELECT id, name, price, image FROM products WHERE promotion=0 AND id_categories=3 ORDER BY id DESC");
				if($result->results())
					products_view_LoggedIn($result, $userID, $db);
			}
			else
			{
				$result = $db->query("SELECT id, name, price, image FROM products WHERE promotion=0 AND id_categories=3 ORDER BY id DESC");
				if($result->results())
					products_view($result);
			}	
		?>
	</div>
	<div class="container">
		<?php 
			if (hasPerm ([2], $user->data()->id))
			{
				$result = $db->query("SELECT id, name, price, image, price_after_discount FROM products WHERE promotion=1 AND id_categories=3 ORDER BY id DESC ");
				if($result->results())
				{
					echo '<h1 class="text-center">Promocje</h1><hr>';
					products_view_promotion_LoggedIn_admin($result, $userID, $db);
				}
			}
			else if(isset($user) && $user->isLoggedIn())
			{
				$result = $db->query("SELECT id, name, price, image, price_after_discount FROM products WHERE promotion=1 AND id_categories=3 ORDER BY id DESC ");
				if($result->results())
				{
					echo '<h1 class="text-center">Promocje</h1><hr>';
					products_view_promotion_LoggedIn($result, $userID, $db);
				}
			}
			else
			{
				$result = $db->query("SELECT id, name, price, image, price_after_discount FROM products WHERE promotion=1 AND id_categories=3 ORDER BY id DESC");
				if($result->results())
				{
					echo '<h1 class="text-center">Promocje</h1><hr>';
					products_view_promotion($result);
				}
			}

		?><br><br>
	</div>
	


</div>

<!-- Place any per-page javascript here -->

<?php require_once $abs_us_root . $us_url_root . 'users/includes/html_footer.php'; ?>

