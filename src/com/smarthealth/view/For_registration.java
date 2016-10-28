package com.smarthealth.view;

import java.io.IOException;
import java.sql.SQLException;

public interface For_registration {
	
	void add_End_User(String uname) throws SQLException;
	
	void add_Moderator(String uname) throws SQLException, NumberFormatException, IOException;
	
	void add_Admin(String uname) throws SQLException, NumberFormatException, IOException;
	

}
