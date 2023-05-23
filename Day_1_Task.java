//Program to calculate BMI value.

package com.Pack_DailyTask;

public class Day_1_Task {

	float height=153.0f;  //variable 1
	float weight=83.0f;  //variable 2
	float valueBMI;
	
	void calculateBMI()    //method 1
	{
		float meterHeight=height/100;
//		System.out.println("NEW "+meterHeight);
		valueBMI= (float) (weight/(Math.pow(meterHeight,2)));
	}
	
	void displayBMI()      //method 2
	{
		System.out.println("BMI value for height : "+height+"cm and weight :"+weight+"kg is :"+valueBMI);
	}
	public static void main(String[] args) 
	{
		Day_1_Task person1=new Day_1_Task(); //instance 1
		Day_1_Task person2=new Day_1_Task(); //instance 2
		
		System.out.println("Value For Object PERSON-1 :");
		person1.calculateBMI();
		person1.displayBMI();
		
		System.out.println("_______________________________________________\n");
		System.out.println("Value For Object PERSON-2 :");
		person2.calculateBMI();
		person2.displayBMI();

	}

}
