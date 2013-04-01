package gymkhana;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Login extends HttpServlet {
	public static Connection currentCon = null;
	public static HttpSession session = null;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			String name = request.getParameter("un");
			String pass = request.getParameter("pw");
			Class.forName("com.mysql.jdbc.Driver");
			currentCon = ConnectionManager.getConnection();
			System.out.println("Connection");
			Statement s = currentCon.createStatement();
			ResultSet rs = s
					.executeQuery("select * from users where username='" + name
							+ "' ");

			if (rs.next()) {

				if ((name.trim().equals(rs.getString(2).trim()))
						&& (pass.trim().equals(rs.getString(3).trim()))) {

					// New session creation
					session = request.getSession(true);
					// setting attribute on session
					session.setAttribute("name", rs.getString(1));
					session.setAttribute("user", rs.getString(2));
					session.setAttribute("type", rs.getString(4));
					session.setAttribute("super", rs.getString(5));
					session.setAttribute("level", rs.getString(6));
					// send request to Welcome.jsp page
					RequestDispatcher view = request
							.getRequestDispatcher("home.jsp");
					view.forward(request, response);

				} else {
					out.println("<div class="+"login-help"+" > <p>Invalid Login</p> </div>");
					RequestDispatcher view = request
							.getRequestDispatcher("login.jsp");
					view.include(request, response);
				}
			} else {

				out.println("<div class="+"login-help"+" > <p>Invalid Login</p> </div>");
				RequestDispatcher view = request
						.getRequestDispatcher("login.jsp");
				view.include(request, response);
				
			}
		} catch (Exception e) {
			System.out.println("NO");
		} finally {
			out.close();
		}
	}
}
