function one_delete_product() {
  var result = confirm("Czy na pewno chcesz usunąć produkt?");
  if (result==true) {
   return true;
  } else {
   return false;
  }
}