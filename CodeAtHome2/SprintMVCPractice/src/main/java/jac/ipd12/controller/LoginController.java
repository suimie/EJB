package jac.ipd12.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jac.ipd12.model.Student;

@Controller
public class LoginController {
	@RequestMapping("/loginpage")
	public ModelAndView loginPage(@RequestParam("error") String error) 
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView("login");
		if(error != null && !error.equals("")) {
			mv.addObject("error", error);
		}
		
		
		return mv;
	}
	
	@RequestMapping("/login")
	public void loginSystem(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (username == null || username.equals("") ||
				password == null || password.equals("")) {
			HttpSession session = request.getSession();
			session.setAttribute("username", null);

			String error = "Username or password are not correct!";
			request.setAttribute("error", error);
			response.sendRedirect("index");
			return;
		}
			
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("punit1");
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("SELECT st FROM Student st WHERE st.username='" + username + "'");
		Student student = (Student)query.getSingleResult();
		
		em.close();
		emf.close();
		
		if (student == null || !student.getPassword().equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", null);

			String error = "Username or password are not correct!";
			request.setAttribute("error", error);
			response.sendRedirect("loginpage");
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect(request.getContextPath() + "/products");
		}
		
	}
}
