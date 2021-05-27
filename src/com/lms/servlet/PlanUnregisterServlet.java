package com.lms.servlet;

import com.lms.util.*;
import com.lms.model.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;


/**
 * Servlet implementation class PlanUnregisterServlet
 */
@WebServlet("/PlanUnregisterServlet")
public class PlanUnregisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		
		IPlan PlanInterface = new PlanDBUtil();
		UserInterface UserInterface = new UserDBUtil();
		
		User user = (User) session.getAttribute("loggedUser");	//get logged user
		String password = request.getParameter("pwd");	//get entered password
		boolean isTrue;

		isTrue = UserInterface.validate(user.getUsername(), password);	//validate password
		
		//check if password is valid or not
		if (isTrue == true) {
			
			//unregisters the user from his/her current plan and checks if it was successful
			if(PlanInterface.unregisterPlan(user)) {
				session.removeAttribute("loggedUser");	//remove user attribute
				session.removeAttribute("userPlan");	//remove user plan attribute

				User newuser = UserInterface.getUser(user.getUsername());	//get new user details from db
				Plan plan = PlanInterface.getUserPlan(newuser);	//get new plan details from db
				
				session.setAttribute("userPlan", plan); //set plan attribute
				session.setAttribute("loggedUser", newuser);	//set logged user
				
				//display success message
				out.println("<script type='text/javascript'>");
				out.println("alert('Successfully unregistered!');");
				out.println("location='my-plan-normal.jsp'");
				out.println("</script>");
			}
			else {
				//display error message
				out.println("<script type='text/javascript'>");
				out.println("alert('An unknown error has occured!');");
				out.println("location='unregister.jsp'");
				out.println("</script>");
			}
			
			
		} else {
			//display password incorrect message
			out.println("<script type='text/javascript'>");
			out.println("alert('Your password is incorrect');");
			out.println("location='unregister.jsp'");
			out.println("</script>");
		}
	}

}
