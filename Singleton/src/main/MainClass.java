package main;

import cls.HeClass;
import cls.MyClass;
import cls.YouClass;
import single.SingletonClass;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyClass mycls = new MyClass(123);
		YouClass youcls = new YouClass();
		
//		int n = mycls.getNumber();
//		youcls.setTag(n);
		
		System.out.println(youcls.toString());
		
		
		System.out.println(SingletonClass.getInstance());
		System.out.println(SingletonClass.getInstance());
		System.out.println(SingletonClass.getInstance());	// 3번 모두 같은 instance 를 return 한다
		
		
		mycls.method();
		youcls.func();
		
		System.out.println(youcls.toString());
		
		HeClass hc = new HeClass();
		
		hc.proc();
		
		System.out.println(hc.toString());

		// 결론 : 어~디서나 접그닝 가능한 SingletonClass 를 만들어 놓은 것
	}
	
}
