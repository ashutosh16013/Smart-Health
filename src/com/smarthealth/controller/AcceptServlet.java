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
 * Servlet implementation class AcceptServlet
 */
//@WebServlet("/AcceptServlet")
public class AcceptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptServlet() {
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
		String accepting_username = "",accept_for = "";
		for(int i=0;i<size_of_list;i++)
		{
			String btn_tag = "btn_acc_"+(i+1)+"";
			if(request.getParameter(btn_tag)!=null){
				
				accepting_username = request.getParameter("uname");
				String frnd_tag = "btn_acc_"+(i+1)+"";
				accept_for = request.getParameter(frnd_tag);
				break;
			}
		}
		
		Login lg=new Login();
		lg.result = accepting_username;
		try {
			lg.accept(accept_for);
			RequestDispatcher rd=request.getRequestDispatcher("accept_reject.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
		
		
		
	}
	

}
