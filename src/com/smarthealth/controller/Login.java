package com.smarthealth.controller;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smarthealth.connection.DBConnection;
import com.smarthealth.connection.Query_with_return;
import com.smarthealth.connection.Query_without_return;
import com.smarthealth.view.For_login;
import com.smarthealth.connection.Query_with_bool_return;

public class Login implements For_login{

	
	public String result;
	protected int uid; 
	public Forum obj;
	public List<String> login_into(String email_login, String pass_login) 
			throws SQLException, NumberFormatException, IOException {
		// TODO Auto-generated method stub
		List<String> list;
		CallableStatement stmt = DBConnection.getConnection().prepareCall("{call login_check(?,?)}");
		stmt.setString(1, email_login);
		stmt.setString(2, pass_login);
		ResultSet rs = Query_with_return.function_with_return(stmt);
		rs.next();
		result =rs.getString(1);
		obj = new Forum();
		obj.result = result;
		uid = rs.getInt(2);
		//checking for the returned result from stored function
		if(result.equals("not found"))
		{
			System.out.println("We do not have your details. Please Register");
			list = new ArrayList<String>();
			list.add("0");
			return(list);
		}
		else
		{
			System.out.println("WELCOME "+result+"\nPlease select an appropriate"
					+ " option to proceed");
			list = new ArrayList<String>();
			list.add(uid+"");
			list.add(result);
			return(list);
			
		}
	}
	
	public void update(String uname, String pass, String email1, String email2, 
			String first_name, String last_name,  String about_me, 
			String pic_1, String pic_2, String pic_3,String street_num, String street_name, 
			String mun_party, String gov_dist, String pos_area) throws SQLException{
		
		
		//update the user details
		
		CallableStatement stmt = DBConnection.getConnection().prepareCall("{call update_profile(?,?,?,?,?,?,?,?,?,?,?,?,?,?"
				+ ",?)}");
		stmt.setString(1, uname);
		stmt.setString(2, email1);
		stmt.setString(3, email2);
		stmt.setString(4, first_name);
		stmt.setString(5, last_name);
		stmt.setString(6, about_me);
		stmt.setString(7, pic_1);
		stmt.setString(8, pic_2);
		stmt.setString(9, pic_3);
		stmt.setString(10, street_num);
		stmt.setString(11, street_name);
		stmt.setString(12, mun_party);
		stmt.setString(13, gov_dist);
		stmt.setString(14, pos_area);
		stmt.setString(15, pass);
		
		stmt.execute();

		
		
	}
	
	//Modify this function
	public List<String> user_details_print(String uname, int id) throws SQLException{
		
		CallableStatement stmt =DBConnection.getConnection().prepareCall("{call login_details(?,?)}");
		result = uname;
		uid = id;
		stmt.setString(1, result);
		stmt.setInt(2,uid);
		ResultSet rs_user_details = Query_with_return.function_with_return(stmt);
		List<String> lst=new ArrayList<String>();
		int i = 1;
		 ResultSetMetaData rsmd = rs_user_details.getMetaData();
		 //String name = rsmd.getColumnName(1);
		int num_column = rsmd.getColumnCount();
		while (rs_user_details.next()) {
	        for (i = 1; i <= num_column; i++) {
	        	lst.add( rs_user_details.getString(i));
	        }
	        System.out.println();

	    }
		return lst;
	}

	public void update_value(String att, String update_val) throws SQLException {
		// TODO Auto-generated method stub
		CallableStatement stmt = DBConnection.getConnection().prepareCall("{call alter_table(?,?,?,?)}");
		stmt.setString(1, result);
		stmt.setString(2, att);
		stmt.setString(3,update_val);
		stmt.setInt(4, uid);
		Query_without_return.function_without_return(stmt);;		
	}

	public List<String> display_end_users(String uname) throws SQLException {
		// TODO Auto-generated method stub
		CallableStatement stmt =DBConnection.getConnection().prepareCall("{call users_to_send(?)}");
		stmt.setString(1, uname);
		ResultSet rs_end_display = Query_with_return.function_with_return(stmt);	
		List<String> lst=new ArrayList<String>();
		while(rs_end_display.next()){
			lst.add(rs_end_display.getString(1));
			System.out.println("Username = "+rs_end_display.getString(1));
		}
		return lst;
	}

