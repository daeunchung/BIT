//package work5;
//
//import java.util.Scanner;
//
//public class Answer {
//
//	public static void main(String[] args) {
//		int num1, num2;
//		String oper;
//		num1 = number_input("첫번째");
//		oper = operatorInput();
//		num1 = number_input("첫번째");
//		result = 
//	}
//	
//	
//	
//	static int number_input(String no)
//	{
//		Scanner sc = new Scanner(System.in);
//		
//		String numStr = "";
//		while(true)
//		{
//			System.out.print(no + " 수 = ");
//			numStr = sc.next();
//			
//			if(numStr.trim().equals("") == true)
//			{
//				System.out.println("숫자를 정확히 입력해 주십시오");
//				continue;
//			}
//			boolean check = isNumber(numStr);
//			if(!check)
//				
//
//			static int processing(init n1, int n2, String oper)
//			{
//				int result = 0;
//				switch(oper)
//				{
//					case "+" : 
//						result = n1 + n2;
//						break;
//					case "-" : 
//						result = n1 - n2;
//						break;
//					case "*" : 
//						result = n1 * n2;
//						break;
//					case "/" : 
//						result = n1 / n2;
//						break;
//				}
//				return result;
//			}
//				
//			static void resultPrint(int n1, int n2, int result, String oper)
//			{
//				System.out.println(n1 + " " + oper + " " + n2 + " = " + result);
//			}
//			
//			static boolean isNumber(String numStr)
//			{
//				boolean check = true;
//				for (int i = 0; i < numStr.length(); i++) {
//					int asc = (int)numStr.charAt(i);
//					if(asc < 48 || asc > 57)
//					{
//						check = false;
//						break;
//					}
//					
//				}				
//			}
//			
//			
//			static String operatorInput()
//			{
//				Scanner sc = new Scanner(System.in);
//				String oper = "";
//				while(true)
//				{
//					System.out.println("연산자(+,-,*,/) = ");
//					oper = sc.next();
//					
//					if(oper.equals("+") || oper.equals("-") || oper.equals("*") || oper.equals("/")) {
//						System.out.println("정상입력");
//						break;
//					}
//					System.out.println("정확하게 연산자를 입력해 주십시오");
//				}
//				return oper;
//			}
//			
//			
//
//		}
//	}
//	
//}
