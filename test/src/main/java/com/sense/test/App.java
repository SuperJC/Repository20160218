package com.sense.test;



/**
 * Hello world!
 *
 */
public class App{

	private int c = 1;
	private static int d = 2;
    public int add(int a,int b){
    	a++;
    	int tmp =b+c;
    	tmp+=d;
    	if (tmp==0){
    		return tmp;
    	}
    	return a+tmp;
    }
}