	public void send_request(String uname_to) throws SQLException {
		// TODO Auto-generated method stub			
		CallableStatement stmt =DBConnection.getConnection().prepareCall("{call send_friend_request(?,?)}");
		stmt.setString(1, result);
		stmt.setString(2, uname_to);
		System.out.println(result + "  " + uname_to);
		if(Query_with_bool_return.function_for_bool_return(stmt))
			System.out.println("Request Successfully sent");
		else
			System.out.println("Request not sent. Please try again");
	}
	
	public void accept(String uname) throws SQLException{
		
		CallableStatement stmt = DBConnection.getConnection().prepareCall("{call accept_friend_request(?,?)}");
		stmt.setString(1, result);
		stmt.setString(2, uname);
		Query_without_return.function_without_return(stmt);
	}
	
	public void reject(String uname) throws SQLException{
		
		CallableStatement stmt = DBConnection.getConnection().prepareCall("{call reject_friend_request(?,?)}");
		stmt.setString(1, result);
		stmt.setString(2, uname);
		Query_without_return.function_without_return(stmt);
	}
	
	public void unfriend(String uname) throws SQLException{
		
		CallableStatement stmt = DBConnection.getConnection().prepareCall("{call unfriend_user(?,?)}");
		stmt.setString(1, result);
		stmt.setString(2, uname);
		System.out.println("In in unfriend function" + result+" "+ uname);
		Query_without_return.function_without_return(stmt);
	}

	public void respond(String uname_from, int resp) throws SQLException {
		// TODO Auto-generated method stub
		if(resp == 1){
			CallableStatement stmt = DBConnection.getConnection().prepareCall("{call accept_friend_request(?,?)}");
			stmt.setString(1, result);
			stmt.setString(2, uname_from);
			Query_without_return.function_without_return(stmt);
		}
		if(resp==2)
		{
			CallableStatement stmt = DBConnection.getConnection().prepareCall("{call reject_friend_request(?,?)}");
			stmt.setString(1, result);
			stmt.setString(2, uname_from);
			Query_without_return.function_without_return(stmt);	
		}
					
	}
	
	/**
	 * @param uname
	 * @return
	 * @throws SQLException
	 */
	public List<String> view_friends(String uname) throws SQLException{
		
		result = uname;
		CallableStatement stmt = DBConnection.getConnection().prepareCall("{call view_friends(?)}");
		stmt.setString(1, result);
		System.out.println(result);
		ResultSet rs = Query_with_return.function_with_return(stmt);
		List<String> lst=new ArrayList<String>();
		while(rs.next()){
			
			String uname_1 = rs.getString(1);
			String uname_2 = rs.getString(2);
			if(uname_1.equals(result))
				lst.add(uname_2);
			else
				lst.add(uname_1);
		}
		return lst;
	}
	
	//from here
	
	/*public void call_for_create_forum(int forum_id, String topic, String link, String summ ) throws 
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

	//to here
	 * 
	 * 
	 */
	
	public String [][] list_all_post(int forum_id) throws SQLException {
		// TODO Auto-generated method stub
		
		CallableStatement stmt = DBConnection.getConnection().prepareCall("{call list_post_for_forum(?)}");
		stmt.setInt(1, forum_id);
		ResultSet rs = Query_with_return.function_with_return(stmt);
		
		rs.last(); 
		int total = rs.getRow(),i=0;
		rs.beforeFirst();
		String [][] post = new String[total][6];
		
		while(rs.next()){
			
			post[i][0] = rs.getString(1);
			post[i][1] = Integer.toString(rs.getInt(3));
			post[i][2] = rs.getString(4);
			post[i][3] = rs.getString(5);
			post[i][4] = rs.getString(6);
			post[i][5] = rs.getString(2);//contains timestamp
			i++;
			
		}
		rs.beforeFirst();
		for(i=0;i<total;i++){
			
			System.out.println(post[i][0]+" "+post[i][1]+" "+post[i][2]+" "+post[i][3]+" "+post[i][4]);
		}
		return post;
	}


	public int add_new_post(int forum_id, String post) throws SQLException {
		// TODO Auto-generated method stub
		CallableStatement stmt = DBConnection.getConnection().prepareCall("{call add_new_post(?,?,?,?,?,?)}");
		stmt.setString(1, result);
		stmt.setInt(2, forum_id);
		stmt.setString(3,post);
		stmt.setString(4, "photo");
		stmt.setString(5, "link");
		stmt.setString(6, "video");
		if(Query_with_bool_return.function_for_bool_return(stmt)){
			return 1;
		}
		else
			return 0;
	}

