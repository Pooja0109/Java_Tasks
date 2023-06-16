package com.dedalus.Day18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Day_18_Task {
	
	private String urlName;
	private String uname;
	private String password;
	private Connection con;

	public Day_18_Task() {
		super();
	}

	public Day_18_Task(String urlName, String uname, String password) {
		super();
		this.urlName = urlName;
		this.uname = uname;
		this.password = password;
	}

	public String geturlName() {
		return urlName;
	}

	public void seturlName(String urlName) {
		this.urlName = urlName;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Day_18_Task [urlName=" + urlName + ", uname=" + uname + ", password=" + password + "]";
	}

	public Connection getMyConnection() {
		try {
			con=DriverManager.getConnection(urlName,uname,password);
			// System.out.println(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
