<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Gymkhana Booking Site</title>
<link href=" css/uni-form.css" media="screen" rel="stylesheet" />
<link href=" css/default.uni-form.css" title="Default Style"
	media="screen" rel="stylesheet" />
<link href=" css/demo.css" media="screen" rel="stylesheet" />
<style type="text/css">
#button {
	padding: 0;
}

#button li {
	display: inline;
}

#button li a {
	font-family: Arial;
	font-size: 15px;
	text-decoration: none;
	float: left;
	padding: 10px;
	background-color: #2175bc;
	color: #fff;
}

#button li a:hover {
	background-color: #2586d7;
	margin-top: -2px;
	padding-bottom: 12px;
}

#button1 {
	padding: 0;
}

#button1 li {
	display: inline;
}

#button1 li a {
	font-family: Arial;
	font-size: 15px;
	text-decoration: none;
	float: right;
	padding: 10px;
	background-color: #2175bc;
	color: #fff;
}

#button1 li a:hover {
	background-color: #2586d7;
	margin-top: -2px;
	padding-bottom: 12px;
}
</style>

</head>
<body>
	<%
		String name = (String)session.getAttribute("user");
		System.out.println(name + " "+session.getAttribute("type"));
		if (name == null || !session.getAttribute("type").toString().contains("fac")) {
			response.sendRedirect("invalid.jsp");
		}
	%>
	<div>
		<img src="img/header.png" alt="header" width=50% height=15%
			style="margin: 20px 20px;"> <img src="img/bottom.png"
			alt="header" width=98% height=1px style="margin: -6px 10px">
	</div>

		<div style="background-color: #2175bc; height: 42px;">
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
	<font color="gray" size="3"> <font color="gray" size="3">

			<form method="post" action="AddNewRoom" class="uniForm">

				<fieldset>
					<h3>Room Approval Form</h3>		
					<div class="ctrlHolder">
							<label for=""><em>*</em>Date</label> <input
									name="fDate" class="dateInput required" type="date" /></td>								
							<p class="formHint">Required Date </p>
					</div>
					<div class="ctrlHolder">
						<table>
							<tr>
								<td><label for=""><em>*</em>From Time</label> <input
									name="fTime" id="a_number" type="time" /></td>
								<td><label for=""><em>*</em>Till Time</label> <input
									name="tTime" id="a_number" type="time" /></td>
							</tr>
							<p class="formHint">Required Time</p>
						</table>
					</div>
					<div class="ctrlHolder">
						<label for=""><em>*</em> Venue</label> <select name="venue"
							type="text" class="textInput required">
							<option selected="selected" hidden></option>
							<optgroup label="Lecture Theatre">
								<option value="lt">Lecture Theatre</option>
							</optgroup>
							<optgroup label="Seminar Halls">
								<option value="dBT">Dept. of Biotechnology</option>
								<option value="dCL">Dept. of Chemical Engineering</option>
								<option value="dCST">Dept. of Chemical Science &
									Technology</option>
								<option value="dCE">Dept. of Civil Engineering</option>
								<option value="dCSE">Dept. of Computer Science &amp;
									Engg.</option>
								<option value="dOD">Dept. of Design</option>
								<option value="dEEE">Dept. of Electronics &amp;
									Electrical Engg.</option>
								<option value="dHSS">Dept. of Humanities and Social
									Sciences</option>
								<option value="dMNC">Dept. of Mathematics</option>
								<option value="dME">Dept. of Mechanical Engineering</option>
								<option value="dEP">Dept. of Physics</option>
							</optgroup>
						</select>
						<p class="formHint">Required Venue</p>
					</div>
				</fieldset>
				<div class="buttonHolder">
					<button type="submit" class="primaryAction">Submit</button>
				</div>
			</form>
			<div id="footer">
			<p><a href="http://intranet.iitg.ernet.in/">Intranet | </a><a href="http://intranet.iitg.ernet.in/noticeboard/">Notice Board | </a><a href="https://webmail.iitg.ernet.in/src/login.php">Webmail | </a><a href="http://shilloi.iitg.ernet.in/~acad/intranet/acadCal/AcadCalendar.htm">Acadenic Calender | </a><a href="http://intranet.iitg.ernet.in/news/">IITG Newsgroup</a></p>
				<p>
					This System is created by <a
						href="http://intranet.iitg.ernet.in/hostels/barak/"
						title="Barak Hostel, IIT Guwahati">Barak Hostel</a> &copy; 2013
					Indian Institute of Technology Guwahati.
				</p>
			</div> <script type="text/javascript" src="js/jquery.js"></script> <script
				type="text/javascript" src="js/uni-form-validation.jquery.js"
				charset="utf-8"></script> <script>
					$(function() {
						$('form.uniForm').uniform({
							prevent_submit : true
						});
					});
				</script>
	</font>
</body>
</html>