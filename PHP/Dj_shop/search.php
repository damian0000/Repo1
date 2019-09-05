<?php
if(file_exists("install/index.php")){
	//perform redirect if installer files exist
	//this if{} block may be deleted once installed
	header("Location: install/index.php");
}

require_once 'users/init.php';
require_once $abs_us_root.$us_url_root.'users/includes/template/prep.php';


?>
<div id="page-wrapper">
	<?php  
		require_once("users/header_jumbotron.php");
	?>
		
	
	<div class="container">
		<?php 
			require_once('users/Model/Functions/product_view.php');
			$db = DB::getInstance();
			$userID=$user->data()->id;  
			$item=$_POST['search_field'];

			$result = $db->query("SELECT id, name, price, image FROM products WHERE name LIKE '%$item%' AND promotion=0 ORDER BY id DESC");	

			if(!$item=="")
			{
				if($result->results())
				{
					echo '<h1 class="text-center">Znaleziono</h1><hr>';
					if (hasPerm ([2], $user->data()->id))
					{
						$result = $db->query("SELECT id, name, price, image FROM products WHERE name LIKE '%$item%' AND promotion=0 ORDER BY id DESC");	
						products_view_LoggedIn_admin($result, $userID, $db);
					}
					else if(isset($user) && $user->isLoggedIn())
					{
						$result = $db->query("SELECT id, name, price, image FROM products WHERE name LIKE '%$item%' AND promotion=0 ORDER BY id DESC");	
						products_view_LoggedIn($result, $userID, $db);
					}
					else
						products_view($result);
				?>
					</div>
					<div class="container">
					<?php
						$result2 = $db->query("SELECT id, name, price, image, price_after_discount FROM products WHERE name LIKE '%$item%' AND promotion=1 ORDER BY id DESC");
						if($result2->results())
						{
							echo '<h1 class="text-center">Promocje</h1><hr>';
							if (hasPerm ([2], $user->data()->id))
							{
								$result2 = $db->query("SELECT id, name, price, image, price_after_discount FROM products WHERE name LIKE '%$item%' AND promotion=1 ORDER BY id DESC");
								products_view_promotion_LoggedIn_admin($result2, $userID, $db);
							}
							else if(isset($user) && $user->isLoggedIn())
							{
								$result2 = $db->query("SELECT id, name, price, image, price_after_discount FROM products WHERE name LIKE '%$item%' AND promotion=1 ORDER BY id DESC");
								products_view_promotion_LoggedIn($result2, $userID, $db);
							}
							else
								products_view_promotion($result2);
						}
					?>
					</div><br><br>
				<?php
				}else
				{
					$result2 = $db->query("SELECT id, name, price, image, price_after_discount FROM products WHERE name LIKE '%$item%' AND promotion=1 ORDER BY id DESC");
					if($result2->results())
					{
						echo '<h1 class="text-center">Promocje</h1><hr>';
						if (hasPerm ([2], $user->data()->id))
						{
							$result2 = $db->query("SELECT id, name, price, image, price_after_discount FROM products WHERE name LIKE '%$item%' AND promotion=1 ORDER BY id DESC");
							products_view_promotion_LoggedIn_admin($result2, $userID, $db);
						}
						else if(isset($user) && $user->isLoggedIn())
							products_view_promotion_LoggedIn($result2, $userID, $db);
						else
							products_view_promotion($result2);
					}else 
						echo '<h3 class="text-center">Nie ma takiego produktu</h3>';
				}
			}else 
				echo '<h3 class="text-center">Nie podano żadnego produktu</h3>';			
		?>

	</div>
	
</div>


<!-- Place any per-page javascript here -->


<?php require_once $abs_us_root . $us_url_root . 'users/includes/html_footer.php'; ?>