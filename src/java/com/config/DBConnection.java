/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ram
 */
public class DBConnection {
    public static Connection createConnection()
    {
    	Connection con = null;
        String URL = "jdbc:mysql://localhost:3306/vsolution? useSSL=false";
        String user = "root";
        String password = "mynewpassword";
 
    try
    {
    	try {
    	    Class.forName("com.mysql.cj.jdbc.Driver");
    	} catch (ClassNotFoundException e1) {
    	    e1.printStackTrace();
    	}
        
        con = DriverManager.getConnection(URL, user, password);
    }
    catch (SQLException e)
    {
    	 System.out.println("An error occurred. Maybe user/password is invalid");
         e.printStackTrace();
    }
    
	return con;
    }
}
