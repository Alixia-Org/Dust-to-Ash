<?php include("_definitions.php");

$bool = logIn($_POST['username'], $_POST["password"]);
	strttmplt();
	
	if(!$bool){
		setcookie("sign_in_fail", "fail", time()+600,"/log-in.php");
		header( 'Location: http://dusttoash.org/log-in.php' ) ;
		}else{
			echo "You have successfully logged in $name";
		}
		unset($bool);
		unset($name);
		
		endtmplt();
		
		
 ?>