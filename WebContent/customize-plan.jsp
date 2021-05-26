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
  <title>Customize Plan</title>
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
              <h1><a href="index.html"><i class="icon-tint"></i> WonderLaundry</a></h1>
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
              <h2>Customize Plan <span  class="icon-edit"></span></h2> 
            </div>
          </div>
          <div class="span8">
            <ul class="breadcrumb">
              <li><a href="index.jsp">Home</a> <i class="icon-angle-right"></i></li>
              <li><a href="my-plan.jsp">My Plan</a> <i class="icon-angle-right"></i></li>
              <li class="active">Customize Plan</li>
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
					  <tr><td class="form">
					  <form action="saveUserPlan" method="post">
					  <br>
					  <h4>Your Plan</h4>
					  <table>
					  <tr>
					  	<td style="background-color:white;padding:10px 10px 0px 0px">
						  	Maximum orders for a month:<br>
							<select name="maxOrders">
							<%!String printMaxOrders(RegularPlan plan){
								String maxOrders = new String("");
								int i;
								for(i = 1; i<=20; i++){
									if(i == plan.getMaxOrders()){
										maxOrders += "<option value='"+i+"' selected>"+i+"</option>";
									}
									else{
										maxOrders += "<option value='"+i+"'>"+i+"</option>";
									}
								}
								return maxOrders;
								} %>
							  <%= printMaxOrders(plan) %>
							</select>
						</td>
						<td style="background-color:white;padding:10px 0px 0px 10px">
							Maximum weight for an order (KG):<br>
							<select name="maxWeight">
							<%!String printMaxWeight(RegularPlan plan){
								String maxWeight = new String("");
								int i;
								for(i = 1; i<=10; i++){
									if(i == plan.getMaxWeight()){
										maxWeight += "<option value='"+i+"' selected>"+i+"</option>";
									}
									else{
										maxWeight += "<option value='"+i+"'>"+i+"</option>";
									}
								}
								return maxWeight;
								}
							 %>
							  <%= printMaxWeight(plan) %>
							</select>
						</td>
						</tr>
						</table>
						<br>
						<b>Select Services You Want</b>
						<br>
						<table class="table table-bordered" >
						<tr><th >Service</th><th></th></tr>
						<%!String printServices(RegularPlan plan){
							String services = new String("");
							
							if(plan.getAvailableServices().get("pressing") == "Yes"){
								services += "<tr><td>Pressing</td><td><input type='checkbox' name='services' value='press' checked></td></tr>";
							} else {
								services += "<tr><td>Pressing</td><td><input type='checkbox' name='services' value='press'></td></tr>";
							}

							if(plan.getAvailableServices().get("dryclean") == "Yes"){
								services += "<tr><td>Dry Cleaning</td><td><input type='checkbox' name='services' value='dryclean' checked></td></tr>";
							} else {
								services += "<tr><td>Dry Cleaning</td><td><input type='checkbox' name='services' value='dryclean'></td></tr>";
							}

							if(plan.getAvailableServices().get("mending") == "Yes"){
								services += "<tr><td>Mending Service</td><td><input type='checkbox' name='services' value='mending' checked></td></tr>";
							} else {
								services += "<tr><td>Mending Service</td><td><input type='checkbox' name='services' value='mending'></td></tr>";
							}
					
							if(plan.getAvailableServices().get("pickupDelivery") == "Yes"){
								services += "<tr><td>Pickup & Delivery</td><td><input type='checkbox' name='services' value='pickupDelivery' checked></td></tr>";
							} else {
								services += "<tr><td>Pickup & Delivery</td><td><input type='checkbox' name='services' value='pickupDelivery'></td></tr>";
							}
							
							if(plan.getAvailableServices().get("oneday") == "Yes"){
								services += "<tr><td>One Day Service</td><td><input type='checkbox' name='services' value='oneday' checked></td></tr>";
							} else {
								services += "<tr><td>One Day Service</td><td><input type='checkbox' name='services' value='oneday'></td></tr>";
							}
							
							return services;
							} %>
						<%= printServices(plan) %>
						</table>
						<br>
						<div class="accordion" id="accordion2">
							<div class="accordion-group">
			                    <div class="accordion-heading">
			                      <a class="CustomizePlanAccordion accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
											<i class="icon-minus"></i> Pressing </a>
			                    </div>
			                    <div id="collapseOne" class="accordion-body collapse in">
			                      <div class="accordion-inner">
			                        Our steam Pressing Service will give the perfect finished look to<br>your clothes.Not only are your clothes pressed well, 
			                        using some<br> of the best equipment, 
			                        but they are also carefully packed using <br>supporting add-ons so that their finished shape and form are <br>retained.
			                      </div>
			                    </div>
		                  	</div>
		                  	<div class="accordion-group">
			                    <div class="accordion-heading">
			                      <a class="CustomizePlanAccordion accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo">
											<i class="icon-plus"></i> Dry Cleaning </a>
			                    </div>
			                    <div id="collapseTwo" class="accordion-body collapse">
			                      <div class="accordion-inner">
			                        Our Dry Cleaning Service is a solvent based washing process, <br>
			                        which utilizes advanced chemistry to remove organic & inorganic<br>
			                        stains. When it comes to soil removal, our Dry Cleaning Service <br>
			                        is one of our most effective cleaning options.
			                     
			                      </div>
			                    </div>
			                  </div>
			                  <div class="accordion-group">
			                    <div class="accordion-heading">
			                      <a class="CustomizePlanAccordion accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseThree">
											<i class="icon-plus"></i> Mending Service </a>
			                    </div>
			                    <div id="collapseThree" class="accordion-body collapse">
			                      <div class="accordion-inner">
			                       We offer our clients basic Mending Services for their garments<br>
			                       on a selective basis.
			                     
			                      </div>
			                    </div>
			                  </div>
			                  <div class="accordion-group">
			                    <div class="accordion-heading">
			                      <a class="CustomizePlanAccordion accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseFour">
											<i class="icon-plus"></i> Pickup & Delivery </a>
			                    </div>
			                    <div id="collapseFour" class="accordion-body collapse">
			                      <div class="accordion-inner">
			                       We offer a Pick-Up and Delivery service! We want to make your<br>
			                       life easier by offering an inclusive service and keep you from<br>
			                       running around the city for different chores.
			                     
			                      </div>
			                    </div>
			                  </div>
			                  <div class="accordion-group">
			                    <div class="accordion-heading">
			                      <a class="CustomizePlanAccordion accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseFive">
											<i class="icon-plus"></i> One Day Service </a>
			                    </div>
			                    <div id="collapseFive" class="accordion-body collapse">
			                      <div class="accordion-inner">
			                       We provide One-Day Services for when you need that extra quick<br> cleaning.
			                     
			                      </div>
			                    </div>
			                  </div>
	                  	</div>
							<br>
							<table>
								<tr>
									<td style="padding-top:10px"><a href="my-plan-regular.jsp" class="btn btn-inverse">Cancel</a></td>
									<td><input type="submit" name="savePlan"class="SaveButton" value="Save"></td>
								</tr>
							</table>
                		</form>
                		</td></tr>
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


</body>

</html>
