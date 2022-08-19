package work4;

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
		
		String src = "dfer8943";  
		String result = "";		// = `~!wer
		
		/*
		// 암호화 코드
		for (int i = 0; i < src.length(); i++) {
			int asc = (int)src.charAt(i);
			
			// 알파벳
			if(asc >= 97 && asc <= 122) {
				asc = asc - 97;		// 97 -> 0
				result = result + abcCode[asc];
			}			
			// 숫자
			if(asc >= 48 && asc <= 57) {
				asc = asc - 48;		// 48 -> 0
				result = result + numCode[asc];
			}			
		}*/
		
		result = code(src, abcCode, numCode);
		
		System.out.println("원본:" + src);
		System.err.println("암호화:" + result);
		
		// 암호화 함수로 전환
		
		// 복호화
		String baseCode = "";
		
		/*
		// 복호화 코드	
		for (int i = 0; i < result.length(); i++) {
			char c = result.charAt(i);
			int asc = (int)c;
			
			// 알파벳 -> 숫자
			int index = 0;
			if(asc >= 97 && asc <= 122) {
				
				for (int j = 0; j < numCode.length; j++) {
					if(c == numCode[j]) {
						index = j;
						break;
					}
				}
				
				index = index + 48;	// 0 -> 48(0)
				baseCode = baseCode + (char)index;
			}
			else {	// 기호 -> 알파벳
				
				for (int j = 0; j < abcCode.length; j++) {
					if(c == abcCode[j]) {
						index = j;
						break;
					}
				}
				index = index + 97;
				baseCode = baseCode + (char)index;
			}
		}
		*/	
		
		// 복호화 함수로 전환
		baseCode = decode(result, abcCode, numCode);
		
		System.out.println("복호화:" + baseCode);
	}
	
	static String code(String src, char[] abcCode, char[] numCode) {
		String result = "";	
		
		for (int i = 0; i < src.length(); i++) {
			int asc = (int)src.charAt(i);
			
			// 알파벳
			if(asc >= 97 && asc <= 122) {
				asc = asc - 97;		// 97 -> 0
				result = result + abcCode[asc];
			}			
			// 숫자
			if(asc >= 48 && asc <= 57) {
				asc = asc - 48;		// 48 -> 0
				result = result + numCode[asc];
			}			
		}
		
		return result;
	}
	
	static String decode(String result, char[] abcCode, char[] numCode) {
		
		String baseCode = "";
		
		for (int i = 0; i < result.length(); i++) {
			char c = result.charAt(i);
			int asc = (int)c;
			
			// 알파벳 -> 숫자
			int index = 0;
			if(asc >= 97 && asc <= 122) {
				
				for (int j = 0; j < numCode.length; j++) {
					if(c == numCode[j]) {
						index = j;
						break;
					}
				}
				
				index = index + 48;	// 0 -> 48(0)
				baseCode = baseCode + (char)index;
			}
			else {	// 기호 -> 알파벳
				
				for (int j = 0; j < abcCode.length; j++) {
					if(c == abcCode[j]) {
						index = j;
						break;
					}
				}
				index = index + 97;
				baseCode = baseCode + (char)index;
			}
		}
		
		return baseCode;
	}	
	
	
}
