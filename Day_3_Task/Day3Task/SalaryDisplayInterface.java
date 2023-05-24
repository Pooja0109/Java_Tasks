package com.Day3Task;

interface SalaryInterface 
{
	public void calSalary();
}

public interface SalaryDisplayInterface extends SalaryInterface
{
	public void dispSalary(Salary obj);
}