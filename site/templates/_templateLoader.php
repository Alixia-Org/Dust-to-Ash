<?php
$footerCode = array();
$template = 'default';
$title = '';
function setTitle($title_text) {
	global $title;
	$title = $title_text;
}
function getTitle(){
	global $title;
	return $title;
}
function selectTemplate($templateName){
	global $template;
	if(strcasecmp($templateName, 'default')==0)
	$template = 'default';
	elseif(strcasecmp($templateName, 'orange')==0||strcasecmp($templateName, 'orange_cream')==0)
	$template='orange_cream';
	else
	$template = 'default';
}
function strttmplt(){
	global $template;
	include_once $_SERVER['DOCUMENT_ROOT'].'/templates/' . $template . '/_top.php';
}

function endtmplt(){
	global $template;
	include_once $_SERVER['DOCUMENT_ROOT'].'/templates/' . $template . '/_bottom.php';
}

	//Sets footer code for the applied template...
function addFooterCode($code){
	global $footerCode;
	$footerCode[sizeof($footerCode)] = $code;
}

function getFooterCode(){
	global $footerCode;
	return $footerCode;
}
class NavButton {
	public $name, $link;
	function __construct(String $buttonName, String $buttonLink){
		global $name, $link;
		$name=$buttonName;
		$link=$buttonLink;
	}
}
$navButtons = array();
function addNavButton(String $name,String $link){
	global $navButtons;
	$navButtons[sizeof($navButtons)] = new NavButton($name, $link);
}

function getNavButtons(){
	global $navButtons;
	return $navButtons;
}
if(file_exists($_SERVER['DOCUMENT_ROOT'] . '/templates/'.$template.'/_load.php'))
include $_SERVER['DOCUMENT_ROOT'] . '/templates/'.$template.'/_load.php';
?>