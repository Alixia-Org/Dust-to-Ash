<?php

$footerCode = array(""); 
$failed_to_connect_to_sql_database = false;
$iEmail = '';
$iPassword = '';
$iUsername = '';
$stmt = '';
function signed_in(){
}
try {
    $con = new PDO("mysql:host=127.0.0.1;dbname=dusttoash", 'root', 'Yorick123');
    $con->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
	$stmt = $con->prepare('INSERT INTO users (email, password, sessionID, signup_date, username) VALUES(:email, :password, :sessionID, CURRENT_DATE, :username)');
	$gennedSessionID = genSessionID($iUsername);
	$stmt->bindParam(':email', $iEmail);
	$stmt->bindParam(':password', $iPassword);
	$stmt->bindParam(':sessionID', $gennedSessionID);
	$stmt->bindParam(':username', $iUsername);
    }
catch(PDOException $e)
    {
     $failed_to_connect_to_sql_database = true;
	}
	function genSessionID($name){
		return 'asdfkj23foi13lkf';
	}
	function addUser($email, $username, $password){
		global $failed_to_connect_to_sql_database, $iEmail, $iPassword, $iUsername, $stmt;
		if($failed_to_connect_to_sql_database){return false;}
		$iEmail = $email;
		$iPassword=$password;
		$iUsername=$username;
	$stmt->execute();
	return true;
	}
	$logInStmt = $con->prepare("UPDATE users SET sessionID=:id WHERE username=:name");
	$logInStmt2 = $con->prepare("SELECT password FROM users WHERE username=:name");
	$logInStmtId = '';
	$logInStmtName = '';
	$logInStmt->bindParam(':id', $logInStmtId);
	$logInStmt->bindParam(':name', $logInStmtName);
	$logInStmt2->bindParam(':name', $logInStmtName);
	function logIn($username, $password){
		global $logInStmt, $logInStmtName, $logInStmtId, $logInStmt2,  $con;
		$logInStmtName = $username;
		$logInStmt2->execute();
			$lol = $logInStmt2->fetchAll();
		foreach($lol as $thing){
		if($thing[0] === $password){
		$logInStmtId = genSessionID($username);
		$logInStmt->execute();
		setcookie('sessionId', $logInStmtId, time()+ 86400*3, '');
		setcookie('username', $logInStmtName, time()+ 86400*3, '');
		return true;}
		
		
		}
		return false;
		
	}
	
	function isLoggedIn(){
		return isset($_COOKIE['username']);
	}
function addFooterCode($code){
	global $footerCode;
	$footerCode[sizeof($footerCode)] = $code;
}
?>













