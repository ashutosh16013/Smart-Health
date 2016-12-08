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
 * Servlet implementation class CommentonPost
 */
//@WebServlet("/CommentonPost")
public class CommentonPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentonPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String comment = request.getParameter("tb_new_comment");
		String post = request.getParameter("post_uname");
		String time_post = request.getParameter("post_time");
		String uname = request.getParameter("uname");
		Login lg = new Login();
		lg.result=uname;
		try {
			lg.insert_comment(post, time_post, comment);
			RequestDispatcher rd=request.getRequestDispatcher("CommentandPosts.jsp");
  			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}

}
