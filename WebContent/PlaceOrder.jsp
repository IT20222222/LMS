<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang= "en">
<head>
<meta charset="ISO-8859-1">

  <meta charset="utf-8">
  <title>Remember - Multipurpose bootstrap site template</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta name="description" content="Your page description here" />
  <meta name="author" content="" />

  <!-- css -->
  <link href="css/bootstrap.css" rel="stylesheet" />
  <link href="css/bootstrap-responsive.css" rel="stylesheet" />
  <link href="css/prettyPhoto.css" rel="stylesheet" />
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">
  <link href="css/zstyle.css" rel="stylesheet">



  <!-- Theme skin -->
  <link id="t-colors" href="color/default.css" rel="stylesheet" />

  <!-- Fav and touch icons -->
  <link rel="apple-touch-icon-precomposed" sizes="144x144" href="ico/apple-touch-icon-144-precomposed.png" />
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="ico/apple-touch-icon-114-precomposed.png" />
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="ico/apple-touch-icon-72-precomposed.png" />
  <link rel="apple-touch-icon-precomposed" href="ico/apple-touch-icon-57-precomposed.png" />
  <link rel="shortcut icon" href="ico/favicon.png" />

  <!-- =======================================================
    Theme Name: Remember
    Theme URL: https://bootstrapmade.com/remember-free-multipurpose-bootstrap-template/
    Author: BootstrapMade.com
    Author URL: https://bootstrapmade.com
  ======================================================= -->

</head>
<body>

 <div id="wrapper">
    <!-- start header -->
    <header>
      <div class="top">
        <div class="container">
          <div class="row">
            <div class="span6">
              <ul class="topmenu">
                <li><a href="#">Home</a> &#47;</li>
                <li><a href="#">Terms</a> &#47;</li>
                <li><a href="#">Privacy policy</a></li>
              </ul>
            </div>
            <div class="span6">

              <ul class="social-network">
                <li><a href="#" data-placement="bottom" title="Facebook"><i class="icon-circled icon-bglight icon-facebook"></i></a></li>
                <li><a href="#" data-placement="bottom" title="Twitter"><i class="icon-circled icon-bglight icon-twitter"></i></a></li>
                <li><a href="#" data-placement="bottom" title="Linkedin"><i class="icon-circled icon-linkedin icon-bglight"></i></a></li>
                <li><a href="#" data-placement="bottom" title="Pinterest"><i class="icon-circled icon-pinterest  icon-bglight"></i></a></li>
                <li><a href="#" data-placement="bottom" title="Google +"><i class="icon-circled icon-google-plus icon-bglight"></i></a></li>
              </ul>

            </div>
          </div>
        </div>
      </div>
      <div class="container">


        <div class="row nomargin">
          <div class="span4">
            <div class="logo">
              <h1><a href="index.html"><i class="icon-tint"></i> Remember</a></h1>
            </div>
          </div>
          <div class="span8">
            <div class="navbar navbar-static-top">
              <div class="navigation">
                <nav>
                  <ul class="nav topnav">
                    <li><a href="index.html">Home</a></li>
                    <li class="dropdown">
                      <a href="#">Features <i class="icon-angle-down"></i></a>
                      <ul class="dropdown-menu">
                        <li><a href="typography.html">Typography</a></li>
                        <li><a href="components.html">Components</a></li>
                        <li><a href="icons.html">Icons</a></li>
                        <li><a href="icon-variations.html">Icon variations</a></li>

                      </ul>
                    </li>
                    <li class="dropdown">
                      <a href="#">Pages <i class="icon-angle-down"></i></a>
                      <ul class="dropdown-menu">
                        <li><a href="about.html">About us</a></li>
                        <li><a href="pricingbox.html">Pricing boxes</a></li>
                        <li><a href="404.html">404</a></li>
                      </ul>
                    </li>
                    <li class="dropdown">
                      <a href="#">Portfolio <i class="icon-angle-down"></i></a>
                      <ul class="dropdown-menu">
                        <li><a href="portfolio-2cols.html">Portfolio 2 columns</a></li>
                        <li><a href="portfolio-3cols.html">Portfolio 3 columns</a></li>
                        <li><a href="portfolio-4cols.html">Portfolio 4 columns</a></li>
                        <li><a href="portfolio-detail.html">Portfolio detail</a></li>
                      </ul>
                    </li>
                    <li class="dropdown">
                      <a href="#">Blog <i class="icon-angle-down"></i></a>
                      <ul class="dropdown-menu">
                        <li><a href="blog-left-sidebar.html">Blog left sidebar</a></li>
                        <li><a href="blog-right-sidebar.html">Blog right sidebar</a></li>
                        <li><a href="post-left-sidebar.html">Post left sidebar</a></li>
                        <li><a href="post-right-sidebar.html">Post right sidebar</a></li>
                      </ul>
                    </li>
                    <li class="active">
                      <a href="contact.html">Place Order </a>
                    </li>
                  </ul>
                </nav>
              </div>
              <!-- end navigation -->
            </div>
          </div>
        </div>
      </div>
    </header>
    <!-- end header -->

    <section id="inner-headline">
      <div class="container">
        <div class="row">
          <div class="span4">
            <div class="inner-heading">
              <h2>Get in touch</h2>
            </div>
          </div>
          <div class="span8">
            <ul class="breadcrumb">
              <li><a href="index.html">Home</a> <i class="icon-angle-right"></i></li>
              <li class="active">Place Order</li>
            </ul>
          </div>
        </div>
      </div>
    </section>

    <section id="content">
     
	 
