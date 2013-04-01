<%@page import="java.sql.SQLException"%>
<%@page import="java.lang.String"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.Date "%>
<%@page import="gymkhana.ConnectionManager "%>
<%@page import="gymkhana.Parse "%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gymkhana Booking Site</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<%
		String name = (String) session.getAttribute("user");
		System.out.println(name);
		if (name == null) {
			response.sendRedirect("invalid.jsp");
		}
	%>
	<div>
		<img src="img/header.png" alt="header" width=50% height=15%
			style="margin: 20px 20px;"> <img src="img/bottom.png"
			alt="header" width=98% height=1px style="margin: -5px 10px">
	</div>
		<div style="background-color: #2175bc; height: 40px;">
		<ul id="button">
			<ul id="button">
			<li><a href="home.jsp"> Home </a></li>
			<%	if(Integer.valueOf(session.getAttribute("level").toString())>0) { %>
			<li><a href="approveEvent.jsp"> Approve Events </a></li>
			<% 	}
			if(session.getAttribute("type").toString().contains("head")||(session.getAttribute("type").toString().contains("doaa"))||(session.getAttribute("type").toString().contains("dosa"))) { %>
			<li><a href="approveRoom.jsp"> Approve Room Allotment </a></li>
			<% } if(Integer.valueOf(session.getAttribute("level").toString())<3) { %>
			<li><a href="booking.jsp">Get Approval for Events </a></li>	
			<% } if(session.getAttribute("type").toString().contains("fac")) { %>
			<li><a href="bookingRoom.jsp">Get Approval for Room</a></li>		
			<% } %>
			<li><a href="approved.jsp"> Approved Requests </a></li>
			<li><a href="pending.jsp"> Pending Requests </a></li>
			<li><a href="rejected.jsp"> Rejected Requests </a></li>
		</ul>
		<ul id="button1">
			<li><a href="logout.jsp">Logout</a></li>
			<li><a href="password.jsp">Change Password</a></li>
		</ul>
	</div>
	
	<font color="gray" size="3">
	<center>
	
<p> <strong>Following Requests have been approved : </strong><p>

<table id="dynamic" cellpadding="1" border="1" cellspacing="1">
		<tr>
			<th width=3%>Sl. No.</th>
			<th width=15%>Event Name</th>
			<th width=30%>Description</th>
			<th width=10%>Venue</th>
			<th width=9%>From Date</th>
			<th width=9%>Till Date</th>
		</tr>
		
			<%
				System.out.println(session.getAttribute("id"));
				String sql = "SELECT * FROM request WHERE origin='"+session.getAttribute("user")+"' AND status=4 AND bRoom='Yes'";
				Connection con = null;
				Statement s = null;
				ResultSet rs = null;
				try {
					con = ConnectionManager.getConnection();
					s = con.createStatement();
					rs = s.executeQuery(sql);
					int row =rs.getFetchSize();
					int count=1;
					while(rs.next()) {
			%>
			<tr>
				<td><%=count+"."%> 
				</td>
				<td><%=rs.getString(1)%> 
				</td>
				<td><%=rs.getString(2)%>
				</td>
				<td><%=Parse.venueroom(rs.getString(3))%></td>
				</td>
				<td><%="Date: "+rs.getString(4)+ "\n Time: "+rs.getString(6) %>
				</td>
				<td><%="Date: "+rs.getString(5)+ "\n Time: "+rs.getString(7)%>
				</td>
			</tr>
			<%
				count++;
				}
				} catch (Exception e) {
					e.printStackTrace();
					response.sendRedirect("home.jsp");
				}
			%>

		</table>
		</center>
		</font>
		<center>
		<div id="footer">
		<p><a href="http://intranet.iitg.ernet.in/">Intranet | </a><a href="http://intranet.iitg.ernet.in/noticeboard/">Notice Board | </a><a href="https://webmail.iitg.ernet.in/src/login.php">Webmail | </a><a href="http://shilloi.iitg.ernet.in/~acad/intranet/acadCal/AcadCalendar.htm">Acadenic Calender | </a><a href="http://intranet.iitg.ernet.in/news/">IITG Newsgroup</a></p>
			<p>
				This System is created by <a
					href="http://intranet.iitg.ernet.in/hostels/barak/"
					title="Barak Hostel, IIT Guwahati">Barak Hostel</a> &copy; 2013
				Indian Institute of Technology Guwahati.
			</p>
		</div>
	</center>
</body>
</html>