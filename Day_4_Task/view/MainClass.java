package com.dedalus.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.dedalus.controller.EmployeeController;
import com.dedalus.controller.EmployeeInterface;
import com.dedalus.exception.UserNotFoundException;
import com.dedalus.model.Employee;

public class MainClass {

	public static void main(String[] args) {
		
		EmployeeInterface ec=new EmployeeController();
		System.out.println("...Welcome to Employee Management System...\n");
		
		try {
			String un = null;
			String pwd = null;

			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("Enter Username");
			un = br.readLine();
			System.out.println("Enter Password");
			pwd = br.readLine();

			if (un.equals("Pihu") && pwd.equals("pass")) {
				System.out.println("Welcome " + un);
				Scanner sc =new Scanner(System.in);
				String ch=null;
				do 
				{
				System.out.println("1.Add Employee\n2.View Employee\n3.Serialize Emp File\n4.DeSerialize Emp File");
				System.out.println("Enter your choice :");
				int choice=sc.nextInt();
				
						
				switch(choice)
				{
				case 1:ec.addEmployee();
				break;
				
				case 2:ec.viewEmployee();
				break;
				
				case 3:ec.serialEmployee();
				break;
				
				case 4:ec.deSerialEmployee();
				break;
			
				default:System.out.println("Invalid choice...try again!");
				break;
				}
				
				System.out.println("Do you want to continue ?(Y | N ): ");
				ch=sc.next();
				
			}while(ch.equals("y")||ch.equals("Y"));
			} 
			else 
			{
				throw new UserNotFoundException();
			}

		}
		catch (UserNotFoundException unf) {
			unf.printStackTrace();
			System.out.println(unf);
		}

		catch (Exception ae) {
			System.out.println("IO");
		} 
		finally {
			System.out.println("---The End---");
		}
		
}
}
		