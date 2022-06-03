package work1;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 10진수 -> 2진수 String
		 * 
		 * 2진수(String) -> 10진수
		 * 
		 * 10진수 -> 16진수 String
		 * 
		 * 16진수 (String) -> 10진수
		 */
		
		Scanner sc = new Scanner(System.in);
		int num = 0;	String str = "";
		
		// 1. 10진수 -> 2진수 String
		num = sc.nextInt();
		while(num != 0)
		{
			str += (num % 2);
			num /= 2;
		}
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		System.out.println(sb.toString());
		
		
		// 2. 2진수(String) -> 10진수
		str = sc.next();
		num = 0; 
		int mult = 1;
		for (int i = str.length() - 1; i >= 0; i--) {
			num += (str.charAt(i) - 48) * mult;
			mult *= 2;
		}
		System.out.println(num);
		
		
		// 3. 10진수 -> 16진수 String
		num = sc.nextInt();
		str = "";
		while(num != 0)
		{
			int tmp = num % 16;
			
			if( tmp >= 10 ) {
				tmp += 55;
			} else {
				tmp += 48;
			}
			str += (char)tmp;
			num /= 16;
		}
		StringBuilder sb1 = new StringBuilder(str);
		sb1.reverse();
		System.out.println(sb1.toString());
		
		
		// 4. 16진수 (String) -> 10진수
		String str1 = sc.next();
		num = 0;
		mult = 1;
		for (int i = str.length() - 1; i >= 0; i--) {
			if(str1.charAt(i) >= 65) 
			{
				num += (str1.charAt(i) - 55) * mult;
			}
			else {
				num += (str1.charAt(i) - 48) * mult;
			}
			mult *= 16;
		}
		System.out.println(num);
		
		
//		 5. 입력받은 문자열이 모두 숫자로 되어 있는지 확인
//		-> 숫자로 되어 있습니다.
//		-> 숫자가 아닙니다.
		
		String strr = sc.next();
		for(int i=0; i<strr.length(); i++)
		{
			if(strr.charAt(i) < '0' || '9' < strr.charAt(i) ) {
				System.out.println("숫자가 아닙니다");
				break;
			}
		}
		System.out.println("숫자로 되어 있습니다");
		
		
		
	}

}
