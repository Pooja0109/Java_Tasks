package com.day14;

public class MainFactroryProg {

	public static void main(String[] args) {
		FoodFactory ff =new FoodFactory();
		foodInterface obj=ff.getInstance("south indian");
		obj.getMyFood();
		foodInterface obj1=ff.getInstance("italian");
		obj1.getMyFood();
		foodInterface obj2=ff.getInstance("chinese");
		obj2.getMyFood();
	}

}
