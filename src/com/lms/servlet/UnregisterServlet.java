package com.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lms.model.User;
import com.lms.util.UserDBUtil;


@WebServlet("/UnregisterServlet")
public class UnregisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Deleting the user information by passing the ID of the logged in user to the Database Util after checking for correct credentials.
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loggedUser");
		int id = user.getId();
		
		//Checking whether the credentials given are correct to process deletion.
		
		String username = request.getParameter("username");
		String password = request.getParameter("Password");
		boolean credentials = UserDBUtil.validate(username, password);
		
		if(credentials == true) {  //If credentials are correct , the deletion will take place.
			
			boolean isTrue = UserDBUtil.DeleteUser(id);
			
			if(isTrue == true) {
				RequestDispatcher dis1 = request.getRequestDispatcher("Success.jsp");
				dis1.forward(request, response);
			}
			else {
				RequestDispatcher dis2 = request.getRequestDispatcher("Unsuccess.jsp");
				dis2.forward(request, response);
			}
		}
		
		//If credentials are wrong display a message.
		else {
			out.print("<script type = 'text/javascript'>");
			out.print("alert('Your Password or Username is incorrect.');");
			out.print("location = 'Unregister_Profile.jsp'");
			out.print("</script>");
		}
		
		
	}

}
