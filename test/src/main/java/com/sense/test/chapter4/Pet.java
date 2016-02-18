package com.sense.test.chapter4;

public abstract class Pet {
	protected final String name;

	public Pet(String name) {
		super();
		this.name = name;
	}
	
	
	public abstract void examine();
	
	public long getThreadId(){
		return Thread.currentThread().getId();
	}
}
