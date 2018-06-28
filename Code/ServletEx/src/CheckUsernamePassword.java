

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckUsernamePassword
 */
@WebServlet("/CheckUsernamePassword")
public class CheckUsernamePassword extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response content type
		response.setContentType("text/html");
		
		String username = request.getParameter("user");
		String password = request.getParameter("password");
		
		String result = "";
		if (username.equalsIgnoreCase(password))
			result = "Your username and password is : " + username + " - " + password;
		else
			result = "Username and password do not match!";
		
		// Actual logic goes here.
		PrintWriter out = response.getWriter();
		out.write("<h1>Hello World</h1>");
		//System.out.println("Sending response");
		
		out.write("<h2>" + result + "</h2>");	}

}
