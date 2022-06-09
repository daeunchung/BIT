package main;

import cls.ChildClass;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 은닉성(캡슐화), (상속성, 다형성)
		 * 
		 * inheritance : 상속
		 * (기본)class -> 상속 class
		 * 부모		-> 	자식
		 * 
		 * variable
		 * function
		 * 
		 */
		
		ChildClass cc = new ChildClass();
		
		cc.ParentMethod();
		cc.print();
	}
	

}
