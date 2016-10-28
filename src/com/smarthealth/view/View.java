package com.smarthealth.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.smarthealth.connection.DBConnection;
import com.smarthealth.controller.Forum;
import com.smarthealth.controller.Login;
import com.smarthealth.controller.Registration;
import com.smarthealth.controller.Post;

public class View {

	public static void main(String args[]) throws NumberFormatException, IOException, SQLException
	{
		//Controller obj_connect = new Controller();
		//obj_connect.connect();
		int opt = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do{

			System.out.println("Welcome to SmartHealth. Please Login or Register to avail the "
					+ "services");
			System.out.println("Enter 1 to Register 2 to Login 3 to exit");
			opt = Integer.parseInt(br.readLine());
			switch(opt)
			{
			case 1:
				System.out.println("Enter Username");
				Registration obj_reg = new Registration();
				int check_uname = 0;
				String uname = new String();
				while(check_uname!=1)
				{
					uname = br.readLine();
					check_uname = obj_reg.check_uname(uname);
					if(check_uname==0){
						System.out.println("Duplicate username. Enter again");
					}
					else
						check_uname=1;
				}
				System.out.println("Enter Password");
				String pass = br.readLine();
				System.out.println("Enter Primary Email");
				Boolean b1 = false;
				String email1 = new String();
				while(b1!=true)
				{
					email1 = br.readLine();
					String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
					Boolean check = email1.matches(EMAIL_REGEX);
					if(check==true)
						b1=true;
					else
					{
						System.out.println("Invalid Email, Try again");
					}

				}
				System.out.println("Enter Secondary Email");
				Boolean b2 = false;
				String email2=new String();
				while(b2!=true)
				{
					email2 = br.readLine();
					String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
					Boolean check = email2.matches(EMAIL_REGEX);
					if(check==true && (email1.equals(email2)==false))
						b2=true;
					else
					{
						System.out.println("Invalid Email or same as primary email, Try again");
					}

				}
				//Entering the data into the database
				System.out.println("Enter First Name");
				String first_name = br.readLine();

				System.out.println("Enter Last Name");
				String last_name = br.readLine();

				System.out.println("Enter some data about yourself");
				String about_me = br.readLine();

				System.out.println("Enter Photo URL1");
				String pic_1 = br.readLine();

				System.out.println("Enter Photo URL2");
				String pic_2 = br.readLine();

				System.out.println("Enter Photo URL3");
				String pic_3 = br.readLine();

				System.out.println("Enter Street Number");
				String street_num = br.readLine();

				System.out.println("Enter Street Name");
				String street_name = br.readLine();

				System.out.println("Enter Municipality Area");
				String mun_party = br.readLine();

				System.out.println("Enter District");
				String gov_dist = br.readLine();

				System.out.println("Enter Postal Area");
				String pos_area = br.readLine();

				int user_type = 0;

				while(user_type<1 || user_type>3)
				{
					System.out.println("Enter User Type, 1- End User 2- Moderator 3- Admin");
					user_type = Integer.parseInt(br.readLine());
				}
				Registration obj = new Registration();
				obj.getdata(uname, pass, email1, email2, first_name, last_name, about_me, pic_1, 
						pic_2, pic_3, street_num, street_name, mun_party, gov_dist,
						pos_area, user_type);
				break; //breaking case for registration 

			case 2://case for login begins

				System.out.println("Please Enter your primary email and password");
				String email_login = br.readLine();
				String pass_login = br.readLine();
				Login obj_login = new Login();
				int login_status = Integer.parseInt(obj_login.login_into(email_login, pass_login).get(0));
				//if user exists then give feature of update and friend request
				if(login_status!=0)
				{
					int end_user_opt = 0;
					int forum_id = 0;
					do
					{
						System.out.println("Enter 1 to display details");
						System.out.println("Enter 2 to update details");
						System.out.println("Enter 3 to exit");
						if(login_status == 1){

							System.out.println("Enter 4 to display EndUser Usernames");
							System.out.println("Enter 5 to send friend request");
							System.out.println("Enter 6 to respond to friend requests");
							System.out.println("Enter 7 to display friends");
							System.out.println("Enter 8 to post on a forum or rating a post");
							//System.out.println("Enter 9 to rate a post");
							System.out.println("Enter 9 for Health data insertion");
							end_user_opt = Integer.parseInt(br.readLine());
							switch(end_user_opt){
							case 1:
								/*ResultSet user_rs = obj_login.user_details_print();
								user_rs.next();
								System.out.println("Username = "+user_rs.getString(1));
								System.out.println("Primary Email = "+user_rs.getString(2));
								System.out.println("Secondary Email = "+user_rs.getString(3));
								System.out.println("First Name = "+user_rs.getString(4));
								System.out.println("Last Name = "+user_rs.getString(5));
								System.out.println("About you = "+user_rs.getString(6));
								System.out.println("Photo Url 1 "+user_rs.getString(7));
								System.out.println("Photo Url 2 "+user_rs.getString(8));
								System.out.println("Photo Url 3 "+user_rs.getString(9));
								System.out.println("Street Number "+user_rs.getString(10));
								System.out.println("Street Name "+user_rs.getString(11));
								System.out.println("Major Municipality "+user_rs.getString(12));
								System.out.println("Governing District "+user_rs.getString(13));
								System.out.println("Postal Area "+user_rs.getString(14));
								System.out.println("Status "+user_rs.getString(15));
								System.out.println("Karma Score "+user_rs.getInt(16));
								break;*/
							case 2:
								System.out.println("Enter the attribute");
								String att = br.readLine();
								System.out.println("Enter the value");
								String update_val;
								if(att.equalsIgnoreCase("Email1")||att.equalsIgnoreCase("Email2"))
								{
									Boolean up_bool = false;
									update_val=new String();
									while(up_bool!=true)
									{
										update_val = br.readLine();
										String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
										Boolean check = update_val.matches(EMAIL_REGEX);
										if(check==true)
											up_bool=true;
										else
										{
											System.out.println("Invalid Email or same as primary email, Try again");
										}

									}
								}
								else
								{
									update_val = br.readLine();
								}

								obj_login.update_value(att,update_val);

								break;

							case 4:
								//obj_login.display_end_users();
								break;

							case 5:
								System.out.println("Enter the username you want to add as friend");
								String uname_to = br.readLine();
								obj_login.send_request(uname_to);
								break;

							case 6:
								System.out.println("Enter the username of the person you want to respond to");
								String uname_from = br.readLine();
								System.out.println("Enter 1 to accept 2 to reject");
								int resp = Integer.parseInt(br.readLine());
								obj_login.respond(uname_from,resp);
								break;
							case 7:
								//todo - diplay friends
								//obj_login.view_friends();								
								break;

							case 8:
								Forum obj1 = obj_login.obj;
								ResultSet rs = obj1.get_available_forums();
								ResultSet copy_rs = obj1.get_available_forums();
								//String created_by_moderator;
								rs.last(); 
								int total = rs.getRow();
								rs.beforeFirst();
								int k=0;
								if(total>0)
								{
									while(rs.next())
									{
										k++;
										System.out.println(k+"  Forum ID = "+rs.getInt(1)+ 
												"----Forum Topic = "+rs.getString(2)+
												"----Created By = "+rs.getString(7));
									}
									System.out.println("Enter a Forum ID");
									forum_id = Integer.parseInt(br.readLine());
									int flag = 0;
									while(copy_rs.next())
									{
										//To check whether the user has entered a valid ForumID 
										//System.out.println("Forum ID = "+copy_rs.getInt(1));
										if(forum_id == copy_rs.getInt(1));
										{
											//created_by_moderator = copy_rs.getString(7);
											flag = 1;
										}

									}
									//a valid forum ID was entered
									if(flag==1)
									{
										Post obj_post = new Post();
										obj_post.post_option_for_user(obj_login, forum_id);
									}
								}
								else 
									System.out.println("No forums available");
								
								break;

								//Health data case handled here
							case 9:
								System.out.println("Enter 1 for entering a new property");
								System.out.println("Enter 2 for entering some health data");
								System.out.println("Enter 3 for viewing your health data");
								System.out.println("Enter 4 for viewing your friend's health data");
								int health_opt = Integer.parseInt(br.readLine());
								//Health_data hd_obj = new Health_data();
								switch(health_opt){
								case 1:
									System.out.println("Enter a Property Name");
									String name = br.readLine();
									System.out.println("Enter some Description");
									String desc = br.readLine();
									obj_login.insert_property(name,desc);
									break;
								case 2:
									ResultSet rs1 = obj_login.view_all_property();
									while(rs1.next())
									{
										System.out.println("ID --> "+rs1.getInt(1)+"-- Name --> "+rs1.getString(2));
									}
									System.out.println("Insert property ID");
									int id = Integer.parseInt(br.readLine());
									rs1 = obj_login.view_all_property();
									int flag1 = 0;
									while(rs1.next())
									{
										if(id==rs1.getInt(1))
											flag1=1;
									}
									if(flag1==1)
									{
										System.out.println("Enter Value");
										String val = br.readLine();
										obj_login.insert_datum(id,val);
									}
									else
										System.out.println("Invalid Value Entered");
									break;
								case 3:
									obj_login.view_health_data();
									break;

								case 4:
									//todo - diplay friends
									//obj_login.view_friends();
									System.out.println("Enter Friend's name");
									String friend = br.readLine();
									ResultSet f_data = obj_login.view_health_data_friend(friend);
									while(f_data.next()){

										System.out.println("Property ID -->"+f_data.getString(1)+"  Value --->"+f_data.getString(2));
									}
									break;
								}
								break;


							}//end of switch end_user_opt
						}//if user logged in ends here

						//This is the case for Moderator
						else if(login_status == 2)
						{
							Forum obj1 = obj_login.obj;
							System.out.println("Enter 4 for creating a forum topic");
							System.out.println("Enter 5 to close a forum");
							end_user_opt = Integer.parseInt(br.readLine());
							switch(end_user_opt){
							case 1:
								/*ResultSet user_rs = obj_login.user_details_print();
								System.out.println("Username = "+user_rs.getString(1));
								System.out.println("Primary Email = "+user_rs.getString(2));
								System.out.println("Secondary Email = "+user_rs.getString(3));
								System.out.println("First Name = "+user_rs.getString(4));
								System.out.println("Last Name = "+user_rs.getString(5));
								System.out.println("About you = "+user_rs.getString(6));
								System.out.println("Photo Url 1 "+user_rs.getString(7));
								System.out.println("Photo Url 2 "+user_rs.getString(8));
								System.out.println("Photo Url 3 "+user_rs.getString(9));
								System.out.println("Street Number "+user_rs.getString(10));
								System.out.println("Street Name "+user_rs.getString(11));
								System.out.println("Major Municipality "+user_rs.getString(12));
								System.out.println("Governing District "+user_rs.getString(13));
								System.out.println("Postal Area "+user_rs.getString(14));
								System.out.println("Status "+user_rs.getString(15));
								System.out.println("Phone "+user_rs.getString(16));*/
								break;
							case 2:
								System.out.println("Enter the attribute");
								String att = br.readLine();
								System.out.println("Enter the value");
								String update_val;
								if(att.equalsIgnoreCase("Email1")||att.equalsIgnoreCase("Email2"))
								{
									Boolean up_bool = false;
									update_val=new String();
									while(up_bool!=true)
									{
										update_val = br.readLine();
										String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
										Boolean check = update_val.matches(EMAIL_REGEX);
										if(check==true)
											up_bool=true;
										else
										{
											System.out.println("Invalid Email or same as primary email, Try again");
										}

									}
								}
								else
								{
									update_val = br.readLine();
								}

								obj_login.update_value(att,update_val);

								break;

							case 4:
								System.out.println("Enter forum ID");
								int status_of_id = 0;
								
								forum_id = 0;
								while(status_of_id == 0)
								{
									forum_id = Integer.parseInt(br.readLine());
									
									status_of_id = obj1.call_for_id_check(forum_id);
									if(status_of_id == 0)
									{
										System.out.println("Duplicate forum ID. Please Enter again");
									}
								}

								System.out.println("Enter Topic");
								String topic = br.readLine();
								System.out.println("Enter link");
								String link = br.readLine();
								System.out.println("Enter summary");
								String summ = br.readLine();
								obj1.call_for_create_forum(forum_id,topic,link,summ);
								break;
							case 5:
								System.out.println("Currently present forums are --->");
								ResultSet rs = obj1.get_available_forums();
								rs.last(); 
								int total = rs.getRow();
								rs.beforeFirst();
								ResultSet copy_rs = obj1.get_available_forums();
								//String created_by_moderator;
								int k=0;
								if(total>0)
								{
									//Insert code here
									while(rs.next())
									{
										k++;
										System.out.println(k+"  Forum ID = "+rs.getInt(1)+ 
												"----Forum Topic = "+rs.getString(2)+
												"----Created By = "+rs.getString(7));
									}
									System.out.println("Enter a Forum ID");
									int forum_id1 = Integer.parseInt(br.readLine());
									int flag = 0;
									while(copy_rs.next())
									{
										//To check whether the user has entered a valid ForumID 
										//System.out.println("Forum ID = "+copy_rs.getInt(1));
										if(forum_id1 == copy_rs.getInt(1));
										{
											//created_by_moderator = copy_rs.getString(7);
											flag = 1;
										}

									}
									//a valid forum ID was entered
									if(flag==1)
									{
										obj_login.close_forum(forum_id1);
									}
								}

								else
									System.out.println("No forums available");

								break;
							}	
						}
						//This is the case for Administrator
						else if(login_status == 3)
						{
							end_user_opt = Integer.parseInt(br.readLine());
							switch(end_user_opt){
							case 1:
								/*ResultSet user_rs = obj_login.user_details_print();
								System.out.println("Username = "+user_rs.getString(1));
								System.out.println("Primary Email = "+user_rs.getString(2));
								System.out.println("Secondary Email = "+user_rs.getString(3));
								System.out.println("First Name = "+user_rs.getString(4));
								System.out.println("Last Name = "+user_rs.getString(5));
								System.out.println("About you = "+user_rs.getString(6));
								System.out.println("Photo Url 1 "+user_rs.getString(7));
								System.out.println("Photo Url 2 "+user_rs.getString(8));
								System.out.println("Photo Url 3 "+user_rs.getString(9));
								System.out.println("Street Number "+user_rs.getString(10));
								System.out.println("Street Name "+user_rs.getString(11));
								System.out.println("Major Municipality "+user_rs.getString(12));
								System.out.println("Governing District "+user_rs.getString(13));
								System.out.println("Postal Area "+user_rs.getString(14));
								System.out.println("Status "+user_rs.getString(15));
								System.out.println("Phone "+user_rs.getString(16));
								break;*/
							case 2:
								System.out.println("Enter the attribute");
								String att = br.readLine();
								System.out.println("Enter the value");
								String update_val;
								if(att.equalsIgnoreCase("Email1")||att.equalsIgnoreCase("Email2"))
								{
									Boolean up_bool = false;
									update_val=new String();
									while(up_bool!=true)
									{
										update_val = br.readLine();
										String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
										Boolean check = update_val.matches(EMAIL_REGEX);
										if(check==true)
											up_bool=true;
										else
										{
											System.out.println("Invalid Email or same as primary email, Try again");
										}

									}
								}
								else
								{
									update_val = br.readLine();
								}

								obj_login.update_value(att,update_val);

								break;
							}	
						}//logged_in ends here
					}while(end_user_opt!=3);

					if(login_status == 0)
					{
						System.out.println("Wrong data entered. Please register or try "
								+ "logging in again");
					}
					break;
				}//if login status ends here

			}//switch(opt) ends here

		}while(opt!=3);

		DBConnection.closeConnection();
	}

}
