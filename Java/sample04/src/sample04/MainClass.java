package sample04;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * wrapper class
		 * 일반 자료형을 class 화 한 것이
		 * 
		 * 일반 자료형 		wrapper class
		 * boolean		Boolean
		 * byte			Byte
		 * short		Short
		 * int			Integer     -------->
		 * long			Long	
		 * float		Float
		 * double		Double      -------->
		 * char			Character
		 * char[]		String      -------->
		 * 
		 * 
		 * 
		 */
		
		int i = 123;
		Integer in = 234;
		Integer cin = new Integer(324);	// 이렇게 해줄 필요 없음 Deprecated Wrapper 쓰시오
		
		System.out.println(cin);
		
		double d = 123.456;
		Double do1 = 1234.5678;
		System.out.println(do1);
		
		// Integer, Double
		// String
		
		// 문자열 -> 숫자
		String str = "1234";
		int num = Integer.parseInt(str);
		System.out.println("num = " + num);
		
//		str = "2a34.5678";	// 문자있으면 에러
		str = "234.5678";
		double dnum = Double.parseDouble(str);
		System.out.println("dnum = " + dnum);

		
		
		// 숫자 -> 문자열
		Integer num1 = 234;
//		String str1 = num1 + "";
		String str1 = num1.toString();
		
		double do2 = 234.5678;
		String str2 = do2 + "";
		
		// 문자열의 저장 편집 정보 취득
		String str3;
		str3 = "안녕하세요";
		
		String str4 = new String("반갑습니다");
		String str5 = str3 + str4;
		
		System.out.println(str5);
		
		str3 = str3.concat(str4);
		
		// equals( 비교함수 )
		String str6 = "world";
		String str7 = "worl";
		
		str7 += "d";
		
		System.out.println(str6 == str7);
		System.out.println(str6.equals(str7));
		
		// 문자위치
		// indexOf, lastIndexOf
		String str8 = "abcabcabc";
		int index1 = str8.indexOf("c");
		int index2 = str8.lastIndexOf("c");
		
		System.out.println("index1 : " + index1);
		System.out.println("index2 : " + index2);
		
		// 문자열의 길이
		// length()  length:배열
		System.out.println(str8.length());
		
		// 수정  replace
		String str9 = "A*B*C*D";
		String replaceStr = str9.replace("*", "-");
		System.out.println(replaceStr);
		
		// 문자열 자르기
		// split =>
		/*
		 * 홍길동-24-2001/03/16-서울시	'-' token
		 * 성춘향-16-2011/07/28-남원시	
		 * 
		 * 홍길동				-> 파싱하고 파싱한 내용이 무엇인지 알려주기 위해 탄생한 것이 XML 요즘은 JSON
		 * 24
		 * 2001/03/16
		 * 서울시
		 */
		
		String str10 = "홍길동-24-2001/03/16-서울시";
		String split[] = str10.split("-");
		System.out.println(split[0]);
		System.out.println(split[1]);
		System.out.println(split[2]);
		System.out.println(split[3]);
		
		// 문자열을 자른다
		// 범위 substring()
		String subStr = str10.substring(4);
		System.out.println(subStr);
		
		subStr = str10.substring(4, 6);
		System.out.println(subStr);
		
		// 앞 뒤의 공백문자 제거하기
		// trim();
		String str11 = "         java     java   java   ";
		System.out.println(str11.trim());
		
		// index 숫자를 입력하면 문자를 return 
		// charAt
		String str12 = "가나다라마";
		char c = str12.charAt(2);
		System.out.println(c);
		
		// 문자열 탐색
		// contains
		String str13 = "서울시 마포구 서교동";
		boolean b = str13.contains("서교");
		
		System.out.println(b);
		
		
		
		
		
		

		
		
		
		
		
				
	}

}
