package com.jac.web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jac.web.model.Employee;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
                "META-INF/beans.xml");
        Employee emp = (Employee) context.getBean("employee");
        
        System.out.println(emp.toString());
	}

}
