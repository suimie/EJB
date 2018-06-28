

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CheckUsernamePassword")
public class CheckUsernamePassword extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response content type
		response.setContentType("text/html");
		
		String username1 = request.getParameter("username1");
		String password1 = request.getParameter("password1");
		String username2 = request.getParameter("username2");
		String password2 = request.getParameter("password2");
		
		String result = "";
		if (username1.equalsIgnoreCase(username2) && password1.equalsIgnoreCase(password2))
			result = "The data same - User 1 : " + username1 + " : " + password1 + "<br/>" + " User 2 : " + username2 + " : " + password2 + "<br/>";
		else
			result = "The information of user1 and user2 do not match!";
		
		// Actual logic goes here.
		PrintWriter out = response.getWriter();
		out.write("<h2>" + result + "</h2>");	}

}
