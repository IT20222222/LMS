<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.lms.model.User" %>
    <%@ page import="com.lms.model.Plan" %>
    <%@ page import="com.lms.model.MonthlyPayment" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.lms.model.RegularPlan" %>
    <% User user = (User) session.getAttribute("loggedUser");
       RegularPlan plan = (RegularPlan) session.getAttribute("userPlan");
       ArrayList<MonthlyPayment> mph = (ArrayList<MonthlyPayment>) session.getAttribute("mpHistory");
       
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
  <title>My Plan</title>
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
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="dashboard-regular.jsp">Dashboard</a></li>
                    <li><a href="index.html">Place Order</a></li>
                    <li class="dropdown active"><a href="my-plan-regular.jsp">My Plan</a></li>
                    <li><a href="index.html">My Account</a></li>
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
              <h2>My Plan  <span  class="font-icon-file"></span></h2>
            </div>
          </div>
          <div class="span8">
            <ul class="breadcrumb">
              <li><a href="index.html">Home</a> <i class="icon-angle-right"></i></li>
              <li class="active">My Plan</li>
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
						<h4>Details</h4>
							<table class="table table-bordered">
			                  <tbody>
			                  	<tr>
			                  		<td><b>Type</b></td>
			                  		<td><%= plan.getPlanName() %></td>
			                  	</tr>
			                  	<tr>
			                  		<td><b>Maximum orders for a month</b></td>
			                  		<td><%= plan.getMaxOrders() %></td>
			                  	</tr>
			                  	<tr>
			                  		<td><b>Maximum weight for an order (KG)</b></td>
			                  		<td><%= plan.getMaxWeight() %></td>
			                  	</tr>
			                  	<tr>
			                  		<td><b>Monthly Payment (LKR)</b></td>
			                  		<td><%= plan.getMonthlyPayment() %></td>
			                  	</tr>
			                  	<tr>
			                  		<td colspan=2 style="background-color:whitesmoke;"><center><b>Available Services</b></center></td>
			                  	</tr>
			                  	<tr>
			                  		<td style="background-color:whitesmoke;"><b>Service</b></td>
			                  		<td style="background-color:whitesmoke;"><b>Availability</b></td>
			                  	</tr>
			                  	<tr>
			                  		<td><b>Pressing</b></td>
			                  		<td><%= plan.getAvailableServices().get("pressing") %></td>
			                  	</tr>
			                  	<tr>
			                  		<td><b>Dry Cleaning</b></td>
			                  		<td><%= plan.getAvailableServices().get("dryclean") %></td>
			                  	</tr>
			                  	<tr>
			                  		<td><b>Mending Service</b></td>
			                  		<td><%= plan.getAvailableServices().get("mending") %></td>
			                  	</tr>
			                  	<tr>
			                  		<td><b>Pickup & Delivery</b></td>
			                  		<td><%= plan.getAvailableServices().get("pickupDelivery") %></td>
			                  	</tr>
			                  	<tr>
			                  		<td><b>One Day Service</b></td>
			                  		<td><%= plan.getAvailableServices().get("oneday") %></td>
			                  	</tr>
			                  </tbody>
                			</table>
                			<a href="unregister.jsp" class="btn btn-danger">Unregister</a>
                			<a href="customize-plan.jsp" class="btn btn-primary"><i class="icon-cog icon-white"></i> Customize</a>
					  </div>
					</div>

					<!-- divider -->
					<div class="row">
					  <div class="span12">
						<div class="solidline"></div>
					  </div>
					</div>
					
					<div class="row">
					  <div class="span12">
						<h4>Monthly Payment History</h4>
							<div id="paymentHistory">
							                <table class="table">
							                  <thead>
							                  
							                    <tr>
							                      <th>
							                        #
							                      </th>
							                      <th>
							                        Month
							                      </th>
							                      <th>
							                        Date
							                      </th>
							                      <th>
							                        Amount (LKR)
							                      </th>
							                      <th>
							                        Status
							                      </th>
							                    </tr>
							                  </thead>
							                  <tbody>
							                  	<%!  String printTable(ArrayList<MonthlyPayment> mph){
											    	String table = new String("");
											    	int i = 1;
											    	for(MonthlyPayment mp : mph){
											    		table += "<tr class='success'><td>"+i+"</td><td>"+mp.getMonth()+"</td><td>"+mp.getDate()+"</td><td>"+mp.getAmount()+"</td><td>"+mp.getStatus()+"</td></tr>";
														
											    		i++;
											    	}
											    	return table;
										         } %>
							                  <%= printTable(mph)%>
							                  </tbody>
							                </table>
							                <a href="monthly-payment.jsp" class="btn btn-danger"><i class=" icon-credit-card icon-white"></i> Pay Monthly Due</a>
			                </div>
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


</body>

</html>
