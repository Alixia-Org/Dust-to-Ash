<?php
include("_definitions.php");
$var = addUser($_POST['email'],$_POST['username'], $_POST['password']);

if(!strcasecmp($var, 'invalid email'))
setcookie('sign_up_fail_invalid_email', 'fail', time()+60, $_SERVER['DOCUMENT_ROOT'].'/sign-up.php');

if(!strcasecmp($var, 'password too short'))
setcookie('password_too_short', 'fail', time()+60, $_SERVER['DOCUMENT_ROOT'].'/sign-up.php');

if(!strcasecmp($var, 'duplicate email'))
setcookie('duplicate_email', 'fail', time()+60, $_SERVER['DOCUMENT_ROOT'].'/sign-up.php');

if(!strcasecmp($var, 'duplicate username'))
setcookie('duplicate_username', 'fail', time()+60, $_SERVER['DOCUMENT_ROOT'].'/sign-up.php');



if(!strcasecmp($var, 'success')){ 
setcookie('username',$_POST['username'], time()+86400*3, '/');
setcookie('email', $_POST['email'],time()+ 86400*3, '/');
setcookie('sessionID', genSessionID('username'), time()+86400*3, '/');
}else{
	header('Location: http://dusttoash.org/sign-up.php');
}



strttmplt();

 ?>

<h1>Success!!!</h1>
<br>
<br>
You have successfully signed up!
<?php

endtmplt();

 ?>