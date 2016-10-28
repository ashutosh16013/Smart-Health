<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.io.PrintWriter"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>User_Registration</title>
</head>
<body>

<form class="form-horizontal" action = "register.jsp">
<fieldset>

<!-- Form Name -->
<center><span style="color:blue;font-size:20px">Register to SmartHealth</span></center>
<br />

<%
PrintWriter pw = response.getWriter();
String msg = (String)request.getAttribute("Msg");
 if(msg !=null)
 {
	pw.write(" <center><span style='color:Red;font-size:15px'>");
	 pw.write(msg);
	 pw.write(" </span></center>");
 }
%>


<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="name">Name</label>  
  <div class="col-md-4">
  <input id="name" name="uname" type="text" placeholder="Enter your name" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Password</label>
  <div class="col-md-4">
    <input id="password" name="pass" type="password" placeholder="Enter a password" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="email">Primary Email</label>  
  <div class="col-md-4">
  <input id="email" name="email1" type="email" placeholder="Enter your email id" class="form-control input-md" required="">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="email">Secondary Email</label>  
  <div class="col-md-4">
  <input id="email" name="email2" type="email" placeholder="Enter your email id" class="form-control input-md" required="">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="name">First Name</label>  
  <div class="col-md-4">
  <input id="name" name="first_name" type="text" placeholder="Enter your name" class="form-control input-md" required="">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="name">Last Name</label>  
  <div class="col-md-4">
  <input id="name" name="last_name" type="text" placeholder="Enter your name" class="form-control input-md" required="">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="name">About_Me</label>  
  <div class="col-md-4">
  <input id="name" name="about_me" type="text" placeholder="Enter your name" class="form-control input-md" required="">
    
  </div>
</div>


<div class="form-group">
  <label class="col-md-4 control-label" for="name">Pic 1</label>  
  <div class="col-md-4">
  <input id="name" name="pic_1" type="text" placeholder="Enter your name" class="form-control input-md" required="">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="name">Pic 2</label>  
  <div class="col-md-4">
  <input id="name" name="pic_2" type="text" placeholder="Enter your name" class="form-control input-md" required="">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="name">Pic 3</label>  
  <div class="col-md-4">
  <input id="name" name="pic_3" type="text" placeholder="Enter your name" class="form-control input-md" required="">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="name">Street Number</label>  
  <div class="col-md-4">
  <input id="name" name="street_num" type="text" placeholder="Enter your name" class="form-control input-md" required="">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="name">Steet Name</label>  
  <div class="col-md-4">
  <input id="name" name="street_name" type="text" placeholder="Enter your name" class="form-control input-md" required="">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="name">Municipality party</label>  
  <div class="col-md-4">
  <input id="name" name="mun_party" type="text" placeholder="Enter your name" class="form-control input-md" required="">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="name">Governing district</label>  
  <div class="col-md-4">
  <input id="name" name="gov_dist" type="text" placeholder="Enter your name" class="form-control input-md" required="">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="name">Postal Area</label>  
  <div class="col-md-4">
  <input id="name" name="pos_area" type="text" placeholder="Enter your name" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="user_type">User Type</label>
  <div class="col-md-4">
    <select id="user_type" name="user_type" class="form-control">
      <option value="1">End User</option>
      <option value="2">Moderator</option>
      <option value="3">Admin</option>
    </select>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="signup"></label>
  <div class="col-md-4">
    <button id="signup" type = "submit" name="signup" class="btn btn-success">Sign Up</button>
  </div>
</div>

</fieldset>
</form>

</body>
</html>