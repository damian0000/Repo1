<?php
if(file_exists("install/index.php")){
	header("Location: install/index.php");
}
require_once 'users/init.php';
require_once $abs_us_root.$us_url_root.'users/includes/template/prep.php';
?>
<script type="text/javascript" src="users/Model/Functions/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="users/Model/Functions/jquery.validate.js"></script>

<div id="page-wrapper">
	<?php  
		require_once("users/header_jumbotron.php");
		require_once('users/Model/Functions/product_view.php');

		if (hasPerm ([2], $user->data()->id))
		{
			$db = DB::getInstance();
			$id=Input::get('id');
			$idFilter=is_numeric($id);	
			if($idFilter==false)
				header("location: index.php");
			else
			{
				$query = $db->query("SELECT id, name, description, id_categories, price, price_after_discount, promotion, image, image2, image3 FROM products WHERE id=$id");
				$product=$query->results();
				$query2 = $db->query("SELECT * FROM categories");
				$categories=$query2->results();
	?>
			<div class="container">
				<h1 class="text-center">Edycja produktu: <?php echo $product[0]->name; ?></h1><hr>
				<div class="col-lg-12 form ">
					<form method="post" id="formEdit" action="users/Model/edit_product.php">
						<div class="form-group one_form">
						  <label class="control-label col-sm-3">Nazwa:</label>
						  <div class="col-sm-9">          
							<input type="text" class="form-control" id="name_form" name="name" onfocusout="check_name()" value="<?php echo $product[0]->name; ?>" required><span class="form_text_span" id="name_error_message"></span><br>
						  </div>
						</div>
						<div class="form-group">
						  <label class="control-label col-sm-3" for="comment_form">Opis:</label>
						  <div class="col-sm-9">
							<textarea class="form-control" rows="5" id="comment_form" name="comment" required><?php echo $product[0]->description; ?></textarea><span class="form_text_span" id="comment_error_message"></span><br>
						  </div>
						</div>
						<div class="form-group ">
						  <label class="control-label col-sm-3">Cena</label>
						  <div class="col-sm-9">          
							<input type="number" id="price_form" data-decimals="2" min="0" max="1000000000" step="0.01" class="promo_form" name="price" value="<?php echo $product[0]->price; ?>" required/>zł<span class="form_text_span" id="price_error_message"></span><br><br>
						  </div>
						</div>
						<div class="form-group">
						  <label class="control-label col-sm-3" for="promotion_form">Promocja</label>
						  <div class="col-sm-9">
							<input type="number" min="0" max="1" step="1" name="promotion" id="promotion_form" value="<?php echo $product[0]->promotion; ?>" required/><span class="form_text_span" id="promotion_error_message"></span><br><br>
						  </div>
						</div>
						<div class="form-group">
						  <label class="control-label col-sm-3" for="promotion_price">Cena promocyjna</label>
						  <div class="col-sm-9">
							<input type="number" data-decimals="2" min="0" max="1000000000" step="0.01"  name="promotion_price" id="promotion_price_form" value="<?php 
								if($product[0]->price_after_discount==NULL)
									echo "0.00";
								else
									echo $product[0]->price_after_discount; ?>"/>zł<span class="form_text_span" id="promotion_price_error_message"></span><br><br>
						  </div>
						</div><br>
						<div class="form-group">
						  <label class="control-label col-sm-3" for="category">Kategoria</label>
						  <div class="col-sm-9">
							<div class="form-group">
							  <select class="form-control" id="sel1"  name="category_select">
							    <?php
									foreach ($categories as $category) 
									{
										if($category->id==$product[0]->id_categories)
											echo '<option selected value="' . $category->id .'">';
										else
											echo '<option value="' . $category->id .'">';
										echo $category->name;
										echo "</option>";		
									}
								?>
							  </select>
							</div>
						  </div><br>
						</div>
						<div class="form-group">
						  <label class="control-label col-sm-3" for="image1">Miniaturka</label>
						  <div class="col-sm-9">
							  <input type="file" name="image1" value="<?php echo $product[0]->image; ?>" /><br>
						  </div>
						</div><br>
						<div class="form-group">
						  <label class="control-label col-sm-3" for="image2">Zdjęcie 1</label>
						  <div class="col-sm-9">
							<input type="file" name="image2" value="<?php echo $product[0]->image2; ?>"/><br>
						  </div>
						</div><br>
						<div class="form-group">
						  <label class="control-label col-sm-3" for="image3" value="<?php echo $product[0]->image3; ?>">Zdjęcie 2</label>
						  <div class="col-sm-9">
							<input type="file" name="image3"/><br>
						  </div>
						</div><br>
						<div class="form-group">        
						  <div class="col-sm-offset-2 col-sm-10">
					    	<input type="hidden" name="idProduct" value="<?php echo $product[0]->id; ?>"/>
						    <button  type="submit" name="ok" id="button_form" class="btn btn-success" disabled >Zatwierdź zmiany</button>
						  </div>
						</div>	
					</form>
				</div>
			</div>
			<script type="text/javascript">
				/*
				$("#name_form").focusout(function()
					{
						check_name();
					}
				);
				*/
				function check_name()
				{
					var name_length=$("#name_form").val().length;

					if(name_length<4 || name_length>30)
					{
						$("#name_error_message").html("Wymagane 4-30 znaków");
						$("#name_error_message").show();
						document.getElementById('button_form').disabled = true;
					}else
					{
						$("#name_error_message").hide();
						document.getElementById('button_form').disabled = false;
					}
				}
			</script>
			<script type="text/javascript">
				$('#name_form').unbind('focusout');
				$("#price_form").focusout(function()
					{
						check_price();
					}
				);
				function check_price()
				{
					var price_value=$("#price_form").val(); 
					var regex=price_value.match(^\d{0,2}(\.\d{0,2}){0,1}$);
					if (!regex) 
					{
					    $("#price_error_message").html("Wymagane kwota np:80.00");
						$("#price_error_message").show();
						document.getElementById('button_form').disabled = true;
					}else
					{
						$("#price_error_message").hide();
						document.getElementById('button_form').disabled = false;
					}
				}
			</script>
	<?php 
			}

		} else
			header("location: index.php");
	?>
		
	
	
	
	
</div>


<!-- Place any per-page javascript here -->


<?php require_once $abs_us_root . $us_url_root . 'users/includes/html_footer.php'; ?>