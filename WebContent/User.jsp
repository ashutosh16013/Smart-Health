<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.smarthealth.controller.Login"%>
<%@ page import ="java.util.List"%>
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
<%List<String> detail_user=(List<String>)session.getAttribute("uname");
if(session.getAttribute("uname")==null){
	System.out.println("Hello world");
	response.sendRedirect("error.html");
	return;
}
int l = detail_user.get(1).length();
String images[] = new String[3];
images[0] = images[1] = images[2]= "";
Login obj = new Login();
images = obj.fetch_pics(detail_user.get(1));
for(int i=0;i<3;i++){
	if(images[i].length()>l)
	{
		String sub_i = images[i].substring(0, l);
		//images[i].equals("space")||images[i].equals("blank")
		if(!sub_i.equals(detail_user.get(1))){
			images[i]="Noimage.jpg";
		}
	}
	else
		images[i]="Noimage.jpg";
	
}
System.out.println(images[0]+" "+images[1]+" "+images[2]);

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
					<li class="active"><a href="User.jsp">User</a></li>
					<li><a href="view_profile.jsp">View Profile</a></li>
					<li><a href="view_profile.jsp">Edit Profile</a></li>
					<li><a href="view_friends.jsp">View Friends</a></li>
					<li><a href="view_users_to_send.jsp">Send Requests</a></li>
					<li><a href="accept_reject.jsp">View Requests</a></li>
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

				<h1 class="page-header">
					Welcome User <%=detail_user.get(1) %>
					<p>Have a healthy life</p>
				</h1>
				<form class="form-horizontal" action="URL_for_image1" method="post" enctype="multipart/form-data">
			      <div class="row">
			      
			      	<div class="col-md-6">
			      		<img src="<%=images[0]%>" alt="Noimage.png" style="width:200px;height:200px;">
			      	</div>
			      	<div class="col-md-6">
			      		<input class="form-control" type="file" name="image1"  placeholder="Image 1..." accept="image/*">
	  					<div class="col-md-12"><br></div>
	  					<button  type="submit" class="btn btn-info" name="btn_image_1">Upload !</button>
			      	</div>	
			      </div>
			   </form>
			      <div class="col-md-12"><br></div>
			    <form class="form-horizontal" action="URL_for_image2" method="post" enctype="multipart/form-data">   
			      <div class="row">
			      	<div class="col-md-6">
			      		<img src="<%=images[1]%>" alt="Noimage.png" style="width:200px;height:200px;">
			      	</div>
			      	<div class="col-md-6">
			      		<input class="form-control" type="file" name="image2"  placeholder="Image 2..." accept="image/*">
	  					<br />
	  					<button type="submit" class="btn btn-info" name="btn_image_2">Upload !</button>
			      	</div>	
			      </div>
			    </form>
			      <div class="col-md-12"><br></div>
			     <form class="form-horizontal" action="URL_for_image3" method="post" enctype="multipart/form-data">  
			      <div class="row">
			      	<div class="col-md-6">
			      		<img src="<%=images[2]%>" alt="Noimage.png" style="width:200px;height:200px;">
			      	</div>
			      	<div class="col-md-6">
			      		<input class="form-control" type="file" name="image3"  placeholder="Image 3..." accept="image/*">
	  					<div class="col-md-12"><br></div>
	  					<button type="submit" class="btn btn-info" name="btn_image_3">Upload !</button>
			      	</div>	
			      </div>
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