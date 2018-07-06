package com.ipd12.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ipd12.model.Student;

@Controller
public class StudentController {

	@RequestMapping("/testParam")
	public ModelAndView showMessage5(@RequestParam("uname") String uname) {
		String message = "Response from testPararm " + uname;
		
		ModelAndView mv = new ModelAndView("result");
		mv.addObject("message", message);
		
		return mv;
	}
	
	@RequestMapping("/hello")
	public ModelAndView showMessage() {
		String message = "Response from Hello";
		
		ModelAndView mv = new ModelAndView("firstPage");
		mv.addObject("message", message);
		return mv;
	}
	
	//@Autowired
	//StudentManager sm;
	//Student sm;
	
	@RequestMapping("/getStudent")
	public ModelAndView getStudent() {
		
		File f = new File("/abc.txt");
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		f.exists();
		ApplicationContext context = new ClassPathXmlApplicationContext(
                "/WEB-INF/dispatcher-servlet.xml");
		Student sm = (Student) context.getBean("student");
		
//		String res = sm.callStudentManager();
		String res = sm.toString();
		
		ModelAndView mv = new ModelAndView("result2");
		mv.addObject("message", res);
		mv.addObject("message", res);
		return mv;
	}
}
