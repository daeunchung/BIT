package cls;

import single.SingletonClass;

public class MyClass {

	private int number;
	public MyClass()
	{
		
	}
	
	public MyClass(int number)
	{
		this.number = number;
		
	}

//	public int getNumber() {
//		return number;
//	}

	public void method()
	{
		SingletonClass sc = SingletonClass.getInstance();
		sc.num = number;
	}
}
