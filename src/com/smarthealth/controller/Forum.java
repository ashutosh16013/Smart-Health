package com.smarthealth.controller;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.smarthealth.connection.DBConnection;
import com.smarthealth.connection.Query_with_bool_return;
import com.smarthealth.connection.Query_with_return;

public class Forum {
	
	public String result;

	public void call_for_create_forum(int forum_id, String topic, String link, String summ ) throws 
	SQLException {
		// TODO Auto-generated method stub
		
		CallableStatement stmt = DBConnection.getConnection().prepareCall("{call create_forum(?,?,?,?,?)}");
		stmt.setInt(1, forum_id);
		stmt.setString(2,topic);
		stmt.setString(3, link);
		stmt.setString(4, summ);
		stmt.setString(5, result);
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

	public ResultSet get_available_forums() throws SQLException {
		
		CallableStatement stmt = DBConnection.getConnection().prepareCall("{call list_all_forum()}");
		ResultSet rs = Query_with_return.function_with_return(stmt);			
		return rs;
		// TODO Auto-generated method stub
		
	}

}
