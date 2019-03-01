package org.cxw.setup;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import  java.sql.Connection;

public class DBConnection {
	
	
	public static void DBConnect(){
		
		//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
        String dbUrl = "jdbc:mysql://10.33.2.111:3306/cxw_administration";					

		//Database Username		
		String username = "cxwork";	
        
		//Database Password		
		String password = "CXwork123";				

		//Query to Execute		
		String query = " Update BusinessUser Set Password = '388a6c9598cbd0957830efac559e448af8a657426f8d902699299ad4045db9c4', Salt = 'fdcdc036ec57e955', IsActive = 1, IsVerified = 1 Where id = (Select ID from (Select * from BusinessUser) as x Where Email ='regressionautobusinessuser@gmail.com' ORDER BY ID DESC LIMIT 1);";		
		
		//Load mysql jdbc driver		
   	    try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			Connection con = DriverManager.getConnection(dbUrl,username,password);
				
		//Create Statement Object		
 	     Statement stmt = con.createStatement();					

			// Execute the SQL Query. Store results in ResultSet		
  	   stmt.executeUpdate(query);							
  
  				
  	   	  
			 // closing DB Connection		
			con.close();	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
		
		
	
