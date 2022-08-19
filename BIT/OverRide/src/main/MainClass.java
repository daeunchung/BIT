package main;

import overridecls.ChildOne;
import overridecls.ChildTwo;
import overridecls.SuperClass;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * OverRide : 부모 클래스로부터 상속받은 메소드를 고쳐 기입하는 것
		 * 
		 * 
		 */
		
//		ChildClass cc = new ChildClass();
//		cc.method();
//		
//		ChildOne one = new ChildOne();
//		ChildTwo two = new ChildTwo();
//		
//		one.method();
//		two.method();
		
		// ChildOne 과 ChildTwo 를 합해서 10 개 생성할껀데 정확한 수량은 모름.
		// 어떤식으로 표현해야할까?
		
		ChildOne arrOne[] = new ChildOne[10];
		ChildTwo arrTwo[] = new ChildTwo[10];
		for (int i = 0; i < arrOne.length; i++) {
			
		}
		
		
		// 인스턴스 하나로 관리하기
		SuperClass arrSuper[] = new SuperClass[10];
		arrSuper[0] = new ChildOne();
		arrSuper[1] = new ChildOne();
		arrSuper[2] = new ChildTwo();
		arrSuper[3] = new ChildTwo();
		
		for (int i = 0; i < arrSuper.length; i++) {
				arrSuper[i].method();
				
				if(arrSuper[i] instanceof ChildOne) {
					ChildOne co = (ChildOne)arrSuper[i];
					co.ChildOneMethod();
				}
		}
		
		SuperClass sc = new ChildOne();
		sc.method();    // 호출하면 ChildOne 의 method 함수가 호출된다.
		
	}

}
