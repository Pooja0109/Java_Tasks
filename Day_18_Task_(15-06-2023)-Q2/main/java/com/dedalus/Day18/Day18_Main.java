package com.dedalus.Day18;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Day18_Main {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Day18_Props.xml");
		Day_18_Task dao1 = (Day_18_Task)context.getBean("dao1");
		System.out.println("Connection string :"+dao1.getMyConnection());
	}

}
