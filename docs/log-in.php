<?php include("templates/var_defs.php"); include("templates/page_top.php");?>


<h1>Log In</h1>
<br><br>
<form action="process_log_in.php" method="post">
Username/email:<br><br>
<input type="text" name="username"><br><br>
Password:<br><br>
<input type="password" name="password"><br><br><br>
<input type="submit">

</form>


<?php include("templates/page_bottom.php");?>