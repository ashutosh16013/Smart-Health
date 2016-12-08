package com.smarthealth.controller;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.smarthealth.connection.DBConnection;
import com.smarthealth.view.For_registration;

public class Registration implements For_registration{

	public void getdata(String uname,String pass, String email1, String email2, 
			String first_name, String last_name,  String about_me, 
			String pic_1, String pic_2, String pic_3,String street_num, String street_name, 
			String mun_party, String gov_dist, String pos_area, int user_type) throws 
	SQLException, NumberFormatException, IOException{
		//Initializing query for inserting into database
		//previous call to connect was here
		CallableStatement stmt = DBConnection.getConnection().prepareCall("{call add_user(?,?,?,?,?,?,?,?,?,?,?,?,?"
				+ ",?,?,?,?)}");
		int b = 1;
		stmt.setString(1, uname);
		stmt.setString(2, pass);
		stmt.setString(3, email1);
		stmt.setString(4, email2);
		stmt.setString(5, first_name);
		stmt.setString(6, last_name);
		stmt.setString(7, about_me);
		stmt.setString(8, pic_1);
		stmt.setString(9, pic_2);
		stmt.setString(10, pic_3);
		stmt.setString(11, street_num);
		stmt.setString(12, street_name);
		stmt.setString(13, mun_party);
		stmt.setString(14, gov_dist);
		stmt.setString(15, pos_area);
		stmt.setInt(16, user_type);
		stmt.setInt(17, b);

		if(user_type==1)
		{
			add_End_User(uname);
		}

		else if(user_type==2){

			add_Moderator(uname);
		}

		else
			add_Admin(uname);
		if(stmt.execute())
			System.out.println("Registration failed. Please try again");
		else
			System.out.println("Registration successful");
	}
	
	//Function to add extra parameters of End_User
	public void add_End_User(String uname) throws SQLException{

		CallableStatement stmt = DBConnection.getConnection().prepareCall("{call add_end_user(?,?)}");
		stmt.setString(1,uname);
		stmt.setInt(2, 0);
		stmt.execute();
	}
	
	//Function to add extra parameters of Moderator
	public void add_Moderator(String uname, String phone) throws SQLException, NumberFormatException, 
	IOException{
		
		CallableStatement stmt = DBConnection.getConnection().prepareCall("{call add_moderator(?,?)}");
		stmt.setString(1,uname);
		stmt.setString(2, phone);
		stmt.execute();
	}
	
	//Function to add extra parameters of Admin
	public void add_Admin(String uname, String phone)throws SQLException, NumberFormatException, 
	IOException{

		CallableStatement stmt = DBConnection.getConnection().prepareCall("{call add_Admin(?,?)}");
		stmt.setString(1,uname);
		stmt.setString(2, phone);
		stmt.execute();
	}
	
	//checks for the duplicate username by calling appropriate stored procedure
	public int check_uname(String uname) throws SQLException {
		// TODO Auto-generated method stub
		
		CallableStatement stmt = DBConnection.getConnection().prepareCall("{call check_dup_uname(?)}");
		stmt.setString(1, uname);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		String username = rs.getString(1);
		if(username.equals("found"))
		{
			return 0;
		}
		else
			return 1;
		
	}
	
	public int check_prim_email(String email) throws SQLException {
		// TODO Auto-generated method stub
		
		CallableStatement stmt = DBConnection.getConnection().prepareCall("{call check_email1(?)}");
		stmt.setString(1, email);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		String username = rs.getString(1);
		if(username.equals("found"))
		{
			return 0;
		}
		else
			return 1;
		
	}

	@Override
	public void add_Moderator(String uname) throws SQLException, NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add_Admin(String uname) throws SQLException, NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	
}
