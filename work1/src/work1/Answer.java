package work1;

public class Answer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 2. 
		String numStr = "1010";
		int len = numStr.length();
		char cNum;
		int n, n1;	// n:숫자, n1:승수
		int number10 = 0;
		
		int oldLen = len;
		for(int i=0; i<oldLen; i++)
		{
			cNum = numStr.charAt(i);
			n = Integer.parseInt(cNum + "");
			n1 = (int)Math.pow(2, len-1);
			n = n * n1;		// 1 * 2 의 3승
			
			len--;
			number10 = number10 + n;
		}
		
		
		// 4.
//		String str = "3A";
//		int len16 = str.length();
//		
//		String n16;	// 0~9 A~F
//		int oldLen16 = len16;
//		int powNum;
//		int number16 = 0;
//		int num16;
//		
//		for(int i=0; i<str.length(); i++)
//		{
//			n16 = str.charAt(i) + "";
//			if(n16.equals("A"))
//				n16 = "10";
//			else if(n16.equals("B"))
//				n16 = "11";
//			else if(n16.equals("C"))
//				n16 = "12";
//			else if(n16.equals("D"))
//				n16 = "13";
//			else if(n16.equals("E"))
//				n16 = "14";
//			else if(n16.equals("F"))
//				n16 = "15";
//		}
//		
//		powNum = (int)Math.pow(num16, number16);
//		
		
		
		

	}

}
