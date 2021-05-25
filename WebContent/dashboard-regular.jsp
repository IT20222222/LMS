<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.lms.model.User" %>
    <%@ page import="com.lms.model.Order" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.lms.model.Plan" %>
    <%@ page import="com.lms.model.MonthlyPayment" %>
    <%@ page import="com.lms.model.RegularPlan" %>
    <% User user = (User) session.getAttribute("loggedUser");
    RegularPlan plan = (RegularPlan) session.getAttribute("userPlan");
    ArrayList<Order> order = (ArrayList<Order>) session.getAttribute("ordHistory");
    String date = (String) session.getAttribute("date");
    
    if(user == null){%>
    	<jsp:forward page="Login.jsp"/>
    <%}else{
    	if(plan.isCustomizable() == false){
    		response.sendRedirect("dashboard-normal.jsp");
    	}
    	
    }
    
	%>
<!DOCTYPE html>
<html lang="en">



<head>
  <meta charset="utf-8">
  <title>Dashboard</title>
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
                    <li class="dropdown active"><a href="dashboard.jsp">Dashboard</a></li>
                    <li><a href="index.html">Place Order</a></li>
                    <li><a href="my-plan-normal.jsp">My Plan</a></li>
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
              <h2>Dashboard <span  class="font-icon-dashboard"></span></h2>
            </div>
          </div>
          <div class="span8">
            <ul class="breadcrumb">
              <li><a href="index.jsp">Home</a> <i class="icon-angle-right"></i></li>
              <li class="active">Dashboard</li>
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
						<h4>Summary (this month)</h4>
							<div id="summary">
			                  <table border="0px" width = "100%" >
				                   <tr>
				                  	  <td style="background-color:#add8e6;border-radius: 15px;border:5px solid #F5F5F5;padding-bottom:10px;padding-right:10px;padding-top:10px" width="25%">
					                  <h6 style="padding-left:10px;color:#4682b4">Your Plan</h6>
					                  <p style="font-size:36px;padding-left:10px;padding-bottom:10px;color:#4682b4" name="totOrders">
					                  <b>
					                  Regular User
					                  </b>
					                  </p>
					                  </td>
					                  <td style="background-color:#90ee90;border-radius: 15px;border:5px solid #F5F5F5;padding-bottom:10px;padding-right:10px;padding-top:10px" width="25%">
					                  <h6 style="padding-left:10px;color:#008000">Total Orders</h6>
					                  <p style="font-size:48px;padding-left:10px;padding-bottom:10px;color:#008000" name="totOrders"><b>
					                  <%! int getTotalOrders (ArrayList<Order> ord, String date) {
					                	  int total = 0;
					                	  
					                	  for(Order order : ord) {
					                		  if(order.getMonth().equals(date)) {
					                			  total++;
					                		  }
					                	  }
					                	  return total;
					                  }
					                  %>
					                  
					                  <%= getTotalOrders(order, date) %>
					                  </b></p>
					                  </td>
					                  
					                  <td style="background-color:#f5da50;border-radius: 15px;border:5px solid #F5F5F5;padding-bottom:10px;padding-right:10px;padding-top:10px">
					                  <h6 style="padding-left:10px;color:#daa520">Remaining Orders</h6>
					                  <p style="font-size:48px;padding-left:10px;padding-bottom:10px;color:#daa520" name="totOrders"><b><%= plan.getMaxOrders() - getTotalOrders(order, date) %></b></p>
					                  </td>
					                  <td style="background-color:#f08080;border-radius: 15px;border:5px solid #F5F5F5;padding-bottom:10px;padding-right:10px;padding-top:10px" width="25%">
					                  <h6 style="padding-left:10px;color:#b22222">Monthly Payment</h6>
					                  <p style="font-size:48px;padding-left:10px;padding-bottom:10px;color:#b22222" name="totOrders"><b>LKR <%= plan.getMonthlyPayment() %></b></p>
					                  </td>
					                  
				                  </tr>
			                  </table>
			                </div>
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
						<h4>Order History</h4>
							<div id="OrderHistory">
							                <table class="table">
							                  <thead>
							                  
							                    <tr>
							                      <th>
							                        #
							                      </th>
							                      <th>
							                        Date
							                      </th>
							                      <th>
							                        Payment (LKR)
							                      </th>
							                      <th>
							                        Status
							                      </th>
							                    </tr>
							                  </thead>
							                  <tbody>
							                  	<%!  String printTable(ArrayList<Order> orderHistory){
											    	String table = new String("");
											    	int i = 1;
											    	for(Order order : orderHistory){
											    		if (order.getStatus().equals("Completed")) {
											    			table += "<tr class='success'>";
											    		}
											    		else if (order.getStatus().equals("In Progress")) {
											    			table += "<tr class='warning'>";
											    		}
											    		else if (order.getStatus().equals("Cancelled")) {
											    			table += "<tr class='error'>";
											    		}
											    		
											    		table += "<td>"+i+"</td><td>"+order.getDate()+"</td><td>"+order.getPayment()+"</td>";
											    		table += "<td>"+order.getStatus()+"</td></tr>";
														
											    		i++;
											    	}
											    	return table;
										         } %>
										         <%= printTable(order)%>
							                  </tbody>
							                </table>
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
