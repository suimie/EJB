package test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class MainApp {

	public static void main(String[] args) {
		//BeanFactory factory ;
		
		//ClassPathResource cpr = new ClassPathResource("META-INF/beans2.xml");
		//factory = new XmlBeanFactory(cpr);
		
		//Resource res = new FileSystemResource("META-INF/beans2.xml");
		//factory = new XmlBeanFactory(res);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/beans2.xml");

		Employee emp = (Employee) context.getBean("emp");
		System.out.println(emp);
	}
}
