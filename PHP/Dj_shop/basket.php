<?php
if(file_exists("install/index.php")){
	//perform redirect if installer files exist
	//this if{} block may be deleted once installed
	header("Location: install/index.php");
}

require_once 'users/init.php';
require_once $abs_us_root.$us_url_root.'users/includes/template/prep.php';
if(isset($user) && $user->isLoggedIn())
{

?>
	<div id="page-wrapper">
		<?php  
			require_once("users/header_jumbotron.php");
		?>
		<div class="container">
			<h1 class="text-center">Produkty dodane do koszyka</h1><hr>
			
			<?php
				$userID=$user->data()->id; 
				require_once('users/Model/Functions/product_view.php');
				$db = DB::getInstance();
		
				$result = $db->query("SELECT b.id, b.id_user, b.id_product, b.quantity, b.price, (b.quantity*b.price) AS main_price, p.id, p.name, p.image FROM basket b INNER JOIN products p ON b.id_product=p.id WHERE b.id_user=$userID ORDER BY b.id DESC");

				if($result->results())
				{
					foreach ($result->results() as $record)
					{
				?>
						<div class="col-lg-12 product_basket">
							<div class="col-lg-6 ">
								<?php
									echo "<img src='../users/images/products/$record->image' class='img-responsive center-block'/>";
								?>
							</div>
							<div class="col-lg-6">
								<h3 class="title_product_basket"><?php echo $record->name; ?></h3>	
							    <a href="most.php?id=<?php echo $record->id ; ?>"  class="btn btn-primary ">Szczegóły</a><br><br>
							    <form method="post" action="users/Model/update_product_basket.php">
							    	<input type="hidden" name="idProduct" value="<?php echo $record->id; ?>"/>
							    	<input type="number" name="quantit" min="1" max="10" value="<?php echo $record->quantity ;?>" /> 
							    	<button type="submit" name="update" class="btn btn-success ">Aktualizuj</button>
							    	<p class="price_product_basket">Cena: <?php echo $record->main_price; ?>zł</p>
							    </form>
							    <form method="post" name="delete_product" action="users/Model/delete_product_basket.php">
							    	<input type="hidden" name="idProduct" value="<?php echo $record->id; ?>"/>
								    <input type="submit" name="delete" class="btn btn-danger" onclick="return one_delete_product()" value="Usuń" />
								</form>
							</div>
						</div>
				<?php 
					}

					$quantity = $db->query("SELECT quantity FROM basket WHERE id_user=$userID")->results();
					$price=$db->query("SELECT (quantity*price) AS total_price FROM basket WHERE id_user=$userID")->results();

					foreach($quantity as $sum)
						$quantity_sum=$quantity_sum+$sum->quantity;

					foreach($price as $sum)
						$price_sum=$price_sum+$sum->total_price;

					$price_sum_format=number_format($price_sum, 2, ',', ' ');
				?>
					<br><br>
					<table class="total_basket">
						<thead>
						<tr>
							<th>RAZEM</th>
							<th><?php echo $quantity_sum; ?> sztuk</th>
							<th><?php echo $price_sum_format;?>zł</th>
						</tr>
						</thead>
					
					</table><br><br>
				<?php 
				}
			?>
		</div>
	</div>
<?php 
}
else
	header("location: index.php");
?>
<!-- Place any per-page javascript here -->

<?php require_once $abs_us_root . $us_url_root . 'users/includes/html_footer.php'; ?>


<script src="users/Model/Functions/js_function.js" async></script>
