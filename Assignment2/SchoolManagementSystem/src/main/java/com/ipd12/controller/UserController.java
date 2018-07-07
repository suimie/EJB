package com.ipd12.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ipd12.model.Student;

@Controller
public class UserController {
	@RequestMapping("/login")
	public ModelAndView loginSystem(@RequestParam("username") String username,
									@RequestParam("password") String password) {
		ModelAndView mv = null;
		if (username.equals("teacher")) {
			if(password.equals("teacher")) {
				mv = new ModelAndView("teacherIndex");
			}else {
				String error = "Password is wrong.";
				mv = new ModelAndView("login");
				mv.addObject("error", error);
			}
		}else {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("punit1");
			EntityManager em = emf.createEntityManager();
			
			Query query = em.createQuery("From Student where name=:name");
			query.setParameter("name", username);
			Student s = (Student)query.getSingleResult();
			
			if (s != null && s.getPassword().equals(password)) {
				mv = new ModelAndView("library");
			}else {
				String error = "Username or password is wrong.";
				mv = new ModelAndView("login");
				mv.addObject("error", error);				
			}
			
		}
		return mv;
	}
	
	@RequestMapping("/enter")
	public ModelAndView showMessage() {
		
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
}