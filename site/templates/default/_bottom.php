</div>
</body>
<footer>
	<p6>Hello <?php if(isset($_COOKIE['username'])){echo $_COOKIE['username'];} else {echo "user";} ?>.<p7>

  <?php foreach(getFooterCode() as $piece_of_code){
	echo $piece_of_code;
	}

?>
</footer>
</html>