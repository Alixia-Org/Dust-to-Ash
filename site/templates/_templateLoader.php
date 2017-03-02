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
	if(strcasecmp($templateName, 'default')==0||strcasecmp($templateName, 'default_template')==0)
	$template = 'default';
	elseif(strcasecmp($templateName, 'columns')==0)
	$template='columns';
	else
	$template = 'default';
}
function strttmplt(){
	global $template;
	include_once $_SERVER['DOCUMENT_ROOT'].'/templates/' . $template . '/_top.php';
	echo '<script>';
	include_once __DIR__ . '/_shared/_googleAnalytics.js';
	echo '</script>';
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
	public static $navButtons = array();
	public $name, $link;
	function __construct($buttonName, $buttonLink){
		$this->name=$buttonName;
		$this->link=$buttonLink;
	}
}

function addNavButton($name,$link){
	NavButton::$navButtons[sizeof(NavButton::$navButtons)] = new NavButton($name, $link);
}

function getNavButtons(){
	return NavButton::$navButtons;
}
if(file_exists($_SERVER['DOCUMENT_ROOT'] . '/templates/'.$template.'/_load.php'))
include $_SERVER['DOCUMENT_ROOT'] . '/templates/'.$template.'/_load.php';
?>