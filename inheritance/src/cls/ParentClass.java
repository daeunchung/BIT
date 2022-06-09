package cls;

public class ParentClass {

	private String name;
	protected int age;	// 자식클래스에서는 접근을 허용, but 외부에서 차단
	
	public ParentClass(String name, int age)
	{
		super();
		System.out.println("ParentClass()");
	}
	public void ParentMethod()
	{
		System.out.println("ParentClass ParentMethod()");
	}

}