	public int insert_comment(String user, String timestamp, String text) throws SQLException {
		// TODO Auto-generated method stub
		CallableStatement stmt = DBConnection.getConnection().prepareCall("{call add_new_comment(?,?,?,?,?,?,?)}");
		stmt.setString(1, user);
		stmt.setString(2, timestamp);
		stmt.setString(3, result);
		stmt.setString(4, text);
		stmt.setString(5, "photo");
		stmt.setString(6, "link");
		stmt.setString(7, "video");
		if(Query_with_bool_return.function_for_bool_return(stmt)){
			return 1;
		}
		else
			return 0;
		
	}

	public void close_forum(int forum_id) throws SQLException {
		// TODO Auto-generated method stub
		CallableStatement stmt = DBConnection.getConnection().prepareCall("{call close_forum(?)}");
		stmt.setInt(1, forum_id);
		if(Query_with_bool_return.function_for_bool_return(stmt))
		{
			System.out.println("Successfully closed");
		}
		else
			System.out.println("Problem encountered. Please try again");
		
	}

	public ResultSet view_all_property()throws SQLException {
		
		CallableStatement stmt = DBConnection.getConnection().prepareCall("{call view_prop()}");
		ResultSet rs = Query_with_return.function_with_return(stmt);
		return(rs);
		
	}

	public String[][] view_health_data() throws SQLException {
		
		CallableStatement stmt = DBConnection.getConnection().prepareCall("{call view_datum(?)}");
		stmt.setString(1, result);
		ResultSet rs = Query_with_return.function_with_return(stmt);
		rs.last(); 
		int total = rs.getRow(),i=0;
		rs.beforeFirst();
		String [][] comment = new String[total][2];
		
		while(rs.next()){
			
			comment[i][0] = rs.getString(1);
			comment[i][1] = rs.getString(2);
			i++;
			
		}
		rs.beforeFirst();
		return comment;
	}

	public String[][] view_health_data_friend(String fname) throws SQLException {
		
		CallableStatement stmt = DBConnection.getConnection().prepareCall("{call view_datum(?)}");
		stmt.setString(1, fname);
		ResultSet rs = Query_with_return.function_with_return(stmt);
		rs.last(); 
		int total = rs.getRow(),i=0;
		rs.beforeFirst();
		String [][] comment = new String[total][2];
		
		while(rs.next()){
			
			comment[i][0] = rs.getString(1);
			comment[i][1] = rs.getString(2);
			i++;
			
		}
		rs.beforeFirst();
		return comment;
	}

	public void insert_property(String name, String desc) throws SQLException {

		CallableStatement stmt = DBConnection.getConnection().prepareCall("{call insert_prop(?,?)}");
		stmt.setString(1, name);
		stmt.setString(2, desc);
		if(Query_with_bool_return.function_for_bool_return(stmt))
			System.out.println("Inserted property successfully");
		else
			System.out.println("Problem encountered. Please try again");	
	}

	public void insert_datum(int id, String val) throws SQLException {
		
		CallableStatement stmt = DBConnection.getConnection().prepareCall("{call insert_datum(?,?,?)}");
		stmt.setString(1, result);
		stmt.setInt(2, id);
		stmt.setString(3, val);
		if(Query_with_bool_return.function_for_bool_return(stmt))
			System.out.println("Successfully Inserted Datum");
		else
			System.out.println("Problem encountered. Please try again");
	}

	/**
	 * @param user
	 * @param timestamp
	 * @param stars
	 * @return
	 * @throws SQLException
	 */
	public int add_update_rating(String user, String timestamp, int stars) throws SQLException {
		// TODO Auto-generated method stub
		CallableStatement stmt = DBConnection.getConnection().prepareCall("{call add_update_rating(?,?,?,?)}");
		stmt.setString(1, user);
		stmt.setString(2, timestamp);
		stmt.setString(3, result);
		stmt.setInt(4, stars);
		if(Query_with_bool_return.function_for_bool_return(stmt))
		{
			return 1;
		}
		else 
			return 0;
	}
	
