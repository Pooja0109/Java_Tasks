package com.samplePack;

class Employee
{
	int empno=19001158;
	String ename="Pooja P";
	double salary=26000.00;
	Salary sal=new Salary();

	public Employee()
	{
		System.out.println("Employee constructor !");
		sal.setBasic(salary);
		sal.calSalary();
	}
	
	public Employee(int eno,String ename)
	{
		this.empno=eno;
		this.ename=ename;
		sal.setBasic(salary);
		sal.calSalary();
	}
	
	public String getDetails() {
		return (empno+ " -- " + ename+  " --- " + sal);
	}
}

class Manager extends Employee{
	 String dept ="IT";
	
	 Manager()
	 {
		 super(19001164,"Nidhi R Shetty");
		 System.out.println("Manager Constructor !");
	 }
	public String getDetails() {
		return (super.getDetails()+"---Dept="+ dept);
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
