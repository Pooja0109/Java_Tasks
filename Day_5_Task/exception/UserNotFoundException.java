package com.dedalus.exception;

public class UserNotFoundException extends Exception 
{

	public UserNotFoundException() {
		System.out.println("From user defined constructor");

	}

	@Override
	public String toString() {
		return "UserNotFoundException";
	}

}
