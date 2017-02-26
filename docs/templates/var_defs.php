<?php $footerCode = array(""); 

$username = 'root';
$password = 'Yorick123';
try {
    $conn = new PDO("mysql:host=localhost;dbname=users", $username, $password);
    // set the PDO error mode to exception
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    }
catch(PDOException $e)
    {
    echo "We failed to connect to our own servers. They are probably down, since a connection to ourselves can't really fail. Please try again later or check with our homepage for anything about our databases being down.";
    }


function addFooterCode($code){
	global $footerCode;
	$footerCode[sizeof($footerCode)] = $code;
}

function signUp($name, $email, $password){
	
}



?>