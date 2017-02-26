<?php $footerCode = array(""); 

$failed_to_connect_to_sql_database = false;
$iEmail = '';
$iPassword = '';
$iUsername = '';


try {
    $con = new PDO("mysql:host=localhost;dbname=users", 'root', 'Yorick123');
    // set the PDO error mode to exception
    $con->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
	$stmt = $con->prepare('INSERT INTO users (email, password, sessionID, signup_date, username) VALUES(:email, :password, :sessionID, CURRENT_DATE, :username)');
	$stmt->bindParam(':email', $iEmail);
	$stmt->bindParam(':password', $iPassword);
	$stmt->bindParam(':sessionID', genSessionID($iUsername));
	$stmt->bindParam(':username', $iUsername);
    }
catch(PDOException $e)
    {
     $failed_to_connect_to_sql_database = true;
	}
	
	function genSessionID($name){
		
	}
	
	function addUser($email, $username, $password){
		global $failed_to_connect_to_sql_database, $iEmail, $iPassword, $iUsername;
		if($failed_to_connect_to_sql_database){return false;}
		$iEmail = $email;
		$iPassword=$password;
		$iUsername=$username;
	
	$stmt->execute();
	return true;
	
	}

$sessionID = 0;
$username = '';
if(isset($_COOKIE['sessionID'])) {$sessionID = $_COOKIE['sessionID'];}
if(isset($_COOKIE['username'])){$username = $_COOKIE['username'];}


function addFooterCode($code){
	global $footerCode;
	$footerCode[sizeof($footerCode)] = $code;
}

function signUp($name, $email, $password){
	
}



?>