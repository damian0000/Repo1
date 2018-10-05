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
        <title>Strona główna</title>

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

            <div class="background_image img-responsive center-block">     
                <div class="col-lg-12">
                    <div class="col-lg-5">

                    </div>
                </div>
            </div>
            
            <div class="col-lg-12 col_main_page">
                <div class="col-lg-9 col_main_page">
                    <h1 class="title_main_page">Proponowane oferty</h1>
                   
                   <?php
                        $mysqlConnect=@mysql_connect("localhost", "root", "") or die(mysql_error());
                        mysql_select_db("nieruchomosci") or die(mysql_error());
                        mysql_set_charset("utf8");
                        $questions="SELECT * FROM nieruchomosci ORDER BY ID DESC LIMIT 6";

                        $data=mysql_query($questions) or die(MYSQL_ERROR);
                        $row_table="SELECT COUNT(*) FROM nieruchomosci";
                    
                        if(mysql_num_rows($data)>0)
                        {
                        
                            echo '
                                <div class="col-lg-12 col_main_page">';
                                    for($iterator=0; $iterator<3; $iterator++)
                                    {
                                        while($row=mysql_fetch_array($data))
                                        {
                                        echo '<div class="col-lg-4">
                                                <div class="offers_main_page">';
                                                echo '<h4 class="title_offers">'.$row['Tytuł'].'</h4>';
                                            echo '<img src="data:image/jpeg;base64,'.base64_encode( $row['Zdjęcie'] ).'" alt="mieszkanie" class="center-block img-responsive offers_image" width="220px" height="109px"/>
                                                <div class="subtitle_main_page_offers">';
                                                echo '<p class="first_part_par"><b>Lokalizacja: </b></p><p class="two_part_par">'.$row["Miasto"].'</p>';
                                                echo '<p class="first_part_par"><b>Powierzchnia całkowita [m2]: </b></p><p class="two_part_par">'.$row["Pow_całk"].'</p>';
                                                echo '<p class="first_part_par"><b>Ilość pokoi: </b></p><p class="two_part_par">'.$row["Ilość_pokoi"].'</p>';
                                                echo '<p class="price">Cena: '.$row["Cena"].' zł</p>
                                                </div>             
                                            </div>
                                        </div>';
                                        }
                                    }
                                echo '
                                </div>';
                            }
                        
                    ?>
                   
                    
                    <div class="col-lg-12 col_main_page">
                        <h1 class="title_main_page">U nas znajdziesz</h1>
                        <div class="col-lg-6">
                            <img src="img/dom.jpg" alt="domy" class="center-block img-responsive gif_jpg" width="300px" height="214px"/>
                            <h3 class="title_gif_jpg">Domy</h3>        
                        </div>
                        <div class="col-lg-6">
                            <img src="img/dom2.jpg" alt="lokale" class="center-block img-responsive gif_jpg" width="300px" height="214px"/>
                            <h3 class="title_gif_jpg">Lokale</h3>        
                        </div>
                    </div>
                    <div class="col-lg-12 col_main_page">
                        <div class="col-lg-6">
                            <img src="img/dom3.jpg" alt="pokoje" class="center-block img-responsive gif_jpg" width="300px" height="214px"/>
                            <h3 class="title_gif_jpg">Pokoje</h3>        
                        </div>
                        <div class="col-lg-6">
                            <img src="img/mieszkanie.jpg" alt="mieszkania" class="center-block img-responsive gif_jpg" width="300px" height="214px"/>
                            <h3 class="title_gif_jpg">Mieszkania</h3>        
                        </div>
                    </div>   
                </div>    
               
               <!-- formularz-->        
                <div class="col-lg-3 col_main_page2">
                    <div class="sidebar">
                        <div class="title_background">
                            <h2 class="sidebar_title">Wyszukaj</h2>
                        </div>
                        <form action="oferty.php" method="POST">
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
                                <?php
                                if(isset($_POST["reseach"]))
                                {
                                    header("Location: oferty.php"); 
                                    show_data();

                                }
                                ?>
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