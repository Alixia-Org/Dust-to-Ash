<?php include("_definitions.php");
unset($invalid_email);
unset($signup_fail);
unset($password_too_short);
unset($duplicate_email);
unset($duplicate_username);
if(isset($_COOKIE['sign_up_fail_invalid_email'])){$invalid_email = true;setcookie('sign_up_fail_invalid_email',NULL, 1);}
if(isset($_COOKIE['sign_up_fail'])){$signup_fail=true;setcookie('sign_up_fail', NULL, 1);}
if(isset($_COOKIE['password_too_short'])){$password_too_short = true;setcookie('password_too_short', NULL, 1);}
if(isset($_COOKIE['duplicate_email'])){$duplicate_email = true;setcookie('duplicate_email', NULL, 1);}
if(isset($_COOKIE['duplicate_username'])){$duplicate_username = true;setcookie('duplicate_username', NULL, 1);}
?>
<?php strttmplt();?>
    <style type="text/css">
#content-box{text-align:center;}
</style>
<h1>Sign Up!</h1>
<div style="display:inline-block; width:72%;"><p6>(<strong>This webpage isn't ready yet.</strong> We should now recieve all of the stuff you send, but don't put in sensitive information, just to be safe. Apart from that, feel free to type in any crap you want and push submit. :)</p6></div>
<br><br>
<form action="process_sign_up.php" method="post">

<?php 
if(!isset($invalid_email)){ echo "<div style=\"color:red\">Invalid Email</div><br><br>";}
if(!isset($password_too_short))echo "<div style=\"color:red\">Your password was too short.</div><br><br>";
if(!isset($duplicate_email))echo "<div style=\"color:red\">An account has already been made with that email.</div><br><br>";
if(!isset($duplicate_username))echo "<div style=\"color:red\">That Username is taken.</div><br><br>";

if(!isset($signup_fail)){echo "<div style=\"color:red\">That username is already taken...</div><br><br>";}
unset($invalid_email);
unset($signup_fail);

 ?>

Email:<br><br>
<input type="email" name="email">
<br><br>
Password:<br><p6>(Don't use this yet!)</p6><br><br>
<input type="password" name="password">
<br><br>
Username:<br><br>
<input type="text" name="username">
<br><br>
<input type="submit">

</form>

<br><br>


    <?php endtmplt();?>