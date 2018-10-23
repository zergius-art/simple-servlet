package ua.my;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleServlet.
 * To make it "Welcome Page" annotation WebServlet
 * has no name. So this Servlet wil start first.
 */
@WebServlet("")
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Shows current time and reference to Login Page
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setIntHeader("Refresh", 1);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html><head>");
		out.print("<title>Welcome Page</title>");
		out.print("</head><body>");
		out.print("It is now  " + new Date());
		out.print("\n<br/>To go to Login page click <a href=\"LoginServlet.html\">here</a>");
		out.print("</body></html>");
	}
}
