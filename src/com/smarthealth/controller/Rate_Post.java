package com.smarthealth.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Rate_Post
 */
//@WebServlet("/Rate_Post")
public class Rate_Post extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rate_Post() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname = request.getParameter("uname");
		String creator = request.getParameter("uname_creator");
		System.out.println(request.getParameter("rating"));
		int rating = Integer.parseInt(request.getParameter("rating"));
		String timestamp = request.getParameter("timestamp");
		Login lg = new Login();
		lg.result = uname;
		try {
			System.out.println(uname+" "+creator+" "+rating+" "+timestamp);
			lg.add_update_rating(creator, timestamp, rating);
			RequestDispatcher rd = request.getRequestDispatcher("CommentandPosts.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}

}
