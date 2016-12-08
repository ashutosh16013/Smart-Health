package com.smarthealth.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Unfriend
 */
//@WebServlet("/Unfriend")
public class Unfriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Unfriend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int size_of_list = Integer.parseInt(request.getParameter("size"));
		String unfriending_username = "",unfriend_for = "";
		for(int i=0;i<size_of_list;i++)
		{
			String btn_tag = "btn_"+(i+1)+"";
			if(request.getParameter(btn_tag)!=null){
				
				unfriending_username = request.getParameter("uname");
				String frnd_tag = "btn_"+(i+1)+"";
				unfriend_for = request.getParameter(frnd_tag);
				System.out.println(unfriending_username+"   "+unfriend_for);
				break;
			}
		}
		
		Login lg=new Login();
		lg.result = unfriending_username;
		try {
			System.out.println("going to unfriend");
			lg.unfriend(unfriend_for);
			System.out.println("afterunfriend");
			RequestDispatcher rd=request.getRequestDispatcher("view_friends.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
		
	}

}
