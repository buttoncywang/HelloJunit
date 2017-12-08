package com.buttonong.junit;

public class GreetingImpl implements Greeting{

	@Override
	public String greet(String name) {
		if(name==null || name.length()==0) {
			throw new IllegalArgumentException();
		}
		else {
			return "Hello "+name;
		}
	}

}
