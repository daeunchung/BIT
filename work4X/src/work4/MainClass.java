package work4;

import java.util.Iterator;

public class MainClass {
	public static void main(String[] args) {
		// 다음 암호표로 문자열을 암호화하고 다시 복호화한 결과를 출력하라.
				
		// 암호표
		// 알파벳
		char[] abcCode ={ 
				'`','~','!','@','#', '$','%','^','&','*',
				'(',')','-','_','+', '=','|','[',']','{',
				'}',';',':',',','.', '/'
		};
		// 숫자		
		char[] numCode = {'q','w','e','r','t', 'y','u','i','o','p'};
		
		String src = "abc123";  
		String result = "";		// = `~!qwe -> 수정 `~!wer
		
		// 암호화 함수로 code
		// result = code(src, abcCode ,numCode );

		
		// 암호화 코드
		for (int i = 0; i < src.length(); i++) {
			
			if(src.charAt(i) >= 97 && src.charAt(i) <= 122)
				result += abcCode[src.charAt(i) - 97];
			else if(src.charAt(i) >= 49 && src.charAt(i) <= 57)
				result += numCode[src.charAt(i) - 49];
			else if(src.charAt(i) == 48)
				result += numCode[9];
		}
		
		// 복호화
		String baseCode = "";
		
		// 복호화 코드	
		for (int i = 0; i < result.length(); i++) {
			
			if(result.charAt(i) >= 97 && result.charAt(i) <= 122) {	// 암호문이 알파벳이면
				for (int j = 0; j < numCode.length; j++) {
					if(result.charAt(i) == numCode[j] && j != 9)
						baseCode += (char)(j+49);
					else if(result.charAt(i) == numCode[j] && j == 9)
						baseCode += (char)(j+39); // 9 + x = 48
				}
			}
			else {
				for (int j = 0; j < abcCode.length; j++) {
					if(result.charAt(i) == abcCode[j])
						baseCode += (char)(j+97);
				}
			}
		}
		
		System.out.println(src);
		System.out.println(result);
		System.out.println(baseCode);
	}
}
