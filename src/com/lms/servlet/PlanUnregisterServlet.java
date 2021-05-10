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
		
		User user = (User) session.getAttribute("loggedUser");
		String password = request.getParameter("pwd");
		boolean isTrue;

		isTrue = UserDBUtil.validate(user.getUsername(), password);
		
		if (isTrue == true) {
			
			if(PlanDBUtil.unregisterPlan(user)) {
				session.removeAttribute("loggedUser");
				session.removeAttribute("userPlan");

				User newuser = UserDBUtil.getUser(user.getUsername());
				Plan plan = PlanDBUtil.getUserPlan(newuser);
				
				session.setAttribute("userPlan", plan);
				session.setAttribute("loggedUser", newuser);
				
				out.println("<script type='text/javascript'>");
				out.println("alert('Successfully unregistered!');");
				out.println("location='my-plan-normal.jsp'");
				out.println("</script>");
			}
			else {
				out.println("<script type='text/javascript'>");
				out.println("alert('An unknown error has occured!');");
				out.println("location='unregister.jsp'");
				out.println("</script>");
			}
			
			
		} else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Your password is incorrect');");
			out.println("location='unregister.jsp'");
			out.println("</script>");
		}
	}

}
