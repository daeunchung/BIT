package main;

import cls.AbstractClass;
import cls.MyClass;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 * Abstract class : 추상 클래스
 * AWT 의 A가 Abstract
 * 
 * 추상 메서드를 하나 이상 포함하고 있는 클래스
 * 추상 메서드 : 메서드 내용은 없고 선언만 되어 있는 메서드 (prototype 선언)
 * int method(char c) 와 같이 선언만 되어 있는 
 */
		// 기본 생성 불가능
//		AbstractClass ac = new AbstractClass();
		
		// 상속 받아서 생성은 가능
		// 안드로이드가 이런식으로 생성되어 있응
		AbstractClass ac1 = new AbstractClass() {
			
			@Override
			public void abstractMethod() {
				// TODO Auto-generated method stub
				System.out.println("ac1 abstractMethod()");
				
			}
		};
		ac1.abstractMethod();
		
		MyClass mycls = new MyClass();
		mycls.abstractMethod();
		
		AbstractClass ac = new MyClass(); 
		ac.abstractMethod();
		((MyClass)ac).func();
		
	}

}
