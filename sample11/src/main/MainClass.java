package main;

import cls.MyClass;

public class MainClass {

	public static void main(String[] args) {
		/*
		 * 절차지향 : 변수선언, 함수 -> 연산
		 * 			순서지향 1 2 3 4
		 * 			유지보수 매우 안좋음, 재사용성 X
		 * 			속도 우수, C 언어
		 * 
		 * 객체지향 : class(object 설계도)
		 * 			유지보수에 우수, 재사용성 
		 * 			가독성, Java, MFC -> 발전되어 C#
		 */
		
		// 초기화
		int array[] = {1, 2, 3};
//		MyClass mycls = {1, "홍길동", 181.2};	// 클래스를 초기화 불가능. 그래서 나온 것이 const
		
		/* 
		 * constructor : 생성자 != initialize
		 * 				class 생성시에 자동으로 호출되는 함수.
		 * 				init 과는 다른 함수
		 * 				클래스명과 같은 함수
		 * 				return 값이 없다
		 * 				overload 가 가능하다
		 * 				생략이 가능하다
		 * 
		 * destructor : 소멸자
		 * 
		 * stack heap static sys
		 */
		
//		MyClass mycls = new MyClass();
		
//		MyClass mycls = new MyClass(1, "hgd");
		
		MyClass mycls = new MyClass(2, "춘향", 161.2);
		
		System.out.println(mycls.toString());	// toString 오버로딩 안하면 주소값 출력
		System.out.println(mycls);
		System.out.println(mycls.getThis());
	}
}
