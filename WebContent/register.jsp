<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.smarthealth.controller.Registration"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="userinfo" class="com.smarthealth.model.UserModel"></jsp:useBean> 

<jsp:setProperty property="*" name="userinfo"/> 

<jsp:getProperty property="user_type" name = "userinfo" />
<%
Registration obj = new Registration();

int result_uname = obj.check_uname(userinfo.getUname());

int result_prim_email = obj.check_prim_email(userinfo.getEmail1());

if(result_uname == 1 && result_prim_email == 1)
{
	obj.getdata(userinfo.getUname(), userinfo.getPass(), userinfo.getEmail1(),userinfo.getEmail2(), userinfo.getFirst_name(), userinfo.getLast_name(), userinfo.getAbout_me(), userinfo.getPic_1(), 
			userinfo.getPic_2(), userinfo.getPic_3(), userinfo.getStreet_num(), userinfo.getStreet_name(), userinfo.getMun_party(), userinfo.getGov_dist(), userinfo.getPos_area(), userinfo.getUser_type()); 
	
	
	request.setAttribute("Login_Msg", "Registered Successfully. Login Here");
	RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
	rd.forward(request, response);
	

}
else
{
	request.setAttribute("Msg", "Primary Email or Username is duplicate. Please try again");
	RequestDispatcher rd=request.getRequestDispatcher("User_registration.jsp");
	rd.forward(request, response);
}
%>

</body>
</html>