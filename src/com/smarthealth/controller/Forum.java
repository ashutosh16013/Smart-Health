package com.smarthealth.controller;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.smarthealth.connection.DBConnection;
import com.smarthealth.connection.Query_with_bool_return;
import com.smarthealth.connection.Query_with_return;

public class Forum {
	
	public String result;

	public void call_for_create_forum(String topic,String summ) throws 
	SQLException {
		// TODO Auto-generated method stub
		
		CallableStatement stmt = DBConnection.getConnection().prepareCall("{call spCreateForum(?,?,?)}");
		stmt.setString(1, topic);
		stmt.setString(2,summ);
		stmt.setString(3, result);
		if(Query_with_bool_return.function_for_bool_return(stmt))
			System.out.println("Forum created successfully");
		else
			System.out.println("Couldn't create forum. Try again");
	}

	public int call_for_id_check(int forum_id) throws SQLException {
		
		CallableStatement stmt = DBConnection.getConnection().prepareCall("{call forum_id_check(?)}");
		stmt.setInt(1, forum_id);
		ResultSet rs = Query_with_return.function_with_return(stmt);
		rs.next();
		if(rs.getString(1).equals("found"))
			return 0;
		else
			return 1;
		// TODO Auto-generated method stub
		
	}

	//This function lists all forums for moderators
	public String [][] get_available_forums() throws SQLException {
		
		CallableStatement stmt = DBConnection.getConnection().prepareCall("{call list_all_forum()}");
		ResultSet rs = Query_with_return.function_with_return(stmt);
		rs.last(); 
		int total = rs.getRow(),i=0;
		rs.beforeFirst();
		String [][] forum = new String[total][2];
		
		while(rs.next()){
			
			forum[i][0] = rs.getString(1);
			forum[i][1] = rs.getString(2);
			i++;
			
		}
		rs.beforeFirst();
		for(i=0;i<total;i++){
			
			System.out.println(forum[i][0]+" "+forum[i][1]);
		}
		return forum;
	}

}
