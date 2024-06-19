package com.playlist;

import java.sql.Connection;

import java.sql.DriverManager;

public class DBconnect {
	 
	
	private static String url = "jdbc:mysql://localhost:3306/onlinemusicstore";
	private static String user = "root";
	private static String pass = "Mysql618#";
	private static Connection con;
	
	public static Connection getConnection() {
		//creating the database connection
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
			
		}catch(Exception e){
			
			System.out.println("Database connection is not successful");
			
		}
		
		return con;
	}
	

}
