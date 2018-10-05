<?php


    function type_of_offer()
    {
        $mysqlConnect=@mysql_connect("localhost", "root", "") or die(mysql_error());
        mysql_select_db("nieruchomosci") or die(mysql_error());
        mysql_set_charset("utf8");
        $questions="SELECT DISTINCT Typ_oferty FROM nieruchomosci";
        
        $data=mysql_query($questions) or die(MYSQL_ERROR);
        
        
        if(mysql_num_rows($data)>0)
        {
            echo "<option>**Wszystkie</option>";
            for($i=0; $i<mysql_num_rows($data); $i++)
            {
                $rows=mysql_fetch_assoc($data);
                foreach($rows as $key )
                { 
                    echo '<option value='.$key.'>'.$key.'</option>'; 
                }
            }
        }
       mysql_close($mysqlConnect);      
    
    }

    function kind_of_offer()
    {
        $mysqlConnect=@mysql_connect("localhost", "root", "") or die(mysql_error());
        mysql_select_db("nieruchomosci") or die(mysql_error());
        mysql_set_charset("utf8");
        $questions="SELECT DISTINCT Rodzaj_oferty FROM nieruchomosci";
        $data=mysql_query($questions) or die(MYSQL_ERROR);
        if(mysql_num_rows($data)>0)
        {
            echo "<option>**Wszystkie</option>";
            for($i=0; $i<mysql_num_rows($data); $i++)
            {
                $rows=mysql_fetch_assoc($data);
                foreach($rows as $key )
                { 
                    echo '<option value='.$key.'>'.$key.'</option>'; 
                }
            }
        }
        mysql_close($mysqlConnect);      
    }

    function location_of_offer()
    {
        $mysqlConnect=@mysql_connect("localhost", "root", "") or die(mysql_error());
        mysql_select_db("nieruchomosci") or die(mysql_error());
        mysql_set_charset("utf8");
        $questions="SELECT DISTINCT Miasto FROM nieruchomosci";
        $data=mysql_query($questions) or die(MYSQL_ERROR);
        if(mysql_num_rows($data)>0)
        {
            echo "<option>**Wszystkie</option>";
            for($i=0; $i<mysql_num_rows($data); $i++)
            {
                $rows=mysql_fetch_assoc($data);
                foreach($rows as $key )
                { 
                    echo '<option value='.$key.'>'.$key.'</option>'; 
                }
            }
        }
        mysql_close($mysqlConnect);      
    }


    

    function show_data()
    {
        $mysqlConnect=@mysql_connect("localhost", "root", "") or die(mysql_error());
        mysql_select_db("nieruchomosci") or die(mysql_error());
        mysql_set_charset("utf8");

        $type_offer=$_POST["type_offer"];
        $kind_offer=$_POST["kind_offer"];
        $location=$_POST["location"];    
        
        //WYSWIETLA OFERTY ZE WZGLEDU NA TYP OFERTY 
        if(($type_offer!='**Wszystkie') && ($kind_offer='**Wszystkie') && ($location='**Wszystkie'))
        {
            $questions="SELECT * FROM nieruchomosci WHERE Typ_oferty='$type_offer' ORDER BY ID DESC";
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
                    </div> ';
                }
            }
            mysql_close($mysqlConnect);
        }
        //WYSWIETLA OFERTY ZE WZGLEDU NA TYP  RODZAJ
        else if(($type_offer='**Wszystkie') && ($kind_offer!='**Wszystkie') && ($location='**Wszystkie'))
        {
            $questions="SELECT * FROM nieruchomosci WHERE Rodzaj_oferty='$kind_offer' ORDER BY ID DESC";
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
                    </div> ';
                }
            }
            mysql_close($mysqlConnect);
        }
        //WYSWIETLA OFERTY ZE WZGLEDU NA MIASTO
        else if(($type_offer='**Wszystkie') && ($kind_offer='**Wszystkie') && ($location!='**Wszystkie'))
        {
            $questions="SELECT * FROM nieruchomosci WHERE  Miasto='$location' ORDER BY ID DESC";
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
                    </div> ';
                }
            }
            mysql_close($mysqlConnect);
        }
        //WYSWIETLA OFERTY ZE WZGLEDU NA TYP OFERTY I RODZAJ
        else if(($type_offer!='**Wszystkie') && ($kind_offer!='**Wszystkie') && ($location='**Wszystkie'))
        {
            $questions="SELECT * FROM nieruchomosci WHERE Typ_oferty='$type_offer' AND Rodzaj_oferty='$kind_offer' ORDER BY ID DESC";
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
                    </div> ';
                }
            }
            mysql_close($mysqlConnect);
        }
        //WYSWIETLA OFERTY ZE WZGLEDU NA TYP OFERTY I MIASTO
        else if(($type_offer!='**Wszystkie') && ($kind_offer='**Wszystkie') && ($location!='**Wszystkie'))
        {
            $questions="SELECT * FROM nieruchomosci WHERE Typ_oferty='$type_offer' AND Miasto='$location' ORDER BY ID DESC";
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
                    </div> ';
                }
            }
            mysql_close($mysqlConnect);
        }
        
        
        
        
        
        
        
        
        
        //WYSWIETLA OFERTY ZE WZGLEDU NA RODZAJ I MIASTO
        else if(($type_offer='**Wszystkie') && ($kind_offer!='**Wszystkie') && ($location!='**Wszystkie'))
        {
            $questions="SELECT * FROM nieruchomosci WHERE Rodzaj_oferty=".$kind_offer." AND Miasto=".$location." 
                        ORDER BY ID DESC;";
            
            
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
                    </div> ';
                }
            }
            mysql_close($mysqlConnect);
        }
        
        
        
        
        else if(($type_offer='**Wszystkie') && ($kind_offer='**Wszystkie') && ($location='**Wszystkie'))
        {
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
                    </div> ';
                }
            }
            mysql_close($mysqlConnect);
        }
                
        
        
        
        
    }


?>