<?php include("templates/var_defs.php");
	include("templates/page_top.php");
	if(logIn($_POST['username'], $_POST["password"])){
		$name=$_COOKIE['username'];
		
		echo "You have successfully logged in $name";
		}else{
			echo "You could not be signed in...";
		}
		
		include("templates/page_bottom.php");
 ?>