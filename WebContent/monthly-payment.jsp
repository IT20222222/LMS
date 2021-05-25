<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.lms.model.User" %>
    <%@ page import="com.lms.model.RegularPlan" %>
    <% User user = (User) session.getAttribute("loggedUser");
       RegularPlan plan = (RegularPlan) session.getAttribute("userPlan");
       if(user == null){%>
      	<jsp:forward page="Login.jsp"/>
      <%}else{
   	    	if(plan.isCustomizable() == false){
   	    		response.sendRedirect("my-plan-normal.jsp");
   	    	}
   	    	
   	    }
	%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <title>Monthly Payment</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta name="description" content="Your page description here" />
  <meta name="author" content="" />

  <!-- css -->
  <link href="css/bootstrap.css" rel="stylesheet" />
  <link href="css/bootstrap-responsive.css" rel="stylesheet" />
  <link href="css/prettyPhoto.css" rel="stylesheet" />
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">

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

<body onload="captcha()">

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
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="dashboard-regular.jsp">Dashboard</a></li>
                    <li><a href="index.html">Place Order</a></li>
                    <li class="dropdown active"><a href="my-plan-regular.jsp">My Plan</a></li>
                    <li><a href="UserProfile.jsp">My Account</a></li>
                    <li><a href="/testWeb/LogOutServlet">Log Out</a></li>
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
              <h2>Monthly Payment <span  class="icon-money"></span></h2> 
            </div>
          </div>
          <div class="span8">
            <ul class="breadcrumb">
              <li><a href="index.jsp">Home</a> <i class="icon-angle-right"></i></li>
              <li><a href="my-plan.jsp">My Plan</a> <i class="icon-angle-right"></i></li>
              <li class="active">Monthly Payment</li>
            </ul>
          </div>
        </div>
      </div>
    </section>

    <section id="content">
		<div class="container">
			<div class="row demobtn">
				<div class="span12">

					<div class="row">
					  <div class="span12">
					  
					  <table align="center">
					  	<tr>
					  	
					  		<td  class="form">
							  		<form id = "pay" action="mPayment" method="post">
							  		<table width="100%">
								  		<tr>
								  			<td colspan=2 style="padding:15px 10px 10px 10px">
								  				<h6>Select Payment Method</h6>
								  				
								  			</td>
								  		</tr>
						
								  		<tr>
											<td style="padding:0px 10px 10px 10px">
											<input type="radio" id="card" name="option" onclick="document.getElementById('service').disabled = true;
											document.getElementById('pemail').disabled = true;document.getElementById('pfname').disabled = false;document.getElementById('plname').disabled = false;
											document.getElementById('cno').disabled = false;document.getElementById('date').disabled = false;document.getElementById('code').disabled = false;" checked> Credit/ Debit Card </td>
											<td style="padding:0px 10px 10px 10px">
											<input type="radio" id="other" name="option" onclick="document.getElementById('service').disabled = false;
											document.getElementById('pemail').disabled = false;document.getElementById('pfname').disabled = true;document.getElementById('plname').disabled = true;
											document.getElementById('cno').disabled = true;document.getElementById('date').disabled = true;document.getElementById('code').disabled = true;"> Other </td>
										</tr>
										<tr>
											<td style="padding:0px 10px 10px 10px">
											<br>
											Select Service*<br>
											<select id="service" disabled>
												<option value="Paypal">Paypal</option>
												<option value="Payoneer">Payoneer</option>
												<option value="Google Pay">Google Pay</option>
											</select>
											
											</td>
											<td style="padding:0px 10px 10px 10px;width:100%">
											<br>
											E-Mail*<br><input type="text" id="pemail" name="pemail" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" disabled required>
											</td>
										</tr>
										<tr>
											<td colspan=2 style="padding:0px 10px 0px 10px">
											<hr>
											</td>
										</tr>
										<tr>
											<td style="padding:10px 10px 10px 10px">First Name*<br><input type="text" id="pfname" name="pfname" required></td>
											<td style="padding:10px 10px 10px 10px">Last Name*<br><input type="text" id="plname" name="plname" required></td>
										</tr>
										<tr>
											<td colspan=2 style="padding:10px 10px 10px 10px;">
											Card Number*
											
											<br><input type="text" id="cno" style="width:450px"; name="cno" required>
											</td>
										</tr>
										<tr>
											<td style="padding:22px 10px 10px 10px">
											Expiration Date*<br>
											<input type="date" id="date" name="date" required>
											</td>
											<td style="padding:0px 10px 10px 10px">
											<br>
											Security Code*<br><input type="password" id="code" name="code" required>
											</td>
										</tr>
										<tr>
											<td colspan=2 style="padding:0px 10px 0px 10px">
											<hr>
											</td>
										</tr>
										<tr>
								  			<td colspan=2>
								  				<h6><i>Captcha</i></h6>
								  				
								  			</td>
								  		</tr>
										<tr>
										<td colspan = 2 style="padding:10px 10px 10px 10px;width:120px;background-color:#ffeb99;border-radius:5px" >
											<table width="100%">
											<tr>
												<td style="padding:10px 10px 10px 10px; background-color:white; width:50%">
												<p id="captchacode" align="center" style="font-size:26px"></p>
												<i style="float:right; cursor:pointer" class="icon icon-refresh" onclick="captcha()"></i>
												</td>
												<td style="padding:10px 10px 10px 10px;  width:50%">
												<i>Enter the captcha</i><br>
												<input type="text" id="captcha" name="captcha" required>
												</td>
											</tr>
											</table>
										</td>
										</tr>
										<tr>
										<td id = "error" colspan=2 style="padding:10px 10px 10px 10px;">
										</td>
										</tr>
										<tr>
											<td style="padding:10px 10px 10px 10px">
												<table>
													<tr>
														<td style="padding-top:10px"><a href="my-plan-regular.jsp" class="btn btn-inverse">Cancel</a></td>
														<td><input type="button" name="payMonthlyDue"class="btn btn-danger" value="Confirm Payment" onclick="validate()"></td>
													</tr>
												</table>
											</td>
										</tr>
								  		
							  		</table>
		                		</form>
		                		
                			</td>
                			</form>
                	  	</tr>
                	  </table>
                		
					  </div>
					</div>

				</div>	
			</div>
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

  <!-- Template Custom JavaScript File -->
  <script src="js/custom.js"></script>
  <script src="js/captcha.js"></script>

</body>

</html>
