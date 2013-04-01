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

import java.io.IOException;
import javax.servlet.ServletException;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AddNew extends HttpServlet {
	public static Connection currentCon;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			
			currentCon = ConnectionManager.getConnection();
			String origin = Login.session.getAttribute("user").toString();
			String name = request.getParameter("name");
			String desc = request.getParameter("desc");
			String fDate = request.getParameter("fDate");
			String fTime = request.getParameter("fTime");
			String tDate = request.getParameter("tDate");
			String tTime = request.getParameter("tTime");
			String venue = request.getParameter("venue");
			String approvedBy = Login.session.getAttribute("name").toString();			
			String approvalOf = Login.session.getAttribute("super").toString();
			String approved=origin+" ";
			java.util.Date date = new java.util.Date();
			String done = date.toString()+ " ";			
			String bRoom = "No";			
			Class.forName("com.mysql.jdbc.Driver");
			Statement s = currentCon.createStatement();
			String query = "insert request () values ('"+name +"','" +desc +"','"+venue +"','"+fDate +"','"+tDate +"','" +fTime +"','" +tTime +"','" +origin +"','" +approvedBy+"','"+approvalOf+"','"+bRoom+"','"+0+"','"+approved+"','"+done+"');";
			System.out.println(query);
			
			s.execute(query);
			System.out.println("Done");
			RequestDispatcher view = request.getRequestDispatcher("home.jsp");
			view.forward(request, response);
		} catch (Exception e) {
			System.out.println("NO");
			 e.printStackTrace();
		} finally {
			out.close();
		}
	}
}
