<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.smarthealth.controller.Login"%>
<%@ page import="com.smarthealth.controller.Forum"%>
<%@ page import ="java.util.List"%>
<%@ page import ="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>SmartHealth</title>
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/styles.css" rel="stylesheet">
</head>
<body>
<%
Login lg=new Login();
Forum f = new Forum();
List<String> detail_user=(List<String>)session.getAttribute("uname");
if(session.getAttribute("uname")==null){
	System.out.println("Hello world");
	response.sendRedirect("error.html");
	return;
}
String[][] display_forums=f.get_available_forums();
%>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
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
					<li><a href="Moderator.jsp">User</a></li>
					<li><a href="view_profile.jsp">View Profile</a></li>
					<li><a href="view_profile.jsp">Edit Profile</a></li>
					<li class="active"><a href="view_forums.jsp">View All Forums</a></li>
					<li><a href="create_forum.jsp">Create Forum</a></li>
					<li><a href="add_qualification.jsp">Add Qualification</a></li>
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

				<h1 class="page-header">Currently Available Forums</h1>

				<hr>
				<div class = "row">
				<div class="col-md-3"><p><u><b>Forum Id</b></u></p></div>
				<div class="col-md-3"><p><u><b>Forum Topic</b></u></p></div>
				<div class="col-md-3"><center><p><u><b>Close</b></u></p></center></div>
				</div>
				<br />
				
				<form method="GET">
				<input type="hidden" name="uname" value= "<%=detail_user.get(1)%>"/>
				<input type="hidden" name="size" value= "<%=display_forums.length%>"/>

					<%int size = display_forums.length;
						String btn_post = "btn_post_";
						String btn_close = "btn_close_";
						String forum_id = "forum_";
						for (int i=0;i<size;i++){
							
							
							%>
						<div class = "row">
						<div class="col-md-3"><p><%=display_forums[i][0] %></p></div>
						<div class="col-md-3"><p name="<%=forum_id+(i+1)+""%>" value = "<%=display_forums[i][1] %>"><%=display_forums[i][1] %></p></div>
						<div class="col-md-3"><center><p><button class="btn btn-red" type="submit"
								name="<%=btn_close+(i+1)+""%>" value = "<%=display_forums[i][0] %>" onclick="form.action='DeleteForum';">Close Forum</button></p></center></div>
						</div>
					<%
							
						}
  					%>
				</form>
				

				
				</div>
			</div>
			<!--/row-->
		</div>
	<!--/.container-->

	<footer>
	<form action = "Logout" method = "GET">
		<center><button class="btn btn-default" type="submit"
								name="Logout" value = "<%=detail_user.get(1) %>">Logout</button></center>
	</form>
		<center><p>©Ashutosh|Shanu|Yash</p></center>
	</footer>

	<!-- script references -->
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>