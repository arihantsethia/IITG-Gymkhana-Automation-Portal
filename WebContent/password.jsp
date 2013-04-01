<%@page import="java.sql.SQLException"%>
<%@page import="java.lang.String"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.Date "%>
<%@page import="gymkhana.ConnectionManager "%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/login.css">
<title>Change Your Password</title>
</head>
<body>
	<%
		String name = (String) session.getAttribute("user");
		System.out.println(name);
		if (name == null) {
			response.sendRedirect("invalid.jsp");
		}
	%>
	<div >
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
	
	<section class="container">
    <div class="login">
      <h1>Change Your Password</h1>
      <form method="post" action="Password">
        <p><input type="password" name="pw0" value="" placeholder="Current Password"></p>
        <p><input type="password" name="pw" value="" placeholder="New Password"></p>
        <p><input type="password" name="pw1" value="" placeholder="Re-Enter New Password"></p>        
        <p class="submit"><input type="submit" value="Change Password"></p>
      </form>
    </div>
    
    
  </section>
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