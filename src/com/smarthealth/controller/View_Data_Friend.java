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
 * Servlet implementation class View_Data_Friend
 */
//@WebServlet("/View_Data_Friend")
public class View_Data_Friend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View_Data_Friend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("uname");
		int size_of_list = Integer.parseInt(request.getParameter("size"));
		String frnd_name = "";
		for(int i=0;i<size_of_list;i++)
		{
			String btn_tag = "btn_"+(i+1)+"";
			if(request.getParameter(btn_tag)!=null){
				
				String frnd_tag = "btn_"+(i+1)+"";
				frnd_name = request.getParameter(frnd_tag);
				break;
			}
		}
		
		Login lg = new Login();
		lg.result = username;
		try {
			String arr_of_frnd[][] = lg.view_health_data_friend(frnd_name);
			String arr_of_user[][] = lg.view_health_data();
			request.setAttribute("user", arr_of_user);
			request.setAttribute("frnd", arr_of_frnd);
			request.setAttribute("username", username);
			request.setAttribute("frndname", frnd_name);
			RequestDispatcher rd = request.getRequestDispatcher("view_frnd_data.jsp");
			rd.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			response.sendRedirect("error.html");
			//e.printStackTrace();
		}
	}

}
