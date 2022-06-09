package main;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * final : const(상수), define
		 * 			변수, 메소드, 클래스
		 * 
		 */
		
		final int number = 10;	 // 변경 불가능 // 변수 -> 상수(변경불가)
//		number = 20;
		final int NUMBERCOUNT = 100;	// 상수값
		
		int num = NUMBERCOUNT;
		
	}

}

// 상속금지
/*final*/ class SuperClass{
	
	//// 오버라이딩 금지
	public final void method()	
	{
		
	}
}

class ChildClass extends SuperClass{
	
	@Override
	public void method()	// override
	{
		
	}
}
