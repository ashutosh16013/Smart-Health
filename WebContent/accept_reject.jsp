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
if(session.getAttribute("uname")==null){
	System.out.println("Hello world");
	response.sendRedirect("error.html");
	return;
}
List<String> display_requests=lg.check_requests(detail_user.get(1));
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
					<li><a href="User.jsp">User</a></li>
					<li><a href="view_profile.jsp">View Profile</a></li>
					<li><a href="view_profile.jsp">Edit Profile</a></li>
					<li><a href="view_friends.jsp">View Friends</a></li>
					<li><a href="view_users_to_send.jsp">Send Requests</a></li>
					<li class="active"><a href="accept_reject.jsp">View Requests</a></li>
					<li><a href="ViewForumPosts.jsp">View Forums</a></li>
					<li><a href="view_health_data.jsp">View Health Data</a></li>
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

				<h1 class="page-header">Your current friend requests</h1>

				<hr>
				<div class = "row">
				<div class="col-md-3"><p><u><b>Serial No.</b></u></p></div>
				<div class="col-md-3"><p><u><b>Username</b></u></p></div>
				<div class="col-md-3"><center><p><u><b>Accept</b></u></p></center></div>
				<div class="col-md-3"><center><p><u><b>Reject</b></u></p></center></div>
				</div>
				<br />
				
				<form action="FriendRequest" method="GET">
				<input type="hidden" name="uname" value= "<%=detail_user.get(1)%>"/>
				<input type="hidden" name="size" value= "<%=display_requests.size()%>"/>

					<%int size = display_requests.size();
						String btn_acc = "btn_acc_";
						String btn_rej = "btn_rej_";
						String friend_id = "frnd_";
						for (int i=0;i<size;i++){
							
							String name = display_requests.get(i);
							
							%>
						<div class = "row">
						<div class="col-md-3"><p><%=i+1 %></p></div>
						<div class="col-md-3"><p name="<%=friend_id+(i+1)+""%>" value = "<%=name %>"><%=name %></p></div>
						<div class="col-md-3"><center><p><button class="btn btn-success" type="submit"
								name="<%=btn_acc+(i+1)+""%>" value = "<%=name %>" onclick="form.action='AcceptServlet';">Accept Request</button></p></center></div>
						<div class="col-md-3"><center><p><button class="btn btn-danger" type="submit"
								name="<%=btn_rej+(i+1)+""%>" value = "<%=name %>" onclick="form.action='RejectServlet';">Reject Request</button></p></center></div>
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