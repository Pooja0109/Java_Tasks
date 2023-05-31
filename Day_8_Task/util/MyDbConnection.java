package com.dedalus.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDbConnection {
	static Connection con;
	public static Connection getMyConnection()
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
		System.out.println(getMyConnection());
		
	}

}
