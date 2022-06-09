package main;

import cls.MyClass;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * static == 정적
		 * 
		 * 
		 */
		
		MyClass cls = new MyClass();
		cls.method(0, null);
		cls.method(0, null);
		cls.method(0, null);

		MyClass mycls = new MyClass();
		mycls.method(0, null);
		
		MyClass.glNumber++;	// static 변수
		
	}

}
