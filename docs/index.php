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
      background-image: url("http://www.planwallpaper.com/static/images/4443091-cool-backgrounds_gfTObcJ.jpg");
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
    }

  </style>
    <div id="content-1" class="contentPanes">This is the first content pane on this page.</div>
    <div id="content-2" class="contentPanes">This is the second content pane on this page.</div>
    <div id="content-3" class="contentPanes">This is the third content pane on this page.</div>
    <div id="content-4" class="contentPanes">This is the last content pane on this page.</div>
<?php include("templates/page_bottom.php");?>