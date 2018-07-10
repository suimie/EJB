package com.ipd12.controller;

import java.io.IOException;
import java.util.List;

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

import com.ipd12.model.Book;
import com.ipd12.model.Student;

@Controller
public class UserController {
	@RequestMapping("/login")
	public ModelAndView loginSystem(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		
		String username = (String)request.getParameter("username");
		String password = (String)request.getParameter("password");
		
		ModelAndView mv = null;
		if (username.equals("teacher")) {
			if(password.equals("teacher")) {
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				
				mv = new ModelAndView("teacherIndex");
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("username", null);
				
				String error = "Password is not correct.";
				mv = new ModelAndView("login");
				mv.addObject("error", error);
			}
		}else {
			System.out.println(username);
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("punit1");
			EntityManager em = emf.createEntityManager();

			Query query = em.createQuery("SELECT st FROM Student st WHERE st.name='" + username + "'");
			List<Student> sList = (List<Student>)query.getResultList();
			
			em.close();
			emf.close();

			if (sList.size() > 0){
				Student s = (Student)sList.get(0);
				
				System.out.println(s);
				if (s != null && s.getPassword().equals(password)) {
					HttpSession session = request.getSession();
					session.setAttribute("username", username);

					response.sendRedirect(request.getContextPath() + "/library");
				}else {
					HttpSession session = request.getSession();
					session.setAttribute("username", null);

					String error = "Username or password is not correct.";
					mv = new ModelAndView("login");
					mv.addObject("error", error);				
				}
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("username", null);

				String error = "Username or password is not correct.";
				mv = new ModelAndView("login");
				mv.addObject("error", error);				
			}
			
		}
		return mv;
	}
	
	@RequestMapping("/enter")
	public ModelAndView showMessage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		
		ModelAndView mv = null;
		if (username == null) {
			mv = new ModelAndView("login");
			return mv;			
		}else if(username.equals("teacher")) {
			mv = new ModelAndView("teacherIndex");
			return mv;
		}else {
			response.sendRedirect(request.getContextPath() + "/library");
		}
	
		return mv;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("username", null);
		
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
}