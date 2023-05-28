package com.dedalus.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.dedalus.controller.EmployeeController;
import com.dedalus.controller.EmployeeInterface;
import com.dedalus.exception.UserNotFoundException;
import com.dedalus.model.Employee;

class MenuOptions {

	String un = null;
	String pwd = null;

	public boolean login() {
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
		if (un.equals("Pihu") && pwd.equals("pass"))
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
					System.out.println("\n1.Add Employee\n2.View Employee\n3.Serialize Emp File\n4.DeSerialize Emp File");
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
			System.out.println("IO");
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
			System.out.println("\nLoading... Please wait!\n");
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
