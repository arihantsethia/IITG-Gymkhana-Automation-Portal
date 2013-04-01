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
