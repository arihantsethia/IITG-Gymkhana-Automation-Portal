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
