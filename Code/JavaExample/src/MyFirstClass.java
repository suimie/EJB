
public class MyFirstClass {

	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setId(101);
		emp.setName("Hello World!");
		
		System.out.println(emp.getId() + " and " + emp.getName());
	}
}


