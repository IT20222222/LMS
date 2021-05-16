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
		User user = (User) session.getAttribute("loggedUser");
		
		ArrayList<String> serv = new ArrayList<>();
		
		if(services != null) {
			for(int i = 0; i < services.length; i++) {
				serv.add(services[i]);
			}
		}
		
		
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
		
		monthlyPayment = PlanDBUtil.calculateMonthlyPayment(maxOrders, maxWeight, pressing, mending, oneday, dryclean, pickupDelivery);
		
		isTrue = PlanDBUtil.saveUserPlan(user, maxOrders, maxWeight, pressing, mending, oneday, dryclean, pickupDelivery, monthlyPayment);
		
		if (isTrue == true) {
				session.removeAttribute("userPlan");

				Plan plan = PlanDBUtil.getUserPlan(user);
				
				session.setAttribute("userPlan", plan);
				
				out.println("<script type='text/javascript'>");
				out.println("alert('Successfull!');");
				out.println("location='my-plan-regular.jsp'");
				out.println("</script>");

			
		} else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Error!');");
			out.println("location='my-plan-regular.jsp'");
			out.println("</script>");
		}
		
	}

}
