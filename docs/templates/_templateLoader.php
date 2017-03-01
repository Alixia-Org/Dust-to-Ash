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
	include 'templates/' . $template . '/_top.php';
}

function endtmplt(){
	global $template;
	include_once 'templates/' . $template . '/_bottom.php';
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
?>