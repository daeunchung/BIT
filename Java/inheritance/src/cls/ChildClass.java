package cls;

public class ChildClass extends ParentClass {
	
	private String name;
	

	public ChildClass()
	{
		super("hello");
		System.out.println("ChildClass ChildClass()");
		
	}
	public ChildClass(String name, double height, int age)
	{
		super(name, height);
		this.age = age;
	}
	
	public void print()
	{
		System.out.println(super.toString());
		System.out.println(this.toString());
	}
	public void func()
	{
		System.out.println("ChildClass func()");
		
//		name = "hello";
		age = 24;
	}
}
