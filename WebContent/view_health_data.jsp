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
<link href="css/health_modal.css" rel="stylesheet">
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
List<String> list_of_friends=lg.view_friends(detail_user.get(1));
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
					Hey,
					<%=detail_user.get(1) %>
					Insert new data here
				</h3>
				<form class="form-horizontal" action="InsertDatum" method="post">
					<fieldset>
						<input type="hidden" name="uname" value="<%=detail_user.get(1)%>" />

						<!--Insert form for datum here  -->

						<div class="row">
							<div class="col-md-4">
								<select id="property_id" name="property_id" class="form-control">
									<option value="1">Running</option>
									<option value="2">Blood Pressure</option>
									<option value="3">Calories burnt</option>
								</select>
							</div>
							<div class="col-md-4">
								<input id="number" name="number" type="number"
									placeholder="Enter a Value" class="form-control" required="">
							</div>
							<div class="col-md-4">
								<button id="add" type="submit" name="add"
									class="btn btn-success">Add value</button>
							</div>

						</div>

						<!--Insert form for datum here end -->

					</fieldset>
				</form>

				<br /> <br /> <br />

				<!-- Display data of user -->
				<h3 class="page-header">Your Health Data</h3>
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
				  	lg.result = detail_user.get(1);
					String [][] health_data = lg.view_health_data();
					int num_rows_hd = health_data.length;
					if(num_rows_hd>0)
					{
						
						int num_columns = health_data[0].length;
						for(int i=0;i<num_rows_hd;i++)
						{
							String[] detail_single_row = health_data[i];
					
					%>
				<div class=row>
					<div class="col-md-4">
						<%= detail_single_row[0]%>
					</div>
					<div class="col-md-4">
						<%String name="";
						if(detail_single_row[0].equals("1")){
							name="Running";
						}
						else if(detail_single_row[0].equals("2")){
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
				<!-- Display data of user end -->

				<br /> <br /> <br />

				<!-- Insert viewing of health data -->

				<h3 class="page-header">Your current friends</h3>

				<hr>

				<div class="row">
					<div class="col-md-4">
						<p>
							<u><b>Serial No.</b></u>
						</p>
					</div>
					<div class="col-md-4">
						<p>
							<u><b>Username</b></u>
						</p>
					</div>
					<div class="col-md-4">
						<p>
							<u><b>Unfriend</b></u>
						</p>
					</div>
				</div>
				<br />
				<!-- Form for viewing friends data -->
				<form class="form-horizontal" action="View_Data_Friend" method="post">
					<fieldset>
						<input type="hidden" name="uname" value="<%=detail_user.get(1)%>" />
						<input type="hidden" name="size"
							value="<%=list_of_friends.size()%>" />

						<%int size = list_of_friends.size();
							String btn_id = "btn_";
							String friend_id = "frnd_";
							for (int i=0;i<size;i++){
								
								String name = list_of_friends.get(i);
								
								%>
						<div class="row">
							<div class="col-md-4">
								<p><%=i+1 %></p>
							</div>
							<div class="col-md-4">
								<p name="<%=friend_id+(i+1)+""%>" value="<%=name %>"><%=name %></p>
							</div>
							<div class="col-md-4">
								<p>
									<button class="btn btn-warning" type="submit"
										name="<%=btn_id+(i+1)+""%>" value="<%=name %>">View
										data</button>
								</p>
							</div>
						</div>
						<% 				
							}
	  					%>
					</fieldset>
				</form>
				<!-- Insert viewing of health data end-->

				<!-- Modal to display health data -->


				<!-- The Modal -->
				<div id="myModal" class="modal">

					<!-- Modal content -->
					<div class="modal-content">
						<div class="modal-header">
							<span class="close">&times</span>
							<h2>Modal Header</h2>
						</div>
						<div class="modal-body">

							<p>Some text in the Modal Body</p>
							<p>Some other text...</p>
						</div>
						<div class="modal-footer">
							<h3>Modal Footer</h3>
						</div>
					</div>

				</div>
				<!-- Modal to display health data end -->

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
	<script type="text/javascript">
	// Get the modal
	var modal = document.getElementById('myModal');

	// Get the button that opens the modal
	var btn = document.getElementById("myBtn");

	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[0];

	// When the user clicks the button, open the modal 
	btn.onclick = function() {
	    modal.style.display = "block";
	}

	// When the user clicks on <span> (x), close the modal
	span.onclick = function() {
	    modal.style.display = "none";
	}

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
	    if (event.target == modal) {
	        modal.style.display = "none";
	    }
	}
	</script>
	<script src="js/scripts.js"></script>
</body>
</html>