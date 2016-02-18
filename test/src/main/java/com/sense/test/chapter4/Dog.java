package com.sense.test.chapter4;

public class Dog extends Pet {

	public Dog(String name) {
		super(name);
	}

	@Override
	public void examine() {
		System.out.println(getThreadId() + ":Dog["+name+"]");

	}

}
