<?php 
//--------------------------------------------quest-user---------------------------------------------------
function products_view($result)
{
	foreach ($result->results() as $record)
		{
	?>
			<div class="col-12 col-md-4">
				<h3 class="title_product"><?php echo $record->name; ?></h3>
				<div class="thumbnails">
					<?php
						echo "<img src='../users/images/products/$record->image' class='img-responsive center-block'/>";
					?>
				</div>
				<p class="price_product">Cena: <?php echo $record->price; ?>zł</p>
				<div class="btn-group" id="button-group">
				    <a href="most.php?id=<?php echo $record->id; ?>"  class="btn btn-primary ">Szczegóły</a>
					<a  href="users/login.php?id=<?php echo $record->id; ?>" class="btn btn-danger btn-space ">Do koszyka</a>
				 </div>
			</div>
	<?php 
		}
}
function products_view_promotion($result)
{
	foreach ($result->results() as $record2)
		{
	?>
			<div class="col-12 col-md-4">
				<h3 class="title_product"><?php echo $record2->name; ?></h3>
				<div class="thumbnails">
					<?php
						echo "<img src='../users/images/products/$record2->image' class='img-responsive center-block'/>";
					?>
				</div>
				<p class="price_product">Cena: <s><?php echo $record2->price; ?></s>zł</p>
				<p class="price_product">Akktualna cena: <?php echo $record2->price_after_discount; ?>zł</p>
				<div class="btn-group" id="button-group">
				    <a href="most.php?id=<?php echo $record2->id; ?>"  class="btn btn-primary ">Szczegóły</a>
				    <a  href="users/login.php?id=<?php echo $record2->id; ?>" class="btn btn-danger btn-space ">Do koszyka</a>
				 </div>
			</div>
	<?php 
		}
} 
//------------------------------------------------user------------------------------------------------------------
function products_view_LoggedIn($result, $userID, $db)
{
	
	foreach ($result->results() as $record)
		{
			$tmpId=$record->id;				
			$query = $db->query("SELECT id_product  FROM basket  WHERE id_user=$userID AND id_product=$tmpId");
			$product_with_basket=$query->results();
	?>
			<div class="col-12 col-md-4">
				<h3 class="title_product"><?php echo $record->name; ?></h3>
				<div class="thumbnails">
					<?php
						echo "<img src='../users/images/products/$record->image' class='img-responsive center-block'/>";
					?>
				</div>
				<p class="price_product">Cena: <?php echo $record->price; ?>zł</p>
				<div class="btn-group" id="button-group">
				    <a href="most.php?id=<?php echo $record->id; ?>"  class="btn btn-primary ">Szczegóły</a>
				    <form method="post">
				<?php 
				    if($product_with_basket)
				    	echo '<a disabled name="basket" class="btn btn-danger btn-space ">Do koszyka</a>';
				    else
				    {
				?>
						<a  href="users/Model/add_product_basket.php?id=<?php echo $record->id; ?>" name="basket" class="btn btn-danger btn-space ">Do koszyka</a>
				<?php 
				    }
				?>

					</form>
				</div>
			</div>
	<?php 
		}
}
function products_view_promotion_LoggedIn($result, $userID, $db)
{
	foreach ($result->results() as $record2)
		{
			$tmpId=$record2->id;				
			$query = $db->query("SELECT id_product  FROM basket  WHERE id_user=$userID AND id_product=$tmpId");
			$product_with_basket=$query->results();
	?>
			<div class="col-12 col-md-4">
				<h3 class="title_product"><?php echo $record2->name; ?></h3>
				<div class="thumbnails">
					<?php
						echo "<img src='../users/images/products/$record2->image' class='img-responsive center-block'/>";
					?>
				</div>
				<p class="price_product">Cena: <s><?php echo $record2->price; ?></s>zł</p>
				<p class="price_product">Akktualna cena: <?php echo $record2->price_after_discount; ?>zł</p>
				<div class="btn-group" id="button-group">
				    <a href="most.php?id=<?php echo $record2->id; ?>"  class="btn btn-primary ">Szczegóły</a>
				    <form method="post">
				    <?php 
				    if($product_with_basket)
				    	echo '<a disabled name="basket" class="btn btn-danger btn-space ">Do koszyka</a>';
				    else
				    {
				    ?>	
				    	<a  href="users/Model/add_product_basket.php?id=<?php echo $record2->id; ?>" name="basket" class="btn btn-danger btn-space ">Do koszyka</a>
					<?php 
				    }
				    ?>
					</form>
				 </div>
			</div>
	<?php 
		}
}
//---------------------------------------------------------admin----------------------------------
function products_view_LoggedIn_admin($result, $userID, $db)
{
	foreach ($result->results() as $record)
		{
			$tmpId=$record->id;				
			$query = $db->query("SELECT id_product  FROM basket  WHERE id_user=$userID AND id_product=$tmpId");
			$product_with_basket=$query->results();
	?>
			<div class="col-12 col-md-4">
				<h3 class="title_product"><?php echo $record->name; ?></h3>
				<div class="thumbnails">
					<div class="thumbnails">
						<?php
							echo "<img src='../users/images/products/$record->image' class='img-responsive center-block'/>";
						?>
					</div>
				</div>
				<p class="price_product">Cena: <?php echo $record->price; ?>zł</p>
				<div class="btn-group" id="button-group">
				    <a href="most.php?id=<?php echo $record->id; ?>"  class="btn btn-primary ">Szczegóły</a>
				    <form method="post">
				<?php 
				    if($product_with_basket)
				    	echo '<a disabled name="basket" class="btn btn-danger btn-space ">Do koszyka</a>';
				    else
				    {
				?>
						<a  href="users/Model/add_product_basket.php?id=<?php echo $record->id; ?>" name="basket" class="btn btn-danger btn-space ">Do koszyka</a>
				<?php 
					}
				?>
					</form>
					<a href="edit.php?id=<?php echo $record->id; ?>"  class="btn btn-success ">Edytuj</a>
					<a href="users/Model/delete_product.php?id=<?php echo $record->id; ?>" type="button" class="btn btn-danger " onclick="return one_delete_product()">Usuń</a>
				</div>
			</div>
	<?php 
		}
}
function products_view_promotion_LoggedIn_admin($result, $userID, $db)
{
	foreach ($result->results() as $record2)
		{
			$tmpId=$record2->id;				
			$query = $db->query("SELECT id_product  FROM basket  WHERE id_user=$userID AND id_product=$tmpId");
			$product_with_basket=$query->results();
	?>
			<div class="col-12 col-md-4">
				<h3 class="title_product"><?php echo $record2->name; ?></h3>
				<div class="thumbnails">
					<?php
						echo "<img src='../users/images/products/$record2->image' class='img-responsive center-block'/>";
					?>
				</div>
				<p class="price_product">Cena: <s><?php echo $record2->price; ?></s>zł</p>
				<p class="price_product">Akktualna cena: <?php echo $record2->price_after_discount; ?>zł</p>
				<div class="btn-group" id="button-group">
				    <a href="most.php?id=<?php echo $record2->id; ?>"  class="btn btn-primary ">Szczegóły</a>
				    <form method="post">
				<?php 
				    if($product_with_basket)
				    	echo '<a disabled name="basket" class="btn btn-danger btn-space ">Do koszyka</a>';
				    else
				    {
				?>
						<a  href="users/Model/add_product_basket.php?id=<?php echo $record2->id; ?>" name="basket" class="btn btn-danger btn-space ">Do koszyka</a>
				<?php 
					}
				?>
						<a href="edit.php?id=<?php echo $record2->id; ?>"  class="btn btn-success ">Edytuj</a>
						<a href="users/Model/delete_product.php?id=<?php echo $record2->id; ?>"  class="btn btn-danger" onclick="return one_delete_product()">Usuń</a>
					</form>
				</div>
				<div class="btn-group" id="button-group">

				 </div>
			</div>
	<?php 
		}
}
//----------------------------------------------------------most---------------------------------------------------------
//
function products_view_most_page($result)
{
	?>
		<h1 class="text-center"><?php echo $result[0]->name; ?></h1><hr>
		<div class="col-12 col-md-6">
			<img src='../users/images/products/<?php echo $result[0]->image2; ?>' class='img-responsive center-block'/>;
		</div>
		<div class="col-12 col-md-6">
			<p class="title_price_product_most text-center">Cena</p>
			<p class="price_product_most text-center"><?php echo $result[0]->price; ?>zł</p><br>
			<a  href="user/login.php?id=<?php echo $result[0]->id; ?>" name="basket" class="btn btn-danger btn-lg btn-block">Do koszyka</a>
		</div>
	<?php 
}
function products_view_most_page_promotion($result)
{
	?>
		<h1 class="text-center"><?php echo $result[0]->name; ?></h1><hr>
		<div class="col-12 col-md-6">
			<img src='../users/images/products/<?php echo $result[0]->image2; ?>' class='img-responsive center-block'/>;
		</div>
		<div class="col-12 col-md-6">
			<p class="title_price_product_most text-center">Cena</p>
			<p class="price_product_most text-center"> <s><?php echo $result[0]->price; ?>zł</s></p><br>
			<p class="price_product_most text-center"> <?php echo $result[0]->price_after_discount; ?>zł</p><br>
			<a  href="user/login.php?id=<?php echo $result[0]->id; ?>" class="btn btn-danger btn-lg btn-block">Do koszyka</a>
		</div>
	<?php
}
//---------------------------------------------------------most - user---------------------------------------------
function products_view_most_page_LoggedIn($result, $userID, $db)
{
	?>
		<h1 class="text-center"><?php echo $result[0]->name; ?></h1><hr>
		<div class="col-12 col-md-6">
			<img src='../users/images/products/<?php echo $result[0]->image2; ?>' class='img-responsive center-block'/>;
		</div>
		<div class="col-12 col-md-6">
			<p class="title_price_product_most text-center">Cena</p>
			<p class="price_product_most text-center"><?php echo $result[0]->price; ?>zł</p><br>
			<?php 
				$tmpId=$result[0]->id;				
				$query = $db->query("SELECT id_product  FROM basket  WHERE id_user=$userID AND id_product=$tmpId");
				$product_with_basket=$query->results();
				if($product_with_basket)
					echo '<button disabled name="basket" class="btn btn-danger btn-lg btn-block">Do koszyka</button>';
				else
				{ 
					?><a  href="users/Model/add_product_basket.php?id=<?php echo $result[0]->id; ?>" name="basket" class="btn btn-danger btn-lg btn-block">Do koszyka</a><?php 
				}
			?>
			
		</div>
	<?php 
		
}

function products_view_most_page_promotion_LoggedIn($result, $userID, $db)
{
	?>
		<h1 class="text-center"><?php echo $result[0]->name; ?></h1><hr>
		<div class="col-12 col-md-6">
			<img src='../users/images/products/<?php echo $result[0]->image2; ?>' class='img-responsive center-block'/>;
		</div>
		<div class="col-12 col-md-6">
			<p class="title_price_product_most text-center">Cena</p>
			<p class="price_product_most text-center"> <s><?php echo $result[0]->price; ?>zł</s></p><br>
			<p class="price_product_most text-center"> <?php echo $result[0]->price_after_discount; ?>zł</p><br>
			<?php 
				$tmpId=$result[0]->id;				
				$query = $db->query("SELECT id_product  FROM basket  WHERE id_user=$userID AND id_product=$tmpId");
				$product_with_basket=$query->results();
				if($product_with_basket)
					echo '<button disabled name="basket" class="btn btn-danger btn-lg btn-block">Do koszyka</button>';
				else
				{ 
					?><a  href="users/Model/add_product_basket.php?id=<?php echo $result[0]->id; ?>" name="basket" class="btn btn-danger btn-lg btn-block">Do koszyka</a><?php 
				}
			?>
		</div>
	<?php 
		
}


?>