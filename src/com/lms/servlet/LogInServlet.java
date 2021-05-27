package com.lms.servlet;

import com.lms.util.*;
import com.lms.model.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar; 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import javax.servlet.*;
/**
 * Servlet implementation class LogInControl
 */
@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String userName = request.getParameter("usr");	//read entered username
		String password = request.getParameter("pwd");	//read entered password
		boolean isTrue;
		
		UserInterface UserInterface = new UserDBUtil();
		IPlan PlanInterface = new PlanDBUtil();
		IOrder OrderInterface = new OrderDBUtil();
		IMonthlyPayment MonthlyPaymentInterface = new MonthlyPaymentDBUtil();
		
		isTrue = UserInterface.validate(userName, password);	//validate username and passowrd
		
		//check if the user is valid or not
		if (isTrue == true) {
			User user = UserInterface.getUser(userName);	//get user's details from db
			Plan plan = PlanInterface .getUserPlan(user);	//get user's plan details from db

	
			HttpSession session = request.getSession();
			
			session.setAttribute("loggedUser", user);	//set logged user attribute
			session.setAttribute("userPlan", plan);	//set user plan attribute
			
			//checks if the user is a regular user
			if(plan.getPlanId() == 2) {
				ArrayList<MonthlyPayment> mp = MonthlyPaymentInterface.getMonthlyPaymentHistory(user);	//get monthly payment details from db
				session.setAttribute("mpHistory", mp);	//set monthly payment history attribute
			}
			
		    ArrayList<Order> orderHistory = OrderInterface.getOrderHistory(user);	//get user's order history from db
			session.setAttribute("ordHistory", orderHistory); //set order hsitory attribute
			
			 Date date = Calendar.getInstance().getTime(); //get current date time 
             DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");  //get the current year & month
             String strDate = dateFormat.format(date); //convert the date to a string object
             
			session.setAttribute("date", strDate);	//set current date as an session attribute
			
			response.sendRedirect("dashboard-normal.jsp");	//redirect user to dashboard page
			
			
			
			
			
		} else {
			//display error message
			out.println("<script type='text/javascript'>");
			out.println("alert('Your username or password is incorrect');");
			out.println("location='Login.jsp'");
			out.println("</script>");
		}
	}

}
