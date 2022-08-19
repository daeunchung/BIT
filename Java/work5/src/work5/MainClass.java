package work5;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num1, num2;
		String str1, str2;
		String oper;
		
		Scanner sc = new Scanner(System.in);
		
		// 함수로 처리 : 조건 -> 숫자가 입력이 안되면 다시 입력
		// 첫번째 수 입력
		while(true)
		{
			System.out.println("첫번째 수를 입력하세요 ");
			str1 = sc.next();
			if(checkIfNum(str1)) 
				break;
		}
		num1 = Integer.parseInt(str1);
		
		
		// 연산자 입력 -> 연산자가 정상입력
		System.out.println("연산자를 입력하세요 ");
		oper = sc.next();
		
		// 두번째 수 입력
		while(true)
		{
			System.out.println("두번째 수를 입력하세요 ");
			str2 = sc.next();
			if(checkIfNum(str2)) 
				break;
		}
		num2 = Integer.parseInt(str2);

		// 연산 처리
		int result = calc(num1, num2, oper);
		// 결과 출력
		System.out.println(result);

	}
	
	static int calc(int n1, int n2, String oper)
	{
		if(oper == "+") return n1 + n2;
		else if(oper == "-") return n1 - n2;
		else if(oper == "*") return n1 * n2;
		else if(oper == "/") return n1 / n2;
		else return -1;	// means error
	}
	
	static boolean checkIfNum(String str)
	{
		boolean b = true;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) < 48 ||  str.charAt(i) > 57) {
				b = false;
				break;
			}
		}
		return b;
	}
}
