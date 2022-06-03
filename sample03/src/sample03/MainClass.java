package sample03;

public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 연산자 
		 * 
		 */
		int num1, num2;
		num1 = 3;
		num2 = 2;
		
		int result = num1 / num2;
		System.out.println(num1 + " / " + num2 + " = " + result);
		
		// 논리 연산자
		// && and    || or     ! NOT
		
		// 삼항 연산자  =============> 람다식
		// (조건) ? 값1 : 값2
		int m;
		m = (num1 > 0) ? 100:200;
		System.out.println(m);
		
		
		// 비트 연산자
		// OR
		int number = 0x71 | 0x85;
		System.out.println("number = " + number);
		System.out.printf("0x%x\n", number);
		
		// XOR
		/*
		 * data 0001 1111
		 * key  1100 1010
		 * 
		 * 암호화 1101 0101
		 * 
		 * 반대로 복호화도
		 * 
		 * 
		 */
		byte by;
		by = 0x1 << 2;
		System.out.println("by = " + by);
		
		by = 0x4 >> 1;
		System.out.println("by = " + by);
		
		// ~ 반전 0 -> 1 , 1-> 0
		by = ~0x55;
		/*
		 * 0101 0101 
		 * 8421 8421 
		 * 1010 1010
		 * A    A
		 */
		System.out.println("by = " + by);
		System.out.printf("0x%x\n", by);
	}

}
