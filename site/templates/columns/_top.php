<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title><?php echo getTitle();?></title>
<link href="/templates/columns/boilerplate.css" rel="stylesheet" type="text/css">
<script src="http://webfonts.creativecloud.com/acme:n4:default.js" type="text/javascript"></script>
</head>
<body>
<nav><?php foreach(getNavButtons() as $navObj){echo '<div class="nav-objs" onClick="location.href=\''.$navObj->link.'\'">'.$navObj->name.'</div>';}?></nav>
<div class="content-pane">