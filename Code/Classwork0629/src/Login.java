

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response content type
		response.setContentType("text/html");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println(username + " and " + password);
		String url = "jdbc:mysql://localhost:3306/ejbdb";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/ejbdb", "root", "root");
			String query = "select * from student where name=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, username);
			
			ResultSet rs = st.executeQuery();
			String result = "User not found";
			if(rs.next()) {
				String nameFromDB = rs.getString("name");
				String IDFromDB = rs.getString("studentId");
				
				result = "user found and details are "
						+ "\n Name: "+nameFromDB+" "
								+ "and \n ID: "+IDFromDB;
			}
			PrintWriter pw = response.getWriter();
			pw.write("<html>\r\n" + 
					"<head>\r\n" + 
					"<title>Result page</title>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" +
					result+
					"</body>\r\n" + 
					"</html>");
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
