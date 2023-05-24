package com.samplePack;

public class Salary {
	//seat

	private double basic;
	private double da;
	private double pf;
	private double hra;
	private double gross;
	private double net;
	
	
/*	public double getBasic() {
		return basic;
	}*/
	public void setBasic(double basic) {
		this.basic = basic;
	}

/*	public double getDa() {
		return da;
	}

	public double getPf() {
		return pf;
	}

	public double getGross() {
		return gross;
	}

	public double getNet() {
		return net;
	}*/
	
	
	public void calSalary()
	{
		hra=(basic*20)/100;
		da=(basic*50)/100;
		pf=(basic*11)/100;
		gross=basic+hra+da-pf;
		net=gross-pf;
	}

	@Override
	public String toString() {
		return "Salary [basic=" + basic + ", hra=" + hra + ", da=" + da +", pf=" + pf +", gross=" + gross +", net=" + net + "]";
	}
}

