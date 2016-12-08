<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.smarthealth.controller.Login"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>SmartHealth</title>
<meta name="generator" content="Bootply" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
</head>
<body>
	<%Login lg=new Login();
List<String> detail_user=(List<String>)session.getAttribute("uname");
if(session.getAttribute("uname")==null){
	System.out.println("Hello world");
	response.sendRedirect("error.html");
	return;
}

String user_data[][] = (String[][])request.getAttribute("user");
String frnd_data[][] = (String[][])request.getAttribute("frnd");
String uname = (String)request.getAttribute("username");
String frndname = (String)request.getAttribute("frndname");
%>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="User.jsp">SmartHealth</a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a><%=detail_user.get(1) %></a></li>

			</ul>
		</div>
	</div>
	</nav>

	<div class="container-fluid">

		<div class="row row-offcanvas row-offcanvas-left">

			<div class="col-sm-3 col-md-2 sidebar-offcanvas" id="sidebar"
				role="navigation">

				<ul class="nav nav-sidebar">
					<li><a href="User.jsp">User</a></li>
					<li><a href="view_profile.jsp">View Profile</a></li>
					<li><a href="view_profile.jsp">Edit Profile</a></li>
					<li><a href="view_friends.jsp">View Friends</a></li>
					<li><a href="view_users_to_send.jsp">Send Requests</a></li>
					<li><a href="accept_reject.jsp">View Requests</a></li>
					<li><a href="ViewForumPosts.jsp">View Forums</a></li>
					<li class="active"><a href="view_health_data.jsp">View Health Data</a></li>
				</ul>


			</div>
			<!--/span-->

			<div class="col-sm-9 col-md-10 main">

				<!--toggle sidebar button-->
				<p class="visible-xs">
					<button type="button" class="btn btn-primary btn-xs"
						data-toggle="offcanvas">
						<i class="glyphicon glyphicon-chevron-left"></i>
					</button>
				</p>

				<h3 class="page-header">
					<%=uname %>'s data
				</h3>
				<!-- User data display -->
				<div class=row>
					<div class="col-md-4">
						<h4>Property Id</h4>
					</div>
					<div class="col-md-4">
						<h4>Name</h4>
					</div>
					<div class="col-md-4">
						<h4>Value</h4>
					</div>
				</div>

				<%
					int num_rows_hd = user_data.length;
					if(num_rows_hd>0)
					{
						
						int num_columns = user_data[0].length;
						for(int i=0;i<num_rows_hd;i++)
						{
							String[] detail_single_row = user_data[i];
					
					%>
				<div class=row>
					<div class="col-md-4">
						<%= detail_single_row[0]%>
					</div>
					<div class="col-md-4">
						<%String name="";
						if(detail_single_row[0].equals("0")){
							name="Running";
						}
						else if(detail_single_row[0].equals("1")){
							name="Blood Pressure";
						}
						else{
							name="Calories Burnt";
						}
						%>
						<%= name%>
					</div>
					<div class="col-md-4">
						<%= detail_single_row[1]%>
					</div>
				</div>
				<%
						}
					}
				  
				  %>
				<!-- User data display end -->
				
				
				<br />
				<br />
				<br />
				<!-- Frnd's data -->
				<h3 class="page-header">
					<%=frndname %>'s data
				</h3>
				<div class=row>
					<div class="col-md-4">
						<h4>Property Id</h4>
					</div>
					<div class="col-md-4">
						<h4>Name</h4>
					</div>
					<div class="col-md-4">
						<h4>Value</h4>
					</div>
				</div>

				<%
					int num_rows_fd = frnd_data.length;
					if(num_rows_fd>0)
					{
						
						int num_columns = frnd_data[0].length;
						for(int i=0;i<num_rows_fd;i++)
						{
							String[] detail_single_row = frnd_data[i];
					
					%>
				<div class=row>
					<div class="col-md-4">
						<%= detail_single_row[0]%>
					</div>
					<div class="col-md-4">
						<%String name="";
						if(detail_single_row[0].equals("0")){
							name="Running";
						}
						else if(detail_single_row[0].equals("1")){
							name="Blood Pressure";
						}
						else{
							name="Calories Burnt";
						}
						%>
						<%= name%>
					</div>
					<div class="col-md-4">
						<%= detail_single_row[1]%>
					</div>
				</div>
				<%
						}
					}
				  
				  %>
				<!-- User data display end -->
				<!-- Frnd's data end -->


			</div>
		</div>
		<!--/row-->
	</div>
	<!--/.container-->

	<footer>
	<form action="Logout" method="GET">
		<center>
			<button class="btn btn-default" type="submit" name="Logout"
				value="<%=detail_user.get(1) %>">Logout</button>
		</center>
	</form>
	<center>
		<p>©Ashutosh|Shanu|Yash</p>
	</center>
	</footer>

	<!-- script references -->
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>