<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <title>Tworzenie pól!</title>
  </head>
  <body>
    <div class="container">
        <form action="script.php" method="post" id="myForm" enctype="multipart/form-data">
          <input type="text" class="form-control" placeholder="Nazwa danych" name="data_name"><br>
          <div id="fields"></div>
          <button type="button" class="btn btn-primary" id="btn_add_fields">Dodaj pola</button>
          <button type="button" class="btn btn-danger" id="btn_delete_fields">Usuń pola</button><br><br>
          <button type="button" id="button_send">Wyslij</button>
          <button type="button" id="button_show" name="button_show">Pokaż dane</button>
          <button type="button" id="button_show_table" name="button_show_table">Pokaż dane w tabeli</button>
          <!-- <input type="submit" name="submit" value="wyslij"> -->
          <div id="info"></div>
        </form><br>


        <div id="table"></div>


      <?php
        $link = @mysqli_connect("127.0.0.1", "root", "") or die("nie udało się połączyć");

        @mysqli_select_db($link, "test") or die ("nie udało się wybrać bazy danych");
        //@mysqli_query("SET NAMES 'utf8'");


        $result2=mysqli_query($link, "SELECT id, name FROM data_name") or die ("nie udało się wybrać bazy danych");

      ?>
    </div>
   <script src="js/script.js?v=<?php echo time() ?>" async></script>
  </body>
</html>