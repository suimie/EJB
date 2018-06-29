package DBTest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class Database {
	private Connection conn;
	
	public Database() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/ejbdb";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,"root","root");
			//do something
			//myConnection.close();
		}
		catch(java.lang.Exception ex) {
			ex.printStackTrace();
		}
	}
	public Database() throws SQLException {
        conn = DriverManager.getConnection(
                "jdbc:mysql://" + HOSTNAME + "/" + DBNAME,
                USERNAME, PASSWORD);
    }
	
	public Connection getConnection() {
		return conn;
	}
	
	public void closeConnection() throws SQLException {
		conn.close();
	}
	
	
	public boolean isOk(String username, String password) {
		String query= "Select * FROM student WHERE name='" + username + "' AND password='" + password + "'";
		
		
		try (Statement stmt = conn.createStatement()) {
            ResultSet result = stmt.executeQuery(query);
            if (result.next()) {
                count = result.getInt(1);

                return count;
            } else {
                return 0;
            }
        }
		
		
		
		
		
		
		Statement myStatement = conn.createStatement();
		
		ResultSet rs = myStatement.executeQuery(query);
		
		while(rs.next()){
			String sid = rs.getString(1);//getting first column.
			String sname = rs.getString(2);
			System.out.println(“Student name ” + sname + “ with id ” + sid );
		}
		
		myStatement.close();


		closeConnection();

	}
}