<?php
  $query = $db->query("SELECT * FROM categories");
  $result=$query->results();

require_once 'users/init.php';
require_once $abs_us_root.$us_url_root.'users/includes/template/prep.php';
?>
<header class="masthead text-white text-center">
  <div class="overlay"></div>
  <div class="container">
    <div class="row">
      <div class="col-xl-9 mx-auto">
        <h1 class="mb-5 text-center title_header">Wyszukaj</h1>
      </div>
      <div class="col-md-12 ">
        <form method="post" action="../search.php">
          <div class="row search_center">
              <div class="col-12 col-md-5 mb-5 mb-md-4">
                <input type="text" class="form-control form-control-lg" name="search_field" placeholder="Szukaj produktu...">
              </div>
              <div class="col-12 col-md-2">
                <button type="submit"  class="btn btn-block btn-lg btn-primary">Wyszukaj</button>
              </div>
          </div>
        </form>

      </div>
    </div>
  </div>
</header>

 