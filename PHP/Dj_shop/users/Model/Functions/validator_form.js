$(function() 
	{
		$("#name_error_message").hide();
		$("#comment_error_message").hide();
		$("#price_error_message").hide();
		$("#promotion_error_message").hide();
		$("#promotion_price_error_message").hide();

		var error_neme=false;
		var error_comment=false;
		var error_price=false;
		var error_promotion=false;
		var error_promotion_price=false;

		$("#name_form").focusout(function()
			{
				check_name();
			}
		);
		$("#price_form").focusout(function()
			{
				check_price();
			}
		);
		$("#promotion_form").focusout(function()
			{
				check_promotion();
			}
		);
		$("#promotion_price_form").focusout(function()
			{
				check_promotion_price();
			}
		)
		function check_name()
		{
			var name_length=$("#name_form").val().length;

			if(name_length<4 || name_length>30)
			{
				$("#name_error_message").html("Wymagane 4-8 znaków");
				$("#name_error_message").show();
				error_neme=true;
				document.getElementById('button_form').disabled = true;
			}else
			{
				$("#name_error_message").hide();
				document.getElementById('button_form').disabled = false;
			}
		}
		function check_price()
		{
			var price_value=$("#price_form").val(); 
			var regex=price_value.match(^\d{0,2}(\.\d{0,2}){0,1}$);
			if (!regex) 
			{
			    $("#price_error_message").html("Wymagane kwota np:80.00");
				$("#price_error_message").show();
				error_price=true;
				document.getElementById('button_form').disabled = true;
			}else
			{
				$("#price_error_message").hide();
				document.getElementById('button_form').disabled = false;
			}
		}
		function check_promotion()
		{
			var promotion_value=$("#promotion_form").val(); 
			if (promotion_value!=0 || promotion_value!=1) 
			{
			    $("#promotion_error_message").html("Wymagane 0 lub 1");
				$("#promotion_error_message").show();
				error_promotion=true;
				document.getElementById('button_form').disabled = true;
			}else
			{
				$("#promotion_error_message").hide();
				document.getElementById('button_form').disabled = false;
			}
		}
		function check_promotion_price()
		{
			var promotion_price_value=$("#promotion_price_form").val();
			var regex=promotion_price_value.match(^\d{0,2}(\.\d{0,2}){0,1}$);
			if (!regex) 
			{
			    $("#promotion_price_error_message").html("Wymagane kwota np:80.00");
				$("#promotion_price_error_message").show();
				error_promotion_price=true;
				document.getElementById('button_form').disabled = true;
			}else
			{
				$("#promotion_price_error_message").hide();
				document.getElementById('button_form').disabled = false;
			}
		}
	}

)
