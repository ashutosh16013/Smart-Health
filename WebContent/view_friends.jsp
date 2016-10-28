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
	<%

Login lg=new Login();
List<String> detail_user=(List<String>)session.getAttribute("uname");
List<String> list_of_friends=lg.view_friends(detail_user.get(1));
%>

	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
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
					<li><a href="#">User</a></li>
					<li><a href="view_profile.jsp">View Profile</a></li>
					<li><a href="view_profile.jsp" target="_ext">Edit Profile</a></li>
					<li class="active"><a href="view_friends.jsp">View Friends</a></li>
					<li><a href="view_users_to_send.jsp">Send Requests</a></li>
					<li><a href="accept_reject.jsp">View Requests</a></li>
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

				<h1 class="page-header">Your current friends</h1>

				<hr>
				<div class = "row">
				<div class="col-md-4"><p><u><b>Serial No.</b></u></p></div>
				<div class="col-md-4"><p><u><b>Username</b></u></p></div>
				<div class="col-md-4"><p><u><b>Unfriend</b></u></p></div>
				</div>
				<br />
				
				<form action="Unfriend" method="GET">
				<input type="hidden" name="uname" value= "<%=detail_user.get(1)%>"/>
				<input type="hidden" name="size" value= "<%=list_of_friends.size()%>"/>

					<%int size = list_of_friends.size();
						String btn_id = "btn_";
						String friend_id = "frnd_";
						for (int i=0;i<size;i++){
							
							String name = list_of_friends.get(i);
							
							%>
						<div class = "row">
						<div class="col-md-4"><p><%=i+1 %></p></div>
						<div class="col-md-4"><p name="<%=friend_id+(i+1)+""%>" value = "<%=name %>"><%=name %></p></div>
						<div class="col-md-4"><p><button class="btn btn-default" type="submit"
								name="<%=btn_id+(i+1)+""%>" value = "<%=name %>">Unfriend</button></p></div>
						</div>
					<%
							
						}
  					%>
				</form>

			</div>

		</div>
	</div>

	<footer>
	<center>
	<form action = "Logout" method = "GET">
		<center><button class="btn btn-default" type="submit"
								name="Logout" value = "<%=detail_user.get(1) %>">Logout</button></center>
	</form>
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