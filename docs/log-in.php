<?php include("_definitions.php"); strttmplt();?>


<h1>Log In</h1>
<br><br>
<?php if(isset($_COOKIE['sign_in_fail'])) echo '<div style="color:red; text-align:center;">Incorrect Information was entered...</div><br><br>';setcookie("sign_in_fail", NULL, 1, "/log-in.php"); ?>



<form action="process_log_in.php" method="post">
Username:<br><br>
<input type="text" name="username"><br><br>
Password:<br><br>
<input type="password" name="password"><br><br><br>
<input type="submit"><br><br>

</form>


<?php endtmplt();?>