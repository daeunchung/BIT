package cls;

public class MyClass {

	private int number;
	private String name;
	private double height;
	
	public MyClass()		// 기본 생성자
	{
		System.out.println("MyClass MyClass()");
		number = 1;
		name = "aaa";
		height = 0.0;
	}
	
	public MyClass(int number, String name)
	{
		this(); // super
		System.out.println(" MyClass(int number, String name)");
		this.number = number;
		this.name = name;
	}

	public MyClass(int number, String name, double height) {
		this(number, name);		// this 는 가장 위에서 호출해야함
		
		System.out.println(" MyClass(int number, String name, double height)");
		this.number = number;
		this.name = name;
		this.height = height;
	}

	
	/*
	 * this : 자기참조 (자신이 생성된 heap 영역의 주소값)
	 * 		각 함수별로 0번째 매개변수이다
	 * 
	public void method(MyClass this)
	{
		
	}
	 * 
	 * 
	 */
	
	public MyClass getThis()
	{
		return this;
	}
	
	public void func()
	{
		this.height = 180.0;
		this.getThis();
		
		height = 180.0;	// this 생략가능
		getThis();
	}
	
	@Override
	public String toString() {
		return "MyClass [number=" + number + ", name=" + name + ", height=" + height + "]";
	}
	
	
}

