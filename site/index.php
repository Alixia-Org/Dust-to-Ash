<?php include("_definitions.php");setTitle('Test Page!');addFooterCode("This page is used by us to test out things!");
strttmplt();?>
    <style type="text/css">
    @keyframes content-slide-in-from-left {
      from {
        background-position-x: -100vw;
      }
      to {
        background-position: 0% 0%;
      }
    }
    @keyframes content-slide-in-from-right {
      from {
        background-position-x: 100vw;
      }
      to {
        background-position: 0% 0%;
      }
    }
    @keyframes content-4-fade-in {
      0% {
        opacity: 0;
        background: transparent;
      }
      50% {
        opacity: 0;
        background: transparent;
      }
      100% {
        opacity: 1;
        background: #1A1A1A;
      }
    }
    .contentPanes {
      height: 200px;
      background-image: url("content-1-bg.png");
      background-size: 100% 100%;
      background-repeat: no-repeat;
    }
    #content-4 {
      opacity: 0;
      background: transparent;
      animation: content-4-fade-in 4.4s;
      opacity: 1;
      background: #1A1A1A;
    }
    #content-1,
    #content-3 {
      background-position: -100vw;
      animation: content-slide-in-from-left 2.2s;
      background-position: 0% 0%;
    }
    #content-2 {
      background-position: 100vw;
      animation: content-slide-in-from-right 2.2s;
      background-position: 0% 0%;
	  background-image:url("content-2-bg.jpg");
    }
	#content-3{
		background-image:url("content-3-bg.jpg");
		
	}

  </style>
    <?php  addFooterCode("Lol. This is some text. <br><br> This is some more text."); ?>
    <div id="content-1" class="contentPanes"></div>
    <div id="content-2" class="contentPanes"></div>
    <div id="content-3" class="contentPanes"></div>
    <div id="content-4" class="contentPanes"></div>
    <?php endtmplt();?>