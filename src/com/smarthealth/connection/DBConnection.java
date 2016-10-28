package com.smarthealth.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {
	
	private static Connection con;
	
	public static Connection getConnection(){
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/smarthealthdb","root","ashutosh");
		 
		}
		catch(Exception e){ 
			System.out.println("Error in database connection");
		
		
		}
		
	return con;

	}
	
	public static void closeConnection() throws SQLException
	{
		if(con !=null)
		{
			con.close();
		}
		
	}
	
	
	

}
