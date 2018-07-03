

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;


/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ejbdb?" +
                    "user=root&password=root");
			
			String query = "SELECT * FROM classwork0629 WHERE username='" +
					username + "' AND '" + password + "'";
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			
			ResultSet rs = st.executeQuery();
			String result = "User not found";
			
			if(rs.next()) {
				result = "You are logged in successfully!";
			}
			
			PrintWriter pw = response.getWriter();
			pw.write("<html>\r\n" + 
					"<head>\r\n" + 
					"<meta charset=\"EUC-KR\">\r\n" + 
					"<title>You are logged in successfully!</title>\r\n" + 
					"\r\n" + 
					"<style>\r\n" + 
					"	body{\r\n" + 
					"		width:600px;\r\n" + 
					"		margin:auto;\r\n" + 
					"	}\r\n" + 
					"	td {\r\n" + 
					"		padding:20px;\r\n" + 
					"	}\r\n" + 
					"</style>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"	<h1>Welcome to JAC World!</h1>\r\n" + 
					result + 
					"	\r\n" + 
					"</body>\r\n" + 
					"</html>");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
