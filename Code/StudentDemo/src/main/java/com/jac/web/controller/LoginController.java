package com.jac.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jac.web.dao.StudentDAO;
import com.jac.web.model.Student;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
				
		StudentDAO student = new StudentDAO();
		Student s1 = student.getStudent(username);
		System.out.println("Trying to login user with username " + username);

		if (password.equals(s1.getPassword())) {
			System.out.println("User logged in successfully with username " + username);

			request.setAttribute("username", username);
						
			request.setAttribute("student", s1);
			
			//RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
			//rd.forward(request, response);
			
			HttpSession session = request.getSession();
			session.setAttribute("user1", username);
			response.sendRedirect("welcome.jsp");
		}else {
			request.setAttribute("username", null);
			request.setAttribute("error",  "Wrong username or password.");
			
			//RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			//rd.forward(request, response);
			response.sendRedirect("index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("user1");
		session.invalidate();
		
		System.out.println("Loggin out, session removed.");
		response.sendRedirect("index.jsp");
	}

}
