<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.smarthealth.controller.Login"%>
    <%@ page import ="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Login lg=new Login();
List<String> lst2=(List<String>)session.getAttribute("uname");
String k = (lst2.get(1));
List<String> lst3=lg.display_end_users(lst2.get(1));
 
	%>
	<form action="FriendRequest" method = "GET">
	
	<input type="hidden" name="uname" value= "<%=lst2.get(1)%>"/>
	 
	<select name="friendname">
   <% for (int i=0;i<lst3.size();i++) {
	   String name=lst3.get(i);
   %>
   <option value="<%= name %>"><%= name%></option>
   <% } %>
</select>
&nbsp;&nbsp;&nbsp;
<input type="submit" value="SEND REQUEST" />
</form>

</body>
</html>