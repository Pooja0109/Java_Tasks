package com.day14;

public class FoodFactory {
	
	public foodInterface getInstance(String str)
	{
		if(str.equals("chinese"))
		{
			return new ChineseFood();
		}
		else if(str.equals("south indian"))
		{
			return new SouthIndianFood();
		}
		else
			return new ItalianFood();
	}
}
