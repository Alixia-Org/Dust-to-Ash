<?php
if(isset($_COOKIE['username'])){
$temp_NAME = $_COOKIE['username'];}else{$temp_NAME = false;}
setcookie("username", "null", 1);
setcookie("email", "null", 1);
setcookie("sessionID", "null", 1);
include "templates/var_defs.php";
include "templates/page_top.php";
if($temp_NAME==false){echo "You were never signed in.....";}else{
echo "You have been successfully signed out, $temp_NAME!";
}

include "templates/page_bottom.php";
 ?>