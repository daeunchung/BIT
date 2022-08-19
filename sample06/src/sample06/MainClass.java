package sample06;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 제어문
		 * if(조건) { == true/false
		 * 		처리
		 * }
		 * 
		 * > <= == >= <= !=
		 * && || !
		 * 
		 * 예제 코드 생략
		 */
		
		// switch
		/*
		 * 조건문과 비슷, 값이 명확, 범위 지정X, 실수사용 불가능
		 */
		
		int n = 2;
		switch(n) {
			case 1:
				// 처리
				System.out.println("n은 1입니다");
				break;
			case 2:
				// 처리
				System.out.println("n은 2입니다");
				break;
			default:
				System.out.println("n은 1 도 2도 아닙니다");
				break;
		}
		/*
		 * double d = 1.2;
		 * switch(d) { case 1.2 : }	// 제약 많다
		 * 
		 * switch(n) {
		 * 		case n>1 :
		 * 			break;
		 * }
		 */
		
	}

}
