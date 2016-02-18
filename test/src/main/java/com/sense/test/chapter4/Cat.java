package com.sense.test.chapter4;

public class Cat extends Pet {

	public Cat(String name) {
		super(name);
	}

	@Override
	public void examine() {
		System.out.println(getThreadId() + ":Cat["+name+"]");

	}

}
