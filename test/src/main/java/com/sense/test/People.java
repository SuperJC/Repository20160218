package com.sense.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class People {
	private final int id;
	private final String name;
	private final int age;
	
	private People(Builder b) {
		this.id = b._id;
		this.name = b._name;
		this.age = b._age;
	}
	
	
	public static class Builder implements ObjBuilder<People>{
		private final Lock lock =  new ReentrantLock();
		private  int _id;
		private  String _name;
		private  int _age;
		
		public Builder id(int id){
			lock.lock();
			try {
				_id = id;
			}finally{
				lock.unlock();
			}
			return this;
		}
		
		public People build() {
			return new People(this);
		}
		
	}
	
}
