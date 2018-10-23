package ua.my;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Servlet implementation class DataBaseServlet
 */
@WebServlet("DataBase")
public class DataBaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/test"
									    + "?useUnicode=true"
							            + "&useJDBCCompliantTimezoneShift=true"
							            + "&useLegacyDatetimeCode=false"
							            + "&serverTimezone=UTC";
    static final String DATABASE_USER = "root";
    static final String DATABASE_PASSWORD = "1";
    static final String GET_ALL_DEVELOPERS_RECORDS = "SELECT * FROM developers";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String title = "Database";
        String docType = "<!DOCTYPE html>";
        
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connection success.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(GET_ALL_DEVELOPERS_RECORDS);

            writer.println(docType + "<html><head><title>" + title + "</title></head><body>");
            writer.println("<h1>DEVELOPERS DATA</h1>");
            writer.println("<br/>");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String specialty = resultSet.getString(4);
                int experience = resultSet.getInt(5);
                int salary = resultSet.getInt(6);


                writer.println("ID: " + id);
                writer.println("First name: " + firstName + "<br/>");
                writer.println("Last name: " + lastName + "<br/>");
                writer.println("Specialty: " + specialty + "<br/>");
                writer.println("Experience: " + experience + " years<br/>");
                writer.println("Salary: $" + salary + "<br/>");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        writer.println("</body></html>");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}