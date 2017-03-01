<?php
include("_definitions.php");
if(strpos($_POST['email'], '@')===false || strpos($_POST['email'],'.')===false || strlen($_POST['email'])<7){
setcookie('sign_up_fail_invalid_email', 'fail', time()+60, "/");
header('Location: http://dusttoash.org/sign-up.php');
}



$bool = addUser($_POST['email'],$_POST['username'], $_POST['password']);
if(isset($bool)){ 
setcookie('username',$_POST['username'], time()+86400*3, '/');
setcookie('email', $_POST['email'],time()+ 86400*3, '/');
setcookie('sessionID', genSessionID('username'), time()+86400*3, '/');
}else{
	setcookie("sign_up_fail", "f", time()+600,"/sign-up.php");
		header( 'Location: http://dusttoash.org/sign-up.php' ) ;
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