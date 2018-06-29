

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.Student;
/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response content type
		response.setContentType("text/html");
		
		String username = request.getParameter("user");
		String password = request.getParameter("password");
		
		String result = "(From Servlet)Your username and password is : " + username + " - " + password;
		// Actual logic goes here.
		PrintWriter out = response.getWriter();
		out.write("<h1>Hello World</h1>");
		//System.out.println("Sending response");
		
		out.write("<h2>" + result + "</h2>");
		
		request.setAttribute("user", username);
		request.setAttribute("password", password);
		
		// test2.jsp target JSP page
		RequestDispatcher rd = request.getRequestDispatcher("test2.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("id"));
		
		Student student = new Student();
		student.setName(name);
		student.setStudentID(id);
		
		// save to text file
		request.setAttribute("std",  student);;
		RequestDispatcher rd = request.getRequestDispatcher("viewStudent.jsp");
		
		rd.forward(request, response);
	}

}