	/**
	 * @param uname
	 * @return
	 * @throws SQLException
	 */
	public List<String> check_requests(String uname) throws SQLException{
		
		CallableStatement stmt =DBConnection.getConnection().prepareCall("{call check_friend_request(?)}");
		stmt.setString(1, uname);
		ResultSet rs_end_display = Query_with_return.function_with_return(stmt);	
		List<String> lst=new ArrayList<String>();
		while(rs_end_display.next()){
			lst.add(rs_end_display.getString(1));
			System.out.println("Username = "+rs_end_display.getString(1));
		}
		return lst;
		
		
	}
	
	/**
	 * function to return all the comments on a post
	 * @param uname
	 * @param time
	 * @return
	 * @throws SQLException
	 */
	public String[][] view_comments(String uname,String time) throws SQLException{
		
		CallableStatement stmt =DBConnection.getConnection().prepareCall("{call view_comment_on_post(?,?)}");
		stmt.setString(1, uname);
		stmt.setString(2, time);
		ResultSet rs = Query_with_return.function_with_return(stmt);
		rs.last(); 
		int total = rs.getRow(),i=0;
		rs.beforeFirst();
		String [][] comment = new String[total][3];
		
		while(rs.next()){
			
			comment[i][0] = rs.getString(3);
			comment[i][1] = rs.getString(4);
			comment[i][2] = rs.getString(5);
			i++;
			
		}
		rs.beforeFirst();
		for(i=0;i<total;i++){
			
			//System.out.println(comment[i][0]+" "+comment[i][1]+" "+comment[i][2]+" "+comment[i][3]+" "+comment[i][4]);
		}
		return comment;
	}
	
	public void add_qualification(String uname, int qual_id) throws SQLException{
		
		CallableStatement stmt =DBConnection.getConnection().prepareCall("{call add_qualification(?,?)}");
		stmt.setInt(1, qual_id);
		stmt.setString(2, uname);
		stmt.execute();
	}
	
	public String[][] view_qualification(String uname) throws SQLException{
		
		CallableStatement stmt =DBConnection.getConnection().prepareCall("{call view_qualification(?)}");
		stmt.setString(1, uname);
		ResultSet rs = Query_with_return.function_with_return(stmt);
		rs.last(); 
		int total = rs.getRow(),i=0;
		rs.beforeFirst();
		String [][] qualification = new String[total][3];
		
		while(rs.next()){
			
			qualification[i][0] = rs.getString(1);
			qualification[i][1] = rs.getString(2);
			qualification[i][2] = rs.getString(3);
			i++;
			
		}
		return qualification;
	}

	public void upload_pic(String[] name) throws SQLException {
		// TODO Auto-generated method stub
		CallableStatement stmt =DBConnection.getConnection().prepareCall("{call add_photos(?,?,?,?)}");
		stmt.setString(1, result);
		stmt.setString(2, name[0]);
		stmt.setString(3, name[1]);
		stmt.setString(4, name[2]);
		stmt.execute();
		
	}
	
	public void upload_pic1(String name) throws SQLException {
		// TODO Auto-generated method stub
		CallableStatement stmt =DBConnection.getConnection().prepareCall("{call add_photo1(?,?)}");
		stmt.setString(1, result);
		stmt.setString(2, name);
		stmt.execute();
		
	}
	
	public void upload_pic2(String name) throws SQLException {
		// TODO Auto-generated method stub
		CallableStatement stmt =DBConnection.getConnection().prepareCall("{call add_photo2(?,?)}");
		stmt.setString(1, result);
		stmt.setString(2, name);
		stmt.execute();
		
	}
	public void upload_pic3(String name) throws SQLException {
		// TODO Auto-generated method stub
		CallableStatement stmt =DBConnection.getConnection().prepareCall("{call add_photo3(?,?)}");
		stmt.setString(1, result);
		stmt.setString(2, name);
		stmt.execute();
		
	}
	
	public String[] fetch_pics(String name) throws SQLException {
		// TODO Auto-generated method stub
		CallableStatement stmt =DBConnection.getConnection().prepareCall("{call fetch_pics(?)}");
		stmt.setString(1, name);
		ResultSet rs = Query_with_return.function_with_return(stmt);
		String[] pics = new String[3];
		rs.last(); 
		int total = rs.getRow(),i=0;
		rs.beforeFirst();
		
		while(rs.next()){
			
			pics[0] = rs.getString(1);
			pics[1] = rs.getString(2);
			pics[2] = rs.getString(3);
			i++;
			
		}
		return pics;
		
	}
	
}
