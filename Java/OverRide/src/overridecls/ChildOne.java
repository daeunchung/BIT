package overridecls;

public class ChildOne extends SuperClass {

	public void method()
	{
		System.out.println("ChildOne overRide method()");
	}
	
	// ChildOne 에만 있는 메서드
	public void ChildOneMethod()
	{
		System.out.println("ChildOneMethod method()");
	}
}