<div class="containerr">
  <form action = "InsertOrder" method ="post">
    <div class="roww">
      <h4>Customer Type</h4>
    <div class="input-groupp">
        <input type="radio" name="CustomerType" value="prepaid" id="prepaid" checked="true"/>
        <label for="prepaid"><span><i class="fa fa-cc-visa"></i>Prepaid Customer</span></label>
        <input type="radio" name="CustomerType" value="postpaid" id="postpaid"/>
        <label for="postpaid"> <span><i class="fa fa-cc-paypal"></i>Postpaid Customer</span></label>
      </div>
    </div>
	
    <div class="roww">
      <div class="col-halff">
        <h4>Date to collect or drop the order</h4>
        <div class="input-groupp">
          <div class="col-thirdd">
            <input type="text" name ="Date" placeholder="DD"/>
          </div>
          <div class="col-thirdd">
            <input type="text" name ="Date" placeholder="MM"/>
          </div>
          <div class="col-thirdd">
            <input type="text" name ="Date" placeholder="YYYY"/>
          </div>
        </div>
      </div>
	  </div>
	  
	   <div class="roww">
      <h4>Method of the Order</h4>
    <div class="input-groupp">
        <input type="radio" name="OrderMethod" value="home" id="home" checked="true"/>
        <label for="home"><span><i class="fa fa-cc-visa"></i>Collect From Home</span></label>
        <input type="radio" name="OrderMethod" value="shop" id="shop"/>
        <label for="shop"> <span><i class="fa fa-cc-paypal"></i>Drop At Shop</span></label>
      </div>  
    </div>
	
	    <div class="roww">
      <h4>Location</h4>
	     <div class="input-groupp">
        <input type="textbox" name ="Location" placeholder="Address"/>
        <div class="input-iconn"><i class="fa fa-user"></i></div>
      </div>
    </div>
	  
    	    <div class="roww">
      <h4>Additional Details</h4>
	     <div class="input-groupp ">
        <input type="textArea" name ="details" placeholder="More details"/>
        <div class="input-iconn"><i class="fa fa-user"></i></div>
      </div>
    </div>
    
    	    <div class="roww">
      <h4>Payment Amount</h4>
	     <div class="input-groupp ">
        <input type="textArea" name ="PaymentAmount" placeholder="amount"/>
        <div class="input-iconn"><i class="fa fa-user"></i></div>
      </div>
    </div>
    
    <div class="roww">
      <h4>Payment Details</h4>
      <div class="input-groupp">
        <input type="radio" name="payment-method" value="card" id="payment-method-card" checked="true"/>
        <label for="payment-method-card"><span><i class="fa fa-cc-visa"></i>Credit Card</span></label>
        <input type="radio" name="payment-method" value="paypal" id="payment-method-paypal"/>
        <label for="payment-method-paypal"> <span><i class="fa fa-cc-paypal"></i>Paypal</span></label>
      </div>
      <div class="input-groupp ">
        <input type="text" name ="number" placeholder="Card Number"/>
        <div class="input-iconn"><i class="fa fa-credit-card"></i></div>
      </div>
      <div class="col-half">
        <div class="input-groupp ">
          <input type="text" name ="cvc" placeholder="Card CVC"/>
          <div class="input-iconn"><i class="fa fa-user"></i></div>
        </div>
      </div>
      <div class="col-half">
        <div class="input-groupp">
		<input type= "date" name ="expdate" placeholder="exp date"/>
        </div>
      </div>
    </div>
    <div class="roww">
      <h4>Terms and Conditions</h4>
      <div class="input-groupp">
        <input type="checkbox" id="terms"/>
        <label for="terms">I accept the terms and conditions for signing up to this service, and hereby confirm I have read the privacy policy.</label>
      </div>
      <input  type="submit" class="login1" id="btnl" name="btnl" value="sumbit" >
    </div>
  </form>
