package com.Day3Task;

class Employee
{
	int empno=19001158;
	String ename="Pooja P";
	double salary=26000.00;
	Salary sal=new Salary();

	public Employee()
	{
//		System.out.println("Employee constructor !");
		sal.setBasic(salary);
		sal.calSalary();
		sal.dispSalary(sal);
	}
	
	public Employee(int eno,String ename,double salary)
	{
		this.empno=eno;
		this.ename=ename;
		this.salary=salary;
		sal.setBasic(salary);
		sal.calSalary();
		sal.dispSalary(sal);
	}
	
	public String getDetails() {
		return (empno+ " -- " + ename);
	}
}

class Manager extends Employee{
	 String dept ="IT";
	
	 Manager()
	 {
		 super(19001164,"Nidhi R Shetty",30000.00);
//		 System.out.println("Manager Constructor !");
	 }
	public String getDetails() {
		return (super.getDetails()+"---Dept:"+ dept);
	}
	
}

public class MainClass {

	public static void main(String[] args) 
	{
		Employee emp = new Employee(); //"is a " relationship
		System.out.println(emp.getDetails());
		
		Manager mgr = new Manager(); //"is a " relationship
		System.out.println(mgr.getDetails());
	}

}
