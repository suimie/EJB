package dependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Drawing {
	
	private Shape shape;
	
	public Drawing(Shape shape) {
		System.out.println("Constructor");
		this.shape = shape;
	}
	
	public void setShape(Shape shape) {
		System.out.println("setter");
		this.shape = shape;
	}
	public void drawShape() {
		shape.draw();
	}
}
