package com.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.util.UserDBUtil;
import com.lms.util.UserInterface;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Defining and Initializing an object to get output to the screen.
		PrintWriter out = response.getWriter();
		
		//Retrieving user entered information
		String firstName = request.getParameter("Firstname");
		String lastName = request.getParameter("Lastname");
		String NIC = request.getParameter("NIC");
		String email = request.getParameter("Email");
		String address = request.getParameter("Address");
		String gender = request.getParameter("gender");
		int  MobileNumber = Integer.parseInt(request.getParameter("mobile"));
		String DOB = request.getParameter("dob");
		String username = request.getParameter("username");
		String password = request.getParameter("Password");
		
		//Checking whether the entered username already exists, if existing display an error message.
		UserInterface UserInterface = new UserDBUtil();
		boolean exists = UserInterface.validateUsername(username);
		if (exists == false) {
			out.println("<script type='text/javascript'>");
			out.println("alert('Username already exists , please enter a different username');");
			out.println("</script>");  
		}
		else { 
			//If the User-name is valid , add the user to the database.
			boolean isTrue;
			isTrue = UserInterface.addUser(firstName , lastName , NIC , email , address , gender , MobileNumber , DOB , username , password , 1);
		
				if (isTrue == true) {
					RequestDispatcher dis = request.getRequestDispatcher("Login.jsp");			//Redirect to the Login page upon successful registration
				    dis.forward(request, response);	
					
						}
				else {
						RequestDispatcher dis = request.getRequestDispatcher("Unsuccess.jsp");
						dis.forward(request,response);
						}
		
		
			}

	}
	
}
