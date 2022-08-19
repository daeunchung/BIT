package cls;

public abstract class AbstractClass {

	private int number;						// 인터페이스와 다르게 멤버변수를 가지고 있을 수 있음
	
	public void method()					// 일반 메서드도 가질 수 있음
	{
		
	}
	public abstract void abstractMethod();	// prototype 만 ! 추상메서드를 가지면 class 에 abstract 가 붙어야 함
	
	
}
