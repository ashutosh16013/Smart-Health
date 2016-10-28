package com.smarthealth.connection;

import java.sql.CallableStatement;
import java.sql.SQLException;

public class Query_with_bool_return {
	
	public static Boolean function_for_bool_return(CallableStatement stmt) throws SQLException
	{
		if(!stmt.execute())
			return true;
		else
			return false;
	}
	

}
