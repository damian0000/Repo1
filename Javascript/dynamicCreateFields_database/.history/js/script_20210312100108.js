"use strict"

function add_fields(number)
{
	var new_input = document.createElement("input");
	new_input.setAttribute('class', 'form-control');
	new_input.setAttribute('name', 'name[]');
	new_input.setAttribute('id', 'in'+number);
	new_input.setAttribute('placeholder', 'Imię i nazwisko');

	var new_input2 = document.createElement("input");
	new_input2.setAttribute('class', 'form-control');
	new_input2.setAttribute('name', 'function[]');
	new_input2.setAttribute('id', 'in'+number);
	new_input2.setAttribute('placeholder', 'Funkcja');

	var fields=document.getElementById("fields");
	fields.appendChild(new_input);
	fields.appendChild(new_input2);

}
function delete_fields(number)
{
	var fields_elements=document.querySelectorAll('#fields > input#in'+number);
	fields_elements.forEach((el) => {el.remove();});

}

window.onload = ajaxInit;
function ajaxInit()
{
	var XHR = null;
	try
	{
		XHR = new XMLHttpRequest();
	}
	catch(e)
	{
		try
		{
			XHR = new ActiveXObject("Msxml2.XMLHTTP");
		}
		catch(e2)
		{
			try
			{
				XHR = new ActiveXObject("Microsoft.XMLHTTP");
			}
			catch(e3)
			{
				alert("Niestety Twoja przeglądarka nie obsługuje AJAXA");
			}
		}
	}
	return XHR;
}


var number=0;
var n=0;

var btn_add_fields=document.getElementById("btn_add_fields");
btn_add_fields.addEventListener("click", function()
{
	add_fields(number);
	n=number;
	number++;
});

var btn_delete_fields=document.getElementById("btn_delete_fields");
btn_delete_fields.addEventListener("click", function()
{
	delete_fields(n);
	n--;
	number--;
});

var button_send=document.getElementById("button_send");
button_send.addEventListener("click", function()
{
	var name=Array.from(document.querySelectorAll('#fields > input[name="name[]"]'), el => el.value);
	var function_name=Array.from(document.querySelectorAll('#fields > input[name="function[]"]'), el => el.value);
	var data_name=document.querySelector('input[name="data_name"]').value;

	console.log(data_name);

	const xhr=new XMLHttpRequest();

	xhr.onreadystatechange = function()
	{
	    if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
	        document.querySelector('#info').innerHTML=this.responseText;
	    }
	}

	xhr.open('POST', 'script.php', true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(encodeURI('data='+JSON.stringify(data_name)+'&name='+JSON.stringify(name)+'&function_name='+JSON.stringify(function_name)));
});

var button_show=document.getElementById("button_show");
button_show.addEventListener("click", function()
{
	var ajax = new XMLHttpRequest();
	var method = "GET";
	var url ="data.php";

	ajax.open(method, url, true);
	ajax.send();

	ajax.onreadystatechange =function()
	{
		if (this.readyState == 4  && this.status == 200)
		{
			n=0;
			number=0;

			var data = JSON.parse(this.responseText);
			var fields=document.getElementById("fields").innerHTML="";

			for(var i=0; i<data.length; i++)
			{
				var name=data[i].name;
				var funct=data[i].function;

				var new_input = document.createElement("input");
				new_input.setAttribute('class', 'form-control');
				new_input.setAttribute('name', 'name[]');
				new_input.setAttribute('id', 'in'+n);
				new_input.setAttribute('placeholder', 'Imię i nazwisko');
				new_input.setAttribute('value', name);

				var new_input2 = document.createElement("input");
				new_input2.setAttribute('class', 'form-control');
				new_input2.setAttribute('name', 'function[]');
				new_input2.setAttribute('id', 'in'+n);
				new_input2.setAttribute('placeholder', 'Funkcja');
				new_input2.setAttribute('value', funct);
				n++;
				number++;

				var fields=document.getElementById("fields");
				fields.appendChild(new_input);
				fields.appendChild(new_input2);
			}
		}
	}
});

var button_show_table=document.getElementById("button_show_table");
button_show_table.addEventListener("click", function()
{
	var ajax = new XMLHttpRequest();
	var method = "GET";
	var url ="data.php";

	ajax.open(method, url, true);
	ajax.send();

	ajax.onreadystatechange =function()
	{
		if (this.readyState == 4  && this.status == 200)
		{
			//alert(this.responseText);

			var data2 = JSON.parse(this.responseText);
			document.getElementById("table").innerHTML="";

			var html='<table class="table"><tbody>';
			for(var i=0; i<data2.length; i++)
			{
				var name=data2[i].name;

				html+='<tr><td style="width:40%;">'+name+'</td><td><button type="button" class="btn btn-success disabled" id="">Otwórz</button></td><td><button type="button" class="btn btn-danger disabled" id="">Usuń</button></td></tr>';

			}
			html+='</tbody></table>';
			document.getElementById("table").innerHTML=html;
		}
	}

});
