<?php
include("form.php");
?>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Oferty</title>

        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
    </head>
    <body>
        <div class="container">
            <!-- Static navbar -->
            <nav class="navbar navbar-default">
                <a class="navbar-brand" href="index.php"><img src="img/logo%20tmp.png" class="img-responsive" width="50px" height="50px"/></a>
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div id="navbar" class="navbar-collapse navbar-right">
                    <ul class="nav navbar-nav center-block">
                        <li><a href="index.php">Strona główna</a></li>
                        <li><a href="oferty.php">Oferty</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </nav>

            <!--
<div class="background_image img-responsive center-block">     
<div class="col-lg-12">
<div class="col-lg-5">

</div>
</div>
</div>-->
            <img src="img/oferty.jpg" alt="oferty" class="center-block img-responsive" width="1140px" height="450px"/>

            <div class="col-lg-12 col_main_page">
                <div class="col-lg-9 col_main_page">
                    <div class="col-lg-12 col_main_page">
                        <h1 class="title_main_page">Oferty</h1>
                        <?php
                        
                        if(isset($_POST["reseach"]))
                        {
                           
                            show_data();
          
                        }
                        else
                        {
                            $mysqlConnect=@mysql_connect("localhost", "root", "") or die(mysql_error());
                            mysql_select_db("nieruchomosci") or die(mysql_error());
                            mysql_set_charset("utf8");
                            $questions="SELECT * FROM nieruchomosci ORDER BY ID DESC";

                            $data=mysql_query($questions) or die(MYSQL_ERROR);
                            
                            if(mysql_num_rows($data)>0)
                            {
                                while($row=mysql_fetch_array($data))
                                {

                                    echo '
                                        <div class="col-lg-12 col_offers_page col_main_page">
                                            <div class="col-lg-12 ">
                                                <div class="offers_offers_page">
                                                    <div class="col-lg-3 col_main_page">';
                                                        echo '<h4 class="title_offers_page text-center">'.$row["Tytuł"].'</h4>';
                                                        echo '<img src="data:image/jpeg;base64,'.base64_encode( $row['Zdjęcie'] ).'" alt="mieszkanie" class="img-responsive offers_image center-block" width="255px" height="249px"/>
                                                    </div>
                                                    <div class="col-lg-4">
                                                        <div class="subtitle_offers_page">';
                                                        echo '<p class="paragraph_sub_title"><b>Lokalizacja: </b> '.$row["Miasto"].'</p>';
                                                        echo '<p class="paragraph_sub_title"><b>Powierzchnia całkowita [m2]: </b>'.$row["Pow_całk"].'</p>';
                                                        echo '<p class="paragraph_sub_title"><b>Ilość pokoi: </b>'.$row["Ilość_pokoi"].'</p>';
                                                        echo '<p class="paragraph_sub_title"><b>Piętro: </b>'.$row["Piętro"].'</p>
                                                        </div>
                                                    </div>
                                                    <div class="col-lg-5">
                                                        <h4 class="title_offers_page">Opis</h4>';
                                                       echo '<p class="paragraph_destrip">'.$row["Opis"].'</p>
                                                    </div>
                                                </div>
                                            </div>';
                                            echo '<p class="price">Cena: '.$row["Cena"].'zł</p>
                                        </div>
                                   ';

                                }
                            }
                            mysql_close($mysqlConnect);
                        }
                            ?>
                    </div>
                </div>
                   
                    
        
     
                <!-- formularz-->        
                <div class="col-lg-3 col_main_page2">
                    <div class="sidebar">
                        <div class="title_background">
                            <h2 class="sidebar_title">Wyszukaj</h2>
                        </div>
                        <form action="oferty.php" method="post">
                            <div class="form-group row">
                                <label for="example-text-input" class="col-2 col-form-label ">Typ oferty</label>
                                <div class="col-5">
                                    <select class="form-control" id="sel1" name="type_offer">
                                        <?php
                                        type_of_offer();
                                        ?>
                                    </select>
                                </div>
                                <label for="example-text-input" class="col-2 col-form-label">Rodzaj</label>
                                <div class="col-5">
                                    <select class="form-control" id="sel1" name="kind_offer">
                                        <?php
                                        kind_of_offer();
                                        ?>
                                    </select>
                                </div>
                                <label for="example-text-input" class="col-2 col-form-label">Miasto</label>
                                <div class="col-5">
                                    <select class="form-control" id="sel1" name="location">
                                        <?php
                                        location_of_offer();
                                        ?>
                                    </select>
                                </div><br>
                                <button type="submit" class="btn btn-primary btn-block btn-search" value="ok" name="reseach">Szukaj</button>
                            </div>
                        </form>
                    </div>
                </div>    
                
                
                
            </div>
        </div>

        <div class="container">
            <!-- Footer -->
            <footer >
                <!-- Footer Links -->
                <div class="container-fluid text-md-left">
                    <!-- Grid row -->
                    <div class="row">
                        <!-- Grid column -->
                        <div class="col-md-4 mt-md-0 mt-3">
                            <!-- Content -->
                            <h4 class="text-center">Kontakt</h4>
                            <p>Imię i nazwisko</p>
                            <p>Adres</p>
                            <p>Tel:</p>
                            <p>Email:</p>
                        </div>
                        <!-- Grid column -->
                        <div class="col-md-3 mb-md-0 mb-3">
                            <!-- Links -->
                            <h4>Mapa</h4>

                        </div>
                        <!-- Grid column -->
                    </div>
                    <!-- Grid row -->
                </div>
                <!-- Footer Links -->
            </footer>
            <!-- Footer -->       
        </div>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>