package DBTest;
import java.sql.*;;

class SimpleExample {
	public static void main(String args[]) {
		String url = "jdbc:mysql://localhost:3306/ejbdb";
		try {
			Class.forName("ejbdb");
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

