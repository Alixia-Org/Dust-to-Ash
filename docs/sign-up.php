<?php include("templates/var_defs.php");
if(isset($_COOKIE['sign_up_fail_invalid_email'])){$bool1 = false;setcookie('sign_up_fail_invalid_email',NULL, 1);}
if(isset($_COOKIE['sign_up_fail'])){$bool2=false;setcookie('sign_up_fail', NULL, 1);}
?>
<?php include("templates/page_top.php");?>
    <style type="text/css">
#content-box{text-align:center;}
</style>
<h1>Sign Up!</h1>
<div style="display:inline-block; width:72%;"><p6>(<strong>This webpage isn't ready yet.</strong> We should now recieve all of the stuff you send, but don't put in sensitive information, just to be safe. Apart from that, feel free to type in any crap you want and push submit. :)</p6></div>
<br><br>
<form action="process_sign_up.php" method="post">

<?php 
if(isset($bool1)){ echo "<div style=\"color:red\">Invalid Email</div><br><br>";}

if(isset($bool2)){echo "<div style=\"color:red\">That username is already taken...</div><br><br>";}
unset($bool1);
unset($bool2);

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


    <?php include("templates/page_bottom.php");?>