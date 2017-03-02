<?php include $_SERVER['DOCUMENT_ROOT'] . '/_definitions.php'; selectTemplate('orange_cream');

addNavButton("Test", "http://dusttoash.org/");

strttmplt();?>

<h1>HEADER <?php foreach(NavButton::$navButtons as $p) echo $p->name; ?></h1>

<?php endtmplt();?>