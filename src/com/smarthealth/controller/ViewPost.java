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
 * Servlet implementation class ViewPost
 */
@WebServlet("/ViewPost")
public class ViewPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPost() {
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
  			lg.reject(accepted_for);
  			RequestDispatcher rd=request.getRequestDispatcher("accept_reject.jsp");
  			rd.forward(request, response);
  		} catch (SQLException e) {
  			
  			e.printStackTrace();
  		}*/
      	
      	int size_of_list = Integer.parseInt(request.getParameter("size"));
  		String posting_username = "";
  		int forumid=0;
  		for(int i=0;i<size_of_list;i++)
  		{
  			String btn_tag = "btn_post_"+(i+1)+"";
  			if(request.getParameter(btn_tag)!=null){
  				
  				posting_username = request.getParameter("uname");
  				String post_tag = "btn_post_"+(i+1)+"";
  				forumid= Integer.parseInt(request.getParameter(post_tag));
  				break;
  			}
  		}
  		
  		Login lg=new Login();
  		try {
  			String list1[][]=lg.list_all_post(forumid);
  			request.setAttribute("posts", list1);
  			request.setAttribute("forum_id", forumid);
  			RequestDispatcher rd=request.getRequestDispatcher("CommentandPosts.jsp");
  			rd.forward(request, response);
  		} catch (SQLException e) {
  			
  			e.printStackTrace();
  			response.sendRedirect("error.html");
  		}
  	}
}
