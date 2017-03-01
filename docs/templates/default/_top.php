<!DOCTYPE html>

<html>

<head>
  <script>
    (function(i, s, o, g, r, a, m) {
      i['GoogleAnalyticsObject'] = r;
      i[r] = i[r] || function() {
        (i[r].q = i[r].q || []).push(arguments)
      }, i[r].l = 1 * new Date();
      a = s.createElement(o),
        m = s.getElementsByTagName(o)[0];
      a.async = 1;
      a.src = g;
      m.parentNode.insertBefore(a, m)
    })(window, document, 'script', 'https://www.google-analytics.com/analytics.js', 'ga');

    ga('create', 'UA-92180284-1', 'auto');
    ga('send', 'pageview');

  </script>
  <title>Dust to Ash</title>
  <link rel="stylesheet" type="text/css" href="../boilerplate.css" media="screen"/>
  
    <script src="http://webfonts.creativecloud.com/acme:n4:default.js" type="text/javascript"></script>
</head>

<body>
  <nav>
    <div id="navDiv">
	  <span onclick="location.href='http://DustToAsh.org';" class="navSpan">Home</span>
	  <span onclick="location.href='http://github.com/Alixia-Org/Dust-to-Ash';" class="navSpan">GitHub</span>
	  <span onclick="location.href='http://github.com/Alixia-Org/Dust-to-Ash/wiki';" class="navSpan">Wiki</span>
      
      <?php 
	  	if(isLoggedIn()){echo "<span onClick='location.href=\"http://DustToAsh.org/process_sign_out.php\";' id=\"yellow-nav-span\" class=\"navSpan\">Log Out</span>
		<style>
	  #yellow-nav-span{color:yellow;}
	  #yellow-nav-span:hover{color:red}
	  </style>
		";}
		else{
			echo "<span onclick=\"location.href='http://DustToAsh.org/sign-up.php';\" id=\"green-nav-span\" class=\"navSpan\">Sign Up</span>
	  <span onclick=\"location.href='http://DustToAsh.org/log-in.php';\" id=\"blue-nav-span\" class=\"navSpan\">Log In</span>
	  <style>
	  #yellow-nav-span{color:yellow;}
	  #green-nav-span{color:green;}
	  #blue-nav-span{color:blue;}
	  #blue-nav-span:hover, #green-nav-span:hover{color:red}</style>
	  ";
			
		}
	  ?>
	  
	</div>
  </nav>
  <div id="content-box">