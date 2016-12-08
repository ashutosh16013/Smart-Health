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
 * Servlet implementation class RejectServlet
 */
//@WebServlet("/RejectServlet")
public class RejectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RejectServlet() {
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
		String rejecting_username = "",reject_for = "";
		for(int i=0;i<size_of_list;i++)
		{
			String btn_tag = "btn_rej_"+(i+1)+"";
			if(request.getParameter(btn_tag)!=null){
				
				rejecting_username = request.getParameter("uname");
				String frnd_tag = "btn_rej_"+(i+1)+"";
				reject_for = request.getParameter(frnd_tag);
				break;
			}
		}
		
		Login lg=new Login();
		lg.result = rejecting_username;
		try {
			lg.reject(reject_for);
			RequestDispatcher rd=request.getRequestDispatcher("accept_reject.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}

}
