<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title><?php echo getTitle();?></title>
<link href="boilerplate.css" rel="stylesheet" type="text/css">
</head>
<body>
<nav><?php foreach(getNavButtons() as $navObj){echo '<div class="nav-objs" onClick="location.href=\''.$navObj->link.'">'.$navObj->name.'</div>';}?></nav>
<div id="content-pane">