package com.lms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.lms.model.User;
import com.lms.util.UserDBUtil;
import com.lms.util.UserInterface;
/**
 * Servlet implementation class ProfileCancellationServlet
 */
@WebServlet("/ProfileCancellationServlet")
public class ProfileCancellationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loggedUser");
		
		int mobileNo = user.getMobileNo();
		String username = user.getUsername();
		String email = user.getEmail();
		String reason = request.getParameter("reason");
		String description = request.getParameter("description");
		
		UserInterface UserInterface = new UserDBUtil();
		boolean isTrue = UserInterface.setCancellationDetails(mobileNo , username , email , reason , description);
		
		if (isTrue = true) {
			
		}
	}

}
