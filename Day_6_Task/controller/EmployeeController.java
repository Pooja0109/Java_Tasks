package com.dedalus.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.dedalus.model.Employee;

public class EmployeeController implements EmployeeInterface{
	
	Scanner sc=new Scanner(System.in);
	Employee emp=new Employee();
	List<Employee> emplist = new ArrayList(); 
	
	public void addEmployee()
	{
		emp = new Employee();
		System.out.println("Enter the employee number: ");
		int eno=sc.nextInt();
		System.out.println("Enter the employee name: ");
		String ename=sc.next();
		emp.setEmpno(eno);
		emp.setEname(ename);
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
		
//------------------------------------------------------------------------------------
//		System.out.println(emplist);   //For multiple employees
//		System.out.println(emp);	//For single employees,shows the recent added emp
//------------------------------------------------------------------------------------

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
