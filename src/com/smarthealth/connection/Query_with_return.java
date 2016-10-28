package com.smarthealth.connection;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Query_with_return {
	
	public static ResultSet function_with_return(CallableStatement stmt) throws SQLException{
		
		ResultSet rs = stmt.executeQuery();
		return(rs);
	}

}
