package com.dedalus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dedalus.model.Employee;
import com.dedalus.util.MyDbConnection;

public class EmployeeDao {
	
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	
	
	public void insertEmployee(Employee emp)
	{
		con=MyDbConnection.getInstance().getMyConnection();
		try {
			ps=con.prepareStatement("insert into dalemp values(?,?)");
			ps.setInt(1,emp.getEmpno());
			ps.setString(2,emp.getEname());
			int noOfRows=ps.executeUpdate();
			System.out.println("Employee instered in DB Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showEmployee() {
		con =MyDbConnection.getInstance().getMyConnection();
		try {
			stmt =con.createStatement();
			rs =stmt.executeQuery("select * from dalemp");
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " -- " + rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateEmployee(int eid, String empname) {
		con = MyDbConnection.getInstance().getMyConnection();
	    try {
	        PreparedStatement ps = con.prepareStatement("Update dalemp SET ename=? WHERE empno = ?");
	        ps.setString(1,empname);
	        ps.setInt(2, eid);
	        int noOfRows = ps.executeUpdate();
	        if (noOfRows > 0) {
	            System.out.println("Employee record updated successfully.");
	        } else {
	            System.out.println("Failed to updated employee record.");
	        }
	        ps.close();
	        con.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	
	public void deleteEmployeeDB(int eid) {
	    con = MyDbConnection.getInstance().getMyConnection();
	    try {
	        PreparedStatement ps = con.prepareStatement("DELETE FROM dalemp WHERE empno = ?");
	        ps.setInt(1, eid);
	        int rowsAffected = ps.executeUpdate();
	        if (rowsAffected > 0) {
	            System.out.println("Employee record deleted successfully.");
	        } else {
	            System.out.println("Failed to delete employee record.");
	        }
	        ps.close();
	        con.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}
