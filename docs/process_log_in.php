<?php include("templates/var_defs.php");
if(isset($_COOKIE['username']))
$name=$_COOKIE['username'];
$bool = logIn($_POST['username'], $_POST["password"]);
	include("templates/page_top.php");
	
	if($bool){
		
		echo "You have successfully logged in $name";
		}else{
			echo "You could not be signed in...";
		}
		unset($bool);
		
		include("templates/page_bottom.php");
		
		
 ?>