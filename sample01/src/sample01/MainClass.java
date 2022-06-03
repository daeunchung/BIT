package sample01;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 숫자(상수) : 
		 * 2진수 0, 1
		 * 8진수 0 ~ 7     9->011
		 * 10진수 0 ~ 9
		 * 16진수 0 ~ 9 A B C D E F(15) 
		 *         
		 * ff 
		 * 1111 1111
		 * 
		 * 1010 1100
		 * 8421 8421
		 * A    C   -> 0xAC
		 * 
		 * 0xE4
		 * 8421 8421
		 * 1110 0100
		 * 
		 * 
		 * 변수 : 빈통(크기)에 데이터 종류가 나누어진다.
		 */
		int num;
		String str;	// instance, object == class 변수
		
//		int* num;
		// 그릇의 종류
		
		// 숫자
		byte by;  // 1 byte -> 8 bit 1111 1111
		short sh ;	// 2 byte
		int i;		// 4 byte
		long l;		// 8 byte
		float f;	// 4 byte
		double d;	// 8 byte
		l = 3543546846846546L;
		
		f = 1234.543f;
		d = 2433.2343;
		
		// 문자
		char c;	// 1 byte in C cause of ASCII 
		char c1;	// 2 byte in JAVA
		c1 = '한';
		
		char arr[] = {'a', 'b'};
		String str1;	 // wrapper class : 일반 자료형을 사용하기 쉽도록 객체화 (래퍼 클래스의 사이즈를 유동적)
						 // Integer, Double
		
		str1 = "hello";
		
		// 논리형
		boolean b;
			// C 언어 BOOL(4byte) <- 0~23423   bool(1byte) <- 0 OR 1
		b = true; b = false;
		
	}

}
