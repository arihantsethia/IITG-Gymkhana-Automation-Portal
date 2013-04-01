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
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Request
 */
public class Request extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection currentCon;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			currentCon = ConnectionManager.getConnection();
			String origin = request.getParameter("origin");
			String name = request.getParameter("event");
			String desc = request.getParameter("desc");
			String fDate = request.getParameter("fDate");
			String fTime = request.getParameter("fTime");
			String tDate = request.getParameter("tDate");
			String tTime = request.getParameter("tTime");
			String venue = request.getParameter("venue");
			String approvedBy = request.getParameter("approvedBy");
			String approvalOf = request.getParameter("approvalOf");
			String approved = request.getParameter("approved");
			String done = request.getParameter("done");
			java.util.Date date = new java.util.Date();
			String bRoom = "No";
			int status = Integer.valueOf(request.getParameter("status"));

			if (request.getParameter("select").toString().equals("Reject"))
				status = 1;
			else if (status == 2 && Login.session.getAttribute("user").equals(approvedBy)) {
				System.out.println("asdasfhjkdsg");
				if (request.getParameter("select").toString().equals("Approve")) {
					approvalOf="done";
					status=4;	
					bRoom="Yes";
				}
				
			}
			else if (Login.session.getAttribute("user").equals("doaa")
					|| Login.session.getAttribute("user").equals("dosa")) {
				approvalOf = Parse.venueauth(venue);
				System.out.println("asfdsf");
				if (request.getParameter("select").toString().equals("Approve")) {
					status =  2;
				}
			}
			System.out.println("asf");
			Class.forName("com.mysql.jdbc.Driver");
			Statement s = currentCon.createStatement();
			String query = "update request set event='" + name
					+ "',description='" + desc + "',venue='" + venue
					+ "',fDate='" + fDate + "',tDate='" + tDate + "',fTime='"
					+ fTime + "',tTime='" + tTime + "',origin='" + origin
					+ "',approvedBy='" + approvedBy + "',approvalOf='"
					+ approvalOf + "',bRoom='" + bRoom + "',status='" + status
					+ "' where event='" + name + "' AND fDate='" + fDate
					+ "' AND tDate ='" + tDate + "'";
			s.executeUpdate(query);
			System.out.println("asf2");
			response.sendRedirect(request.getHeader("referer").toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
}
