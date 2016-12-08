<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.io.PrintWriter"%>
<%@ page import="com.smarthealth.controller.Login"%>
    <%@ page import ="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="js/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
<title>User_Registration</title>
</head>
<body>
<%
Login lg=new Login();
List<String> lst2=(List<String>)session.getAttribute("uname");
if(session.getAttribute("uname")==null){
	System.out.println("Hello world");
	response.sendRedirect("error.html");
	return;
}
String k = (lst2.get(1));
int uid = Integer.parseInt(lst2.get(0));
List<String> lst3=lg.user_details_print(k ,uid);

%>

<form class="form-horizontal" action = "send_for_update.jsp">
<fieldset>

<!-- Form Name -->
<center><span style="color:blue;font-size:20px">View and Edit your details</span></center>
<%
String href="";
if(uid == 1)
	href="User.jsp";
else if(uid==2)
	href="Moderator.jsp";
else
	href="Admin.jsp";
%>
<center><span style="color:blue;font-size:20px"><a href = <%=href %>>Return to Home</a></span></center>
<br />




<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="name">Name</label>  
  <div class="col-md-4">
  <input id="uname" name="uname" type="text" placeholder="Enter a password" class="form-control input-md" required="" value= "<%=lst3.get(0)%>" readonly>    
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Password</label>
  <div class="col-md-4">
    <input id="password" name="pass" type="password" placeholder="Enter a password" class="form-control input-md" required="" value= "<%=lst3.get(14)%>">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="email">Primary Email</label>  
  <div class="col-md-4">
  <input id="email" name="email1" type="email" placeholder="Enter your email id" class="form-control input-md" required="" value= "<%=lst3.get(1)%>"readonly>
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="email">Secondary Email</label>  
  <div class="col-md-4">
  <input id="email" name="email2" type="email" placeholder="Enter your email id" class="form-control input-md" required="" value= "<%=lst3.get(2)%>">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="name">First Name</label>  
  <div class="col-md-4">
  <input id="name" name="first_name" type="text" placeholder="Enter your name" class="form-control input-md" required="" value= "<%=lst3.get(3)%>">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="name">Last Name</label>  
  <div class="col-md-4">
  <input id="name" name="last_name" type="text" placeholder="Enter your name" class="form-control input-md" required="" value= "<%=lst3.get(4)%>">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="name">About_Me</label>  
  <div class="col-md-4">
  <input id="name" name="about_me" type="text" placeholder="Enter your name" class="form-control input-md" required="" value= "<%=lst3.get(5)%>">
    
  </div>
</div>


<div class="form-group">
  <label class="col-md-4 control-label" for="name">Pic 1</label>  
  <div class="col-md-4">
  <input id="name" name="pic_1" type="text" placeholder="Enter your name" class="form-control input-md" required="" value= "<%=lst3.get(6)%>">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="name">Pic 2</label>  
  <div class="col-md-4">
  <input id="name" name="pic_2" type="text" placeholder="Enter your name" class="form-control input-md" required="" value= "<%=lst3.get(7)%>">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="name">Pic 3</label>  
  <div class="col-md-4">
  <input id="name" name="pic_3" type="text" placeholder="Enter your name" class="form-control input-md" required="" value= "<%=lst3.get(8)%>">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="name">Street Number</label>  
  <div class="col-md-4">
  <input id="name" name="street_num" type="text" placeholder="Enter your name" class="form-control input-md" required="" value= "<%=lst3.get(9)%>">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="name">Steet Name</label>  
  <div class="col-md-4">
  <input id="name" name="street_name" type="text" placeholder="Enter your name" class="form-control input-md" required="" value= "<%=lst3.get(10)%>">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="name">Municipality party</label>  
  <div class="col-md-4">
  <input id="name" name="mun_party" type="text" placeholder="Enter your name" class="form-control input-md" required="" value= "<%=lst3.get(11)%>">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="name">Governing district</label>  
  <div class="col-md-4">
  <input id="name" name="gov_dist" type="text" placeholder="Enter your name" class="form-control input-md" required="" value= "<%=lst3.get(12)%>">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="name">Postal Area</label>  
  <div class="col-md-4">
  <input id="name" name="pos_area" type="text" placeholder="Enter your name" class="form-control input-md" required="" value= "<%=lst3.get(13)%>">
    
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="name">User Type</label>  
  <div class="col-md-4">
  <%
  String type="";
  if(uid==1)
  {
	  type = "End User";
  }
  else if(uid == 2)
	  type = "Moderator";
  else
	  type = "Admin";
  %>
  <input id="name" name="pos_area" type="text" placeholder="Enter your name" class="form-control input-md" required="" value= "<%=type%>" readonly>
    
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="signup"></label>
  <div class="col-md-4">
    <button id="signup" type = "submit" name="signup" class="btn btn-success">Update</button>
  </div>
</div>

</fieldset>
</form>

</body>
</html>