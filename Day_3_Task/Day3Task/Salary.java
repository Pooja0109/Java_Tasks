package com.Day3Task;

public class Salary implements SalaryDisplay{

	private double basic;
	private double da;
	private double pf;
	private double hra;
	private double gross;
	private double net;

	public void setBasic(double basic) {
		this.basic = basic;
	}
	
	public void calSalary()
	{
		hra=(basic*10)/100;
		da=(basic*12)/100;
		pf=(basic*11)/100;
		gross=basic+hra+da-pf;
		net=basic-pf;
	}

	@Override
	public String toString() {
		return "Salary [basic=" + basic + ", hra=" + hra + ", da=" + da +", pf=" + pf +", gross=" + gross +", net=" + net + "]";
	}
	
	public void dispSalary(Salary sal)
	{
		System.out.println("\n---Your Pay Slip---");
		System.out.println(sal);
	}
}

