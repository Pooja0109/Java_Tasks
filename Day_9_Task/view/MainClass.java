package com.dedalus.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.function.BiPredicate;

import com.dedalus.controller.EmployeeController;
import com.dedalus.controller.EmployeeInterface;
import com.dedalus.exception.UserNotFoundException;
import com.dedalus.model.Employee;

class MenuOptions {

	String un = null;
	String pwd = null;

	public boolean login() {
		
		//Implementing Predicate functional interface
		
		BiPredicate<String, String> res = (un, pwd) ->{if(un.equals("Pihu") && pwd.equals("pass")) return true; else return false; };
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("\t\t...Welcome to Employee Management System...\n");
			
			System.out.println("Enter Username");
			un = br.readLine();
			System.out.println("Enter Password");
			pwd = br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (res.test(un,pwd))
			return true;
		else
			return false;
	}

	public void menuFun(boolean logResult) {
		EmployeeInterface ec = new EmployeeController();
		MenuOptions mo1 = new MenuOptions();
		boolean result=logResult;
		try {
			if (logResult) {
				System.out.println("---Welcome " + un+"---\n");
				Scanner sc = new Scanner(System.in);
				String ch = null;
				do {
					System.out.println("\n1.Add Employee\n2.View Employee\n3.Serialize Emp File\n4.DeSerialize Emp File\n5.Update Employee\n6.Delete Employee\n7.Sort Emp By Empno\n8.Sort Emp By Name\n9.Exit");
					System.out.println("Enter your choice :");
					int choice = sc.nextInt();

					switch (choice) {
					case 1:
						ec.addEmployee();
						break;

					case 2:
						ec.viewEmployee();
						break;

					case 3:
						ec.serialEmployee();
						break;

					case 4:
						ec.deSerialEmployee();
						break;
						
					case 5:
						ec.upadteEmp();
						break;
						
					case 6:
						ec.deletesEmployee();
						break;
					case 7:
						ec.sortEmpno();
						break;
					case 8:
						ec.sortEname();;
						break;
						
					case 9:
						System.out.println("---Program Terminated---");
						System.exit(0);
					break;
					
					default:
						System.out.println("Invalid choice...try again!");
						break;
					}

					System.out.println("Do you want to continue? (Y | N): ");
					ch = sc.next();

				} while (ch.equalsIgnoreCase("y"));
			} else {
				throw new UserNotFoundException();
			}
		} catch (UserNotFoundException unf) {
			unf.printStackTrace();
			System.out.println(unf);
		} catch (Exception ae) {
			ae.printStackTrace();
		} finally {
			System.out.println("---The End---");
		}
	}
}

class LoaderCls implements Runnable {
	public void run() {
		MenuOptions mo = new MenuOptions();
		try {
			boolean result=mo.login();
			System.out.println("\nLoading... Please wait![5 seconds]\n");
			Thread.sleep(5000);
			mo.menuFun(result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class MainClass {
	public static void main(String[] args) {
		LoaderCls lc = new LoaderCls();
		Thread t = new Thread(lc);
		t.start();
	}
}
