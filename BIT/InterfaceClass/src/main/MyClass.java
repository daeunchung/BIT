package main;

public class MyClass implements MyInterface{
	
	@Override
	public void method(int n) {
		// TODO Auto-generated method stub
		System.out.println("MyClass method(int n)");
		
		
		MyClass mycls = new MyClass();
		mycls.method(1);
	}

}
