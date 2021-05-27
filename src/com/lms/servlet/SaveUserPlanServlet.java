package com.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lms.model.Plan;
import com.lms.model.User;
import com.lms.util.IPlan;
import com.lms.util.PlanDBUtil;
import com.lms.util.UserDBUtil;

/**
 * Servlet implementation class SaveUserPlanServlet
 */
@WebServlet("/SaveUserPlanServlet")
public class SaveUserPlanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		
		IPlan PlanInterface = new PlanDBUtil();
		
		//read selected options/ features
		String[] services = request.getParameterValues("services");
		int maxOrders = Integer.parseInt(request.getParameter("maxOrders"));
		int maxWeight = Integer.parseInt(request.getParameter("maxWeight"));
		int pressing = 0;
		int mending = 0;
		int dryclean = 0;
		int oneday = 0;
		int pickupDelivery = 0;
		double monthlyPayment = 0;
		boolean isTrue;
		User user = (User) session.getAttribute("loggedUser");	//get logged user
		
		ArrayList<String> serv = new ArrayList<>();	//create an array list
		
		//check if at least one service is selected
		if(services != null) {
			for(int i = 0; i < services.length; i++) {
				serv.add(services[i]);	//add selected services to an array list
			}
		}
		
		//check which services are selected
		if(serv.contains("press")) {
			pressing = 1;
		}
		if(serv.contains("dryclean")) {
			dryclean = 1;
		}
		if(serv.contains("mending")) {
			mending = 1;
		}
		if(serv.contains("oneday")) {
			oneday = 1;
		}
		if(serv.contains("pickupDelivery")) {
			pickupDelivery = 1;
		}
		
		//calculate monthly payment according to the selected services
		monthlyPayment = PlanInterface.calculateMonthlyPayment(maxOrders, maxWeight, pressing, mending, oneday, dryclean, pickupDelivery);
		
		//save user's new plan 
		isTrue = PlanInterface.saveUserPlan(user, maxOrders, maxWeight, pressing, mending, oneday, dryclean, pickupDelivery, monthlyPayment);
		
		if (isTrue == true) {
				session.removeAttribute("userPlan");	//remove user plan attribute

				Plan plan = PlanInterface.getUserPlan(user);	//get user's new plan details from the db
				
				session.setAttribute("userPlan", plan);	//set new plan attribute
				
				//display success message
				out.println("<script type='text/javascript'>");
				out.println("alert('Successfull!');");
				out.println("location='my-plan-regular.jsp'");
				out.println("</script>");

			
		} else {
			//display error message
			out.println("<script type='text/javascript'>");
			out.println("alert('Error!');");
			out.println("location='my-plan-regular.jsp'");
			out.println("</script>");
		}
		
	}

}
