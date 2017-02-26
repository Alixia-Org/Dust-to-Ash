<?php 
$temp_NAME = $_COOKIE['username'];
setcookie("username", "null", 1);
setcookie("email", "null", 1);
setcookie("sessionID", "null", 1);
include "templates/var_defs.php";
include "templates/page_top.php";
echo "You have been successfully signed out, $temp_NAME!";
include "templates/page_bottom.php";
 ?>