</div>
	 
	 
    </section>

    <footer>
      <div class="container">
        <div class="row">
          <div class="span4">
            <div class="widget">
              <div class="footer_logo">
                <h3><a href="index.html"><i class="icon-tint"></i> Remember</a></h3>
              </div>
              <address>
							  <strong>Remember company Inc.</strong><br>
  							Somestreet KW 101, Park Village W.01<br>
  							Jakarta 13426 Indonesia
  						</address>
              <p>
                <i class="icon-phone"></i> (123) 456-7890 - (123) 555-7891 <br>
                <i class="icon-envelope-alt"></i> email@domainname.com
              </p>
            </div>
          </div>
          <div class="span4">
            <div class="widget">
              <h5 class="widgetheading">Browse pages</h5>
              <ul class="link-list">
                <li><a href="#">Our company</a></li>
                <li><a href="#">Terms and conditions</a></li>
                <li><a href="#">Privacy policy</a></li>
                <li><a href="#">Press release</a></li>
                <li><a href="#">What we have done</a></li>
                <li><a href="#">Our support forum</a></li>
              </ul>

            </div>
          </div>
          <div class="span4">
            <div class="widget">
              <h5 class="widgetheading">From flickr</h5>
              <div class="flickr_badge">
                <script type="text/javascript" src="http://www.flickr.com/badge_code_v2.gne?count=8&amp;display=random&amp;size=s&amp;layout=x&amp;source=user&amp;user=34178660@N03"></script>
              </div>
              <div class="clear"></div>
            </div>
          </div>
        </div>
      </div>
      <div id="sub-footer">
        <div class="container">
          <div class="row">
            <div class="span6">
              <div class="copyright">
                <p><span>&copy; Remember Inc. All right reserved</span></p>
              </div>

            </div>

            <div class="span6">
              <div class="credits">
                <!--
                  All the links in the footer should remain intact.
                  You can delete the links only if you purchased the pro version.
                  Licensing information: https://bootstrapmade.com/license/
                  Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Remember
                -->
                Created by <a href="https://bootstrapmade.com/">BootstrapMade</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </footer>
  </div>
  <a href="#" class="scrollup"><i class="icon-angle-up icon-rounded icon-bglight icon-2x"></i></a>

  <!-- javascript
    ================================================== -->
  <!-- Placed at the end of the document so the pages load faster -->
  <script src="js/jquery.js"></script>
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/bootstrap.js"></script>
  <script src="js/modernizr.custom.js"></script>
  <script src="js/toucheffects.js"></script>
  <script src="js/google-code-prettify/prettify.js"></script>
  <script src="js/jquery.prettyPhoto.js"></script>
  <script src="js/portfolio/jquery.quicksand.js"></script>
  <script src="js/portfolio/setting.js"></script>
  <script src="js/animate.js"></script>

  <!-- Contact Form JavaScript File -->
  <script src="contactform/contactform.js"></script>

  <!-- Template Custom JavaScript File -->
  <script src="js/custom.js"></script>


</body>
</html>