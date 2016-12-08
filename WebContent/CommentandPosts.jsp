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
<%
Login lg=new Login();
List<String> detail_user=(List<String>)session.getAttribute("uname");
if(session.getAttribute("uname")==null){
	System.out.println("Hello world");
	response.sendRedirect("error.html");
	return;
}
String [][]posts = (String [][])request.getAttribute("posts");
int forum_id = 0;
if(request.getAttribute("forum_id")!=null){
	forum_id = (int)request.getAttribute("forum_id");
	session.setAttribute("forum_id",forum_id);
}
else
	forum_id = (int)session.getAttribute("forum_id");
	
if(posts==null){
	
	posts = lg. list_all_post(forum_id);
	if(posts == null){
		posts = lg. list_all_post(forum_id);
	}
}
else
	session.setAttribute("array_of_posts",posts);

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
					<li><a href="User.jsp">User</a></li>
					<li><a href="view_profile.jsp">View Profile</a></li>
					<li><a href="view_profile.jsp">Edit Profile</a></li>
					<li><a href="view_friends.jsp">View Friends</a></li>
					<li><a href="view_users_to_send.jsp">Send Requests</a></li>
					<li><a href="accept_reject.jsp">View Requests</a></li>
					<li class="active"><a href="ViewForumPosts.jsp">View Forums</a></li>
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
					Give a Post here or make a Comment
				</h1>
				<!--Code for displaying comments and posts  -->
				<form class="form-horizontal" action="PostonForum" method="post">
				<input type="hidden" name="uname" value= "<%=detail_user.get(1)%>"/>
				<input type="hidden" name="forum_id" value= "<%=forum_id%>"/>	 
						<div class="row">
							<div class="col-md-10">
									<textarea style='resize: none;' rows="3" class="form-control" name="tb_new_post" type="text" placeholder="Post...">
									</textarea>
							</div>
						    <div class="col-md-2">
						        <button type="submit" class="btn btn-success" name="btn_new_post">Post</button>
						    </div>
						</div>
				</form>
				
				<%
					int num_rows = posts.length;
					if(num_rows>0)
					{
						
						int num_columns = posts[0].length;
						for(int i=0;i<num_rows;i++)
						{
							String[] detail_single_row = posts[i];
						%>
						<br /><br />
						<div class="row">
							<div class="col-md-6">
								<label class="control-label" for="name">
									Post No.<%= (i+1)+" -> "+detail_single_row[0]+" "+
											detail_single_row[1]+" "+detail_single_row[2]%><!-- In this array 5th element is 
											timestamp -->
									
								</label>
							</div>
							<form class="form-horizontal" action = "Rate_Post" method="post">
							<input type="hidden" name="uname" value= "<%=detail_user.get(1)%>"/>
							<input type="hidden" name="uname_creator" value= "<%=detail_single_row[0]%>"/>
							<input type="hidden" name="timestamp" value= "<%=detail_single_row[5]%>"/>
								<!-- Dropdown for rating -->
								  <div class="col-md-2">
								    <select id="rating" name="rating" class="form-control">
								      <option value="1">1</option>
								      <option value="2">2</option>
								      <option value="3">3</option>
								      <option value="4">4</option>
								      <option value="5">5</option>
								    </select>
								</div>
								<!-- Dropdown end -->
								<!-- Button to rate -->
								<!-- Button -->
								  <div class="col-md-2">
								    <button id="signup" type = "submit" name="signup" class="btn btn-info">Rate</button>
								</div>
								<!-- End -->
							</form>
						</div>
						<br />
						<!--Display comments for each post here  -->
						<%
						    String[][] comments = lg.view_comments(detail_user.get(1),detail_single_row[5]);
							int num_rows_comm = comments.length;
							if(num_rows_comm>0)
							{
								int num_column = comments[0].length;
								for(int j=0;j<num_rows_comm;j++){
									
									String[] row_for_comment = comments[j];
								%>
								
								<div class="row row-offcanvas row-offcanvas-left">
									<div class="col-md-2"></div>
										<div class="col-md-10">
											<label class="col-md-10 control-label" for="name"><%= row_for_comment[0]+
											" "+row_for_comment[1]+" "+row_for_comment[2]%></label>
										</div>
								</div>
							
								<%
								}		
							}//if num_rows>0 ends
							
						%>
							
						<%
						if(num_rows_comm>=0){
							%>
						
						<form class="form-horizontal" action="CommentonPost" method="post">
						
						<input type="hidden" name="uname" value= "<%=detail_user.get(1)%>"/>
						<input type="hidden" name="post_uname" value= "<%=detail_single_row[0]%>"/>
						<input type="hidden" name="post_time" value= "<%=detail_single_row[5]%>"/>
					 
							<div class="row">
							<div class="col-md-2"></div>
								<div class="col-md-8">
										<textarea style='resize: none;' rows="1" class="form-control" name="tb_new_comment" type="text" placeholder="Comment...">
										</textarea>
								</div>
							    <div class="col-md-2">
							        <button type="submit" class="btn btn-success" name="btn_new_post">Comment</button>
							    </div>
							</div>
						</form>
						<%}
						%>
						
						
				<%
						}//if num_rows>0 ends
					}
				%>
				
				<!--End Code for displaying comments and posts  -->
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