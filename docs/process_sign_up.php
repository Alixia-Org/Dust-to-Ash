<?php
include("templates/var_defs.php");
$bool = addUser($_POST['email'],$_POST['username'], $_POST['password']);
if(isset($bool)){ 
setcookie('username',$_POST['username'], time()+86400*3, '/');
setcookie('email', $_POST['email'],time()+ 86400*3, '/');
setcookie('sessionID', genSessionID('username'), time()+86400*3, '/');
}else{
	setcookie("sign_up_fail", "fail", time()+600,"/log-in.php");
		header( 'Location: http://dusttoash.org/sign-up.php' ) ;
}



include "templates/page_top.php";

 ?>

<h1>Success!!!</h1>
<br>
<br>
You have successfully signed up!
<?php

include "templates/page_bottom.php";

 ?>