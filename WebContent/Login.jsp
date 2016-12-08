<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="java.io.PrintWriter"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<link rel="stylesheet" href="css/login_dec.css" type="text/css">
<head>
<title>
Login Form
</title>
</head>
<body>
<%
			PrintWriter pw = response.getWriter();
			String msg = (String)request.getAttribute("Login_Msg");
			 if(msg !=null)
			 {
				 pw.write(" <center class='msg'><span style='color:Red;font-size:15px'>");
				 pw.write(msg);
				 pw.write(" </span></center>");
			 }%>
<div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			<div>Smart<span>Health</span></div>
		</div>
		<br>
		<div class="login">
		<form action = "Login_servlet" method = "post">
				<input type="text" name="email" required = "required"><br>
				<input type="password" name="pass" required = "required"><br>
				<input type="submit" value="Login">
		</form>
		<form action="Home.jsp">
			<input type="submit" value="Back to Home page">
		</form>
		</div>
		<%
			PrintWriter pw1 = response.getWriter();
			String msg1 = (String)session.getAttribute("error_msg");
			 if(msg1 !=null)
			 {%>
			 
				 <script type="text/javascript">
				 	alert(<%=msg1%>);
				 </script>
		    <% 
			 }%>
		
</body>	
</html>


