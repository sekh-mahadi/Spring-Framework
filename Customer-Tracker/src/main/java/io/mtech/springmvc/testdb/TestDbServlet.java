package io.mtech.springmvc.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *          response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = "root";
		String password = "Sekh#012";
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		//String jdbcDriver = "com.mysql.jdbc.Driver"; //
		String jdbcDriver = "com.mysql.cj.jdbc.Driver";

		// Setup connection
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to Database: " + jdbcUrl);
			Class.forName(jdbcDriver);

			Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);

			out.println("SUCCESS!");
			myConn.close();
		} catch (Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc);
		}
	}

}
