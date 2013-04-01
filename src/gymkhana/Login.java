/* The aim of software is to provide an automated portal for gymkhana at IIT-Guwahati
    Copyright (C) 2013  Arihant Sethia

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

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
