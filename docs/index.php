<?php include("templates/var_defs.php");?>
<?php include("templates/page_top.php");?>
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
    <div id="content-1" class="contentPanes">This is the first content pane on this page.<br>
    <br>
    This content pane has a background from the internet put on it. I did not make these backgrounds.</div>
    <div id="content-2" class="contentPanes"><s>This is the second content pane on this page.</s><br>
    <br>
    These backgrounds will soon be randomized,</div>
    <div id="content-3" class="contentPanes"><s>This is the third content pane on this page.</s><br>
    <br>
    I just need to put in some bgs that I've made on my own.</div>
    <div id="content-4" class="contentPanes"><s>This is the last content pane on this page.</s><br>
    <br>
    <br>
    Which will happen as soon as I can take some viable screenshots of <strong><a href="https://github.com/Alixia-Org/Dust-to-Ash">Dust To Ash</a></strong>.</div>
    <?php include("templates/page_bottom.php");?>