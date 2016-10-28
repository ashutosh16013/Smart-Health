package com.smarthealth.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Servlet implementation class FriendRequist
 */
//@WebServlet("/FriendRequest")
public class FriendRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int size_of_list = Integer.parseInt(request.getParameter("size"));
		String unfriending_username = "",send_to = "";
		for(int i=0;i<size_of_list;i++)
		{
			String btn_tag = "btn_"+(i+1)+"";
			if(request.getParameter(btn_tag)!=null){
				
				unfriending_username = request.getParameter("uname");
				String frnd_tag = "btn_"+(i+1)+"";
				send_to = request.getParameter(frnd_tag);
				System.out.println("Friend Tag =  "+frnd_tag);
				System.out.println(unfriending_username+"   "+send_to);
				break;
			}
		}
		
		Login lg=new Login();
		lg.result = unfriending_username;
		try {
			lg.send_request(send_to);
			RequestDispatcher rd=request.getRequestDispatcher("view_users_to_send.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
