import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleExample {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/ejbdb";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConnection = 
						DriverManager.getConnection(url,"root","root");
			//do something
			myConnection.close();
		}
		catch(java.lang.Exception ex) {
			ex.printStackTrace();
		}
	}

}
