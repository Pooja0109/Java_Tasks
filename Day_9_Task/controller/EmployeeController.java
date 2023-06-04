package com.dedalus.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.dedalus.dao.EmployeeDao;
import com.dedalus.model.Employee;

public class EmployeeController implements EmployeeInterface{
	
	Scanner sc=new Scanner(System.in);
	Employee emp=new Employee();
	List<Employee> emplist = new ArrayList(); 
	EmployeeDao empdao=new EmployeeDao();
	public void addEmployee()
	{
		emp = new Employee();
		System.out.println("Enter the employee number: ");
		int eno=sc.nextInt();
		System.out.println("Enter the employee name: ");
		String ename=sc.next();
		emp.setEmpno(eno);
		emp.setEname(ename);
		empdao.insertEmployee(emp);
		emplist.add(emp);
		System.out.println("Employee Added Successfully");
	}
	
	public void viewEmployee()
	{
		System.out.println("\n---Entered Employee Details--");
		
		/*
		Iterator<Employee> i = emplist.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
		*/

		//Implementing Consumer functional interface
		emplist.forEach(e -> System.out.println(e));
		System.out.println("Data from DB:");
		empdao.showEmployee();
		
//------------------------------------------------------------------------------------
//		System.out.println(emplist);   //For multiple employees
//		System.out.println(emp);	//For single employees,shows the recent added emp
//------------------------------------------------------------------------------------

	}
	
	public void upadteEmp()
	{
		System.out.println("Enter the employee id :");
		Scanner sc=new Scanner(System.in);
		int eid=sc.nextInt();
		System.out.println("Enter the employee name :");
		String empname=sc.next();
		empdao.updateEmployee(eid,empname);
		
	}
	
	public void deletesEmployee()
	{
		System.out.println("Enter the employee id :");
		Scanner sc=new Scanner(System.in);
		int eid=sc.nextInt();
		empdao.deleteEmployeeDB(eid);
	}
	
	
	public void serialEmployee()
	{
		try
		{
			FileOutputStream fos = new FileOutputStream("dedalus.txt");   //writes to a file
			ObjectOutputStream oos = new ObjectOutputStream(fos);   //converts the written stuff into serialized stuff and writes to a file
			oos.writeObject(emplist);  //converts the written stuff into serialized stuff and writes to a file
			System.out.println("Serilized to file dedalus.txt");
			oos.close();
			fos.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void sortEname()
	{
		Collections.sort(emplist,Employee.nameComparator);
		System.out.println("Sorted Employee List w.r.t Emp Names: " + emplist);
	}
	
	public void sortEmpno()
	{
		 Collections.sort(emplist);
		 System.out.println("Sorted Employee List w.r.t Emp Number: " + emplist);
	}
	
	public void deSerialEmployee()
	{
		try{
			FileInputStream fis = new FileInputStream("dedalus.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			emplist=(ArrayList<Employee>) ois.readObject();
//			Employee emp = (Employee)ois.readObject();
			System.out.println("DeSerilized from file dedalus.txt");
//			System.out.println(emp.getEmpno());
//			System.out.println(emp.getEname());
			for (Employee employee : emplist) 
			{
			 System.out.println(employee.toString());
			}
			
			ois.close();
			fis.close();
			}
			catch(FileNotFoundException fnf)
			{
				System.out.println("No file");
			}
			catch(ClassNotFoundException cnf)
			{
				System.out.println("No Emp class");
			}
			catch(Exception e)
			{
				 e.printStackTrace();
			}

		}
}
