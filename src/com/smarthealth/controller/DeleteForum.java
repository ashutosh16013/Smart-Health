package com.smarthealth.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteForum
 */
//@WebServlet("/DeleteForum")
public class DeleteForum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteForum() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		/*String accepting_username = request.getParameter("uname");
		String accepted_for = request.getParameter("friendname");
		
		Login lg=new Login();
		lg.result = accepting_username;
		try {
			lg.accept(accepted_for);
			RequestDispatcher rd=request.getRequestDispatcher("accept_reject.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}*/
		
		
		int size_of_list = Integer.parseInt(request.getParameter("size"));
		String closingusername= "";
		int forumid = 0;
		for(int i=0;i<size_of_list;i++)
		{
			String btn_tag = "btn_close_"+(i+1)+"";
			if(request.getParameter(btn_tag)!=null){
				
				closingusername = request.getParameter("uname");
				String forumidtag = "btn_close_"+(i+1)+"";
			    forumid = Integer.parseInt(request.getParameter(forumidtag));
				break;
			}
		}
		
		Login lg=new Login();
		//lg.result = accepting_username;
		try {
			lg.close_forum(forumid);
			RequestDispatcher rd=request.getRequestDispatcher("view_forums.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
		
		
		
	}
}
