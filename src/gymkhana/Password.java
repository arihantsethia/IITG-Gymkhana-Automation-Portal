package gymkhana;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Password extends HttpServlet {
	public static Connection currentCon = null;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			String oldpass = request.getParameter("pw0");
			String pass = request.getParameter("pw");
			String pass1 = request.getParameter("pw1");
			String user = Login.session.getAttribute("user").toString();
			System.out.println("Connection asdasd " + user);
			Class.forName("com.mysql.jdbc.Driver");
			currentCon = ConnectionManager.getConnection();
			System.out.println("Connection" + user);
			
			Statement s = currentCon.createStatement();
			if (pass1.equals(pass)) {
				String query = "update users set password='" + pass	+ "' where username='" +user + "' AND password='"+oldpass+"'";
				s.executeUpdate(query);
				System.out.println("asdasd asdasd asdasd");
				out.println("<div class=" + "login-help"
						+ " > <p>Password Changed</p> </div>");
				RequestDispatcher view = request
						.getRequestDispatcher("home.jsp");
				view.forward(request, response);

			} else {
				out.println("<div class=" + "login-help"
						+ " > <p>Error!!</p> </div>");
				RequestDispatcher view = request
						.getRequestDispatcher("password.jsp");
				view.include(request, response);
			}
		} catch (Exception e) {
			System.out.println("NO");
		} finally {
			out.close();
		}
	}
}
