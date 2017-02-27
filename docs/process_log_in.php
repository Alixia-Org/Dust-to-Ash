<?php include("templates/var_defs.php");

$bool = logIn($_POST['username'], $_POST["password"]);
	include("templates/page_top.php");
	
	if(!$bool){
		setcookie("sign_in_fail", "fail", time()+600,"/log-in.php");
		header( 'Location: http://dusttoash.org/log-in.php' ) ;
		}else{
			echo "You have successfully logged in $name";
		}
		unset($bool);
		unset($name);
		
		include("templates/page_bottom.php");
		
		
 ?>