package com.smarthealth.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Post {
	
		public void post_option_for_user(Login obj_login, int forum_id) throws SQLException, NumberFormatException, IOException{
			
			ResultSet rs;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String [][]arr_for_comment = new String[50][2];
			System.out.println("Enter 1 to comment on an existing Post");
			System.out.println("Enter 2 to give a new Post");
			System.out.println("Enter 3 to rate a post");
			int op_for_post = Integer.parseInt(br.readLine());
			switch(op_for_post)
			{
			case 1:
				rs = obj_login.list_all_post(forum_id);
				int index=0;
				rs.last(); 
				int total = rs.getRow();
				rs.beforeFirst();
				if(total>0)
				{
					while(rs.next())
					{
						index++;
						System.out.println("Index = "+index+"-----Forum ID = "+rs.getInt(3)+ 
								"----Commenter Username = "+rs.getString(1));
						arr_for_comment[index][0] = rs.getString(1);
						arr_for_comment[index][1] = rs.getString(2);
					}
					System.out.println("Enter the Index of the Post");
					int in_comment = Integer.parseInt(br.readLine());
					if(in_comment<=index)
					{
						String user = arr_for_comment[in_comment][0];
						String timestamp = arr_for_comment[in_comment][1];
						System.out.println("Enter your comment");
						String text = br.readLine();
						System.out.println("Enter your PhotoURL");
						String photo = br.readLine();
						System.out.println("Enter your LinkURL");
						String link = br.readLine();
						System.out.println("Enter your VideoURL");
						String video = br.readLine();
						int result = obj_login.insert_comment(user,timestamp,text,photo,link,video);
						if(result == 1)
							System.out.println("Successfully Commented");
						else
							System.out.println("Can't comment. Please try again");
					}
					else
						System.out.println("You didnt enter a valid index");
					
				}
				
				else
					System.out.println("No posts exist");
				
				
				break;
			case 2:
				System.out.println("Please Enter Some text");
				String post = br.readLine();
				System.out.println("Please Enter Photo location");
				String photo1 = br.readLine();
				System.out.println("Please Enter Some Link location");
				String link1 = br.readLine();
				System.out.println("Please Enter Some Video location");
				String video1 = br.readLine();
				int res = obj_login.add_new_post(forum_id,post,photo1,link1,video1);
				if(res==1)
					System.out.println("Successfully added your post");
				else
					System.out.println("Can't add. Please try again");
				break;
				
				//Case for rating a post
			case 3:
				rs = obj_login.list_all_post(forum_id);
				int index1=0;
				rs.last(); 
				int total1 = rs.getRow();
				rs.beforeFirst();
				if(total1>0)
				{
					while(rs.next())
					{
						index1++;
						System.out.println("Index = "+index1+"-----Forum ID = "+rs.getInt(3)+ 
								"----Commenter Username = "+rs.getString(1));
						arr_for_comment[index1][0] = rs.getString(1);
						arr_for_comment[index1][1] = rs.getString(2);
					}
					System.out.println("Enter the Index of the Post");
					int in_comment = Integer.parseInt(br.readLine());
					if(in_comment<=index1)
					{
						String user = arr_for_comment[in_comment][0];
						String timestamp = arr_for_comment[in_comment][1];
						System.out.println("Enter the number of stars");
						int stars = Integer.parseInt(br.readLine());
						if(stars<=5&&stars>0)
						{
							//Rate a post
							int result = obj_login.add_update_rating(user,timestamp,stars);
							if(result==1)
								System.out.println("Successfully rated");
							else
								System.out.println("Can't rate. Please try again");
												
						}
						else
							System.out.println("Please enter a valid rating");
					}
					else
						System.out.println("You didnt enter a valid index");
					
				}
				
				else
					System.out.println("No posts exist");
				break;
			}
		}

}
