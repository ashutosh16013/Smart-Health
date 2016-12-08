package com.smarthealth.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login_servlet
 */
//@WebServlet("/Login_servlet")
public class Login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Connection con;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	public void init(){
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/smarthealthdb","root","ashutosh");
		 
		}
		catch(Exception e){ 
			System.out.println("Error in database connection");
		
		
		}
		
	}
    public Login_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		String mail = request.getParameter("email");
		String pass = request.getParameter("pass");

		System.out.println("Hello world");
		Login obj = new Login();
			List<String> result;
			try {
				result = obj.login_into(mail, pass);
				HttpSession session = request.getSession();
				if(Integer.parseInt(result.get(0))==1)
				{
					session.setAttribute("uname",result);
					//response.sendRedirect("User.jsp");
					pw.print("<h1>hello</h1>"+result+"<br/><a>click</a>");
					RequestDispatcher rd=request.getRequestDispatcher("User.jsp");
					rd.forward(request, response);
					//response.sendRedirect("User.jsp");
				}
				else if(Integer.parseInt(result.get(0))==2)
				{
					session.setAttribute("uname",result);
					//response.sendRedirect("User.jsp");
					pw.print("<h1>hello</h1>"+result+"<br/><a>click</a>");
					RequestDispatcher rd=request.getRequestDispatcher("Moderator.jsp");
					rd.forward(request, response);
					//response.sendRedirect("User.jsp");
				}
				else if(Integer.parseInt(result.get(0))==3)
				{
					session.setAttribute("uname",result);
					//response.sendRedirect("User.jsp");
					pw.print("<h1>hello</h1>"+result+"<br/><a>click</a>");
					RequestDispatcher rd=request.getRequestDispatcher("Admin.jsp");
					rd.forward(request, response);
					//response.sendRedirect("User.jsp");
				}
				else
				{
					System.out.println("inv");
					session.setAttribute("error_msg", "Invalid credentials. Please try again");
					RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
				}
					
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				response.sendRedirect("error.html");
				//e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				response.sendRedirect("error.html");
				//e.printStackTrace();
			}
	}

}
