package com.smarthealth.connection;

import java.sql.CallableStatement;
import java.sql.SQLException;

public class Query_without_return {
	
	public static void function_without_return(CallableStatement stmt) throws SQLException
	{
		stmt.execute();
	}

}
