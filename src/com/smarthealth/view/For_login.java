package com.smarthealth.view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface For_login {
	
	public List<String> login_into(String email_login, String pass_login) 
			throws SQLException, NumberFormatException, IOException;

}
