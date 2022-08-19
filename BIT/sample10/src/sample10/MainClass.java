package sample10;

import java.util.Arrays;

public class MainClass {

	public static void main(String[] args) {
		/*
		 * function :  함수  C언어
		 * method : class 에 소속된 함수 Java
		 * 
		 * return 값의 자료형 함수명 (인자, 인자, parameter )
		 * 
		 * 
		 * 		return 돌려주는 값;
		 * }
		 * 
		 * parameter : num -> 가인수
		 * argument : 123 -> 실인수
		 * 
		 * func( 123 );
		 * 
		 * void func(int num) {
		 * 
		 * 
		 * }
		 * 
		 * 
		 */
		
		func();
		func(123);
		int n = 1;
		char c = 'A';
		int array[] = {1, 2, 3};
		func(n, c , array);
		
		System.out.println(n);
		System.out.println();
		
		
		///////////////////////////////////////////////
		boolean b = isNumber("123a");
		System.out.println("b" + b);
		
		String s = isDouble("0.456");
		System.out.println(s);
		
		
		
		boolean f = SmallCharExists("AGDSewrA");
		
		int num1 = 9, num2 = 2;
		int tag[] = new int[1];
		func1(5, 2, tag);
		
	}
	
		static void func() {
			System.out.println("func() 호출");
			
		}
		static void func(int i) {	// overloading
			System.out.println("func(int i) i = " + i);
			
		}
		//              value 의 할당, address 의 할당
		static void func(int i, char c, int[] arr) {	// overloading
			System.out.println("func(int i, char c, int[] arr) " );
			i = 2;
		}

		// 문자열 -> 모두 숫자로 되어 있는지?
		//       -> 정수이냐, 소수이냐
		//  boolean isNumber
		//  String isDouble
	
		
		static boolean isNumber (String str)
		{
			
			boolean flag = true;
			int size = str.length();
			for (int i = 0; i < size; i++) {
				if(str.charAt(i)> 48 || str.charAt(i) < 57) {
					flag = false;
					break;
				}
			}
			return flag;
		}
		
		
		static String isDouble (String str)
		{
			String result = "정수";
			int size = str.length();
			for (int i = 0; i < size; i++) {
				if(str.charAt(i) == 46) {
					result = "소수";
					break;
				}
			}
			return result;
		}
		

		
		
		// 문자열에 소문자가 포함되어 있는지 ?
		static boolean SmallCharExists(String str)
		{
			boolean b = false;
			for (int i = 0; i < str.length(); i++) {
				if(97 <= str.charAt(i) && str.charAt(i) <= 122) {
					b = true;
					break;
				}
			}
			return b;
		}
		
		// 두수를 나눈 몫과 나머지를 구하는 함수 => 1개의 함수
		static int func1(int num1, int num2, int[] t)
		{
			int mok = num1/num2;
			t[0] = num1 % num2;
			return mok;
		}
		
	}
