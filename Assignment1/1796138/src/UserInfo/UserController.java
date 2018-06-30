package UserInfo;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response content type
		response.setContentType("text/html");
		
		String tmp = request.getParameter("userId");
		int userId = Integer.parseInt(request.getParameter("userId"));
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		String zipcode = request.getParameter("zipcode");
		
		User user = new User();
		user.setUserID(userId);
		user.setUserName(userName);
		user.setPassword(password);
		user.setEmail(email);
		user.setCity(city);
		user.setZipcode(zipcode);
		
		writeUserInfoToFile(user);
		
		User userFromFile = readUserInfoFromFile();
		
		request.setAttribute("userdata",  userFromFile);
		RequestDispatcher rd = request.getRequestDispatcher("viewUserData.jsp");
		
		rd.forward(request, response);
	}

	private void writeUserInfoToFile(User user) {
		BufferedWriter writer = null;
        try {
            //File userdata = new File("../../JAC/EJB/Assignment1/1796138/data/userdata.txt");

        	File userdata = new File("../userdata.txt");
            System.out.println(userdata.getAbsolutePath());

            writer = new BufferedWriter(new FileWriter(userdata));
            
            writer.write(user.getUserID() + "");
            writer.newLine();
            writer.write(user.getUserName());
            writer.newLine();            
            writer.write(user.getPassword());
            writer.newLine();
            writer.write(user.getEmail());
            writer.newLine();
            writer.write(user.getCity());
            writer.newLine();
            writer.write(user.getZipcode());
            writer.newLine();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
            	e.printStackTrace();
            }
        }
	}
	
	private User readUserInfoFromFile() {
		User user = new User();
		
		BufferedReader reader = null;
		try {
			//reader = new BufferedReader(new FileReader("../../JAC/EJB/Assignment1/1796138/data/userdata.txt"));
			reader = new BufferedReader(new FileReader("../userdata.txt"));
		    StringBuilder sb = new StringBuilder();
		    String line = reader.readLine();

		    int i = 0;
		    while (line != null) {
		    	switch(i) {
		    	case 0:
		    		user.setUserID(Integer.parseInt(line));
		    		break;
		    	case 1:
		    		user.setUserName(line);
		    		break;
		    	case 2:
		    		user.setPassword(line);
		    		break;
		    	case 3:
		    		user.setEmail(line);
		    		break;
		    	case 4:
		    		user.setCity(line);
		    		break;
		    	case 5:
		    		user.setZipcode(line);
		    		break;
		    	}
		        line = reader.readLine();
		        i++;
		    }
		    
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
            } catch (Exception e) {
            	e.printStackTrace();
            }
		}
		
		return user;
	}
}
