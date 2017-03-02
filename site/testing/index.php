<?php include $_SERVER['DOCUMENT_ROOT'] . '/_definitions.php'; selectTemplate('columns');

addNavButton("Home", "http://dusttoash.org/");
addNavButton("GitHub", 'https://github.com/Alixia-Org/Dust-to-Ash');
addNavButton("Wiki", 'https://github.com/Alixia-Org/Dust-to-Ash/wiki');
addFooterCode("This is some footer Text");

strttmplt();?>
<div class="content-pane">
<h1>HEADER</h1>
</div>
<div class="content-pane">Lorem Ipsum (I think that's correct.)</div>

<?php endtmplt();?>