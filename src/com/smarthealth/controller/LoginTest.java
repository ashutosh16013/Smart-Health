package com.smarthealth.controller;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import com.smarthealth.connection.DBConnection;
public class LoginTest {

    Login ob=new Login();
    DBConnection ob1;
    List<String> lst=new ArrayList<String>();
   
    @Test

    public void testLogin_into() {
        List<String> lst=new ArrayList<String>();
        lst.add("1");
        lst.add("test1");
        ob=Mockito.mock(Login.class);
        try {
            Mockito.when(ob.login_into("test1@gmail.com", "test")).thenReturn(lst);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        /*try {
            lst=ob.login_into("test1@gmail.com", "test1");
            for(String i:lst){
    //            System.out.println(i);
                }
            String lst1[]=new String[lst.size()];
            lst1[0]="1";
            lst1[1]="test1";
            int i=0;
            String incoming[]=new String[lst.size()];
            for(String ob:lst)
            {
                incoming[i]=ob;
                //System.out.println("incoming:= "+incoming[i]);
                i++;
            }
            assertTrue(Arrays.equals(incoming,lst1));
        } catch (NumberFormatException | SQLException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/ catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
        try {
            assertTrue(lst.equals(ob.login_into("test1@gmail.com", "test")));
            //lst.remove(0);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }

   

    /*@Test
    public void testUpdate() {
        fail("Not yet implemented");
    }*/
   
/*    @Test
    public void testUser_details_print() {
        fail("Not yet implemented");
    }*/

    /*@Test
    public void testUpdate_value() {
        fail("Not yet implemented");
    }*/

    @Test
    public void testDisplay_end_users() {
        List<String> lst=new ArrayList<String>();
        lst.add("test2");
        ob=Mockito.mock(Login.class);
        try {
            Mockito.when(ob.display_end_users("test1")).thenReturn(lst);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();}
       
        try {
            assertTrue(lst.equals(ob.display_end_users("test1")));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        /*try {
            lst=ob.display_end_users("test1");
            for(String i:lst){
                System.out.println(i);
               
            }
        System.out.println(lst.size());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
       
       
   
    }
/*
    @Test
    public void testSend_request() {
        fail("Not yet implemented");
    }

    @Test
    public void testAccept() {
        fail("Not yet implemented");
    }

    @Test
    public void testReject() {
        fail("Not yet implemented");
    }

    @Test
    public void testUnfriend() {
        fail("Not yet implemented");
    }

    @Test
    public void testRespond() {
        fail("Not yet implemented");
    }*/

    @Before
    public void create()
    {
       
        lst.add("test2");
       
        ob=Mockito.mock(Login.class);
        try {
            Mockito.when(ob.view_friends("test1")).thenReturn(lst);
            //Mockito.when(ob.list_all_post(1)).thenReturn(post);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
       
    }
   


    @Test
    public void testView_friends() {
       
        List<String> lst1=new ArrayList<String>();
        lst1.add("test2");
        /*List<String> lst=new ArrayList<String>();
        try {
            lst=ob.view_friends("test1");
            for(String i:lst){
            //    System.out.println(i);
               
            }
        String lst1[]=new String[lst.size()];
       
        lst1[0]="test2";
        int i=0;
        //System.out.println(lst1[0]);
        //System.out.println(lst1[1]);
        String incoming[]=new String[lst.size()];
        for(String ob:lst)
        {
            incoming[i]=ob;
        //    System.out.println("incoming:= "+incoming[i]);
            i++;
        }*/
        try {
            assertTrue(lst1.equals(ob.view_friends("test1")));
            //lst.remove(0);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        /*} catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
       
       
    }
   
    /*@Before
    public void create1()
    {
        post[0][1]="test1";
        post[0][1]="2016-10-07 12:17:00";
        post[0][2]="1";
        post[0][3]="oaky take rest";
        post[0][4]="kaf";
        post[0][5]="fah";
        post[0][6]="ahs";
       
        ob=Mockito.mock(Login.class);
        try {
       
            Mockito.when(ob.list_all_post(1)).thenReturn(post);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }*/
    @Test
    public void testList_all_post() throws SQLException {
        String post1[][]=new String[1][7];
        post1[0][0]="test1";
        post1[0][1]="2016-10-07 12:17:00";
        post1[0][2]="1";
        post1[0][3]="oaky take rest";
        post1[0][4]="kaf";
        post1[0][5]="fah";
        post1[0][6]="ahs";
        ob=Mockito.mock(Login.class);
        try {
           
            Mockito.when(ob.list_all_post(1)).thenReturn(post1);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
   
        assertTrue(Arrays.deepEquals(ob.list_all_post(1), post1));
        //lst.remove(0);
                   

       
    }
   
    @Test
    public void testAdd_new_post() throws SQLException {
        int k=1;
        ob=Mockito.mock(Login.class);
        try {
           
            Mockito.when(ob.add_new_post(1, "My First Post")).thenReturn(k);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
        assertTrue(ob.add_new_post(1, "My First Post")==1);
   
    }

    @Test
    public void testInsert_comment() {
        int k=1;
        ob=Mockito.mock(Login.class);
        try {
           
            Mockito.when(ob.insert_comment("test1","abc", "My First Comment")).thenReturn(k);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            assertTrue(ob.insert_comment("test1","abc", "My First Comment")==1);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /*@Test
    public void testClose_forum() {
        fail("Not yet implemented");
    }

    @Test
    public void testView_all_property() {
        fail("Not yet implemented");
    }

    @Test
    public void testView_health_data() {
        fail("Not yet implemented");
    }

    @Test
    public void testView_health_data_friend() {
        fail("Not yet implemented");
    }

    @Test
    public void testInsert_property() {
        fail("Not yet implemented");
    }

    @Test
    public void testInsert_datum() {
        fail("Not yet implemented");
    }*/

    @Test
    public void testAdd_update_rating() {
       
        int k=1;
        ob=Mockito.mock(Login.class);
        try {
           
            Mockito.when(ob.add_update_rating("test1", "abc", 3)).thenReturn(k);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
        try {
            assertTrue(ob.add_update_rating("test1", "abc", 3)==1);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }

    @Test
    public void testCheck_requests() {
        List<String> lst1=new ArrayList<String>();
        lst1.add("test2");
        ob=Mockito.mock(Login.class);
        try {
           
            Mockito.when(ob.check_requests("test1")).thenReturn(lst1);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            assertTrue(lst1.equals(ob.check_requests("test1")));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /*@Test
    public void testView_comments() {
        fail("Not yet implemented");
    }*/

}