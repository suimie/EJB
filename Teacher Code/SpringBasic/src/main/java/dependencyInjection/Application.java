package dependencyInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	public static void main(String[] args) {
		/*Drawing d1 = new Drawing();
		d1.setShape(new Triangle());
		d1.drawShape();
		
		d1.setShape(new Circle());
		d1.drawShape();*/
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
                "META-INF/beans.xml");
       // BeanFactory factory = context;
        Drawing test = (Drawing) context.getBean("drawing");
        test.drawShape();
		/*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	      Drawing shape = context.getBean(Drawing.class);
	      shape.drawShape();
	      context.close();*/
	}
}
