<?php
if(isset($_COOKIE['username'])){
	$cookie_signedout_override="a";
$temp_NAME = $_COOKIE['username'];}else{$temp_NAME = false;}
setcookie("username", "null", 1);
setcookie("email", "null", 1);
setcookie("sessionID", "null", 1);

include "_definitions.php";
strttmplt();
if($temp_NAME==false){echo "You were never signed in.....";}else{
echo "You have been successfully signed out, $temp_NAME!";
}

endtmplt();
 ?>