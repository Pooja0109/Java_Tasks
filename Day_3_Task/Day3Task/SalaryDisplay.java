package com.Day3Task;

interface SalaryInterface 
{
	public void calSalary();
}

public interface SalaryDisplay extends SalaryInterface
{
	public void dispSalary(Salary obj);
}