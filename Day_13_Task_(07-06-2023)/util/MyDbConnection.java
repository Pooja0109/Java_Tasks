package com.dedalus.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MyDbConnection {
private static MyDbConnection instance=null;
	Connection con;
	
	private MyDbConnection()
	{
		//private constructor 
	}
	
	public static MyDbConnection getInstance()
	{
		if(instance==null)
		{
			instance = new MyDbConnection();
		}
		return instance;
	}
	public Connection getMyConnection()
	{
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Hello123");
			System.out.println(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static void main(String[] args) {
	
	}

}
