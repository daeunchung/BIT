package cls;

public class MyClass {

	// 변수의 종류
	private int number;		// 멤버변수
	
	public static int glNumber;	// static 변수, 전역변수 (어디서나 접근 가능)
	
	public void method(int num, int arr[]) {	// 매개 변수 : 외부에서 값을 받는 , 외부에 값을 세팅하는 
		int localNum = 0;		// 지역변수
		
		localNum++;
		glNumber++;
		number++;
		
		System.out.println("local: " + localNum);
		System.out.println("static: " + glNumber);
		System.out.println("member: " + number);		// 인스턴스 변수 또는 멤버 변수
	}
}


/*

static 게임 개발에서는 많이 쓰고
웹에서는 일반적으로 많이 안쓰고 개발 도중에 여기 거쳐갔는지 확인하는 용도의 변수로 사용
*/