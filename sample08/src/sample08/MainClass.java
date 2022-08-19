package sample08;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * break == 탈출
		 * 
		 * switch, for, while
		 * 
		 * continue == skip(생략)
		 */
		
		for (int i = 0; i < 100; i++) {
			System.out.println("i = " + i);
			if(i == 49)
				break;

		}
		
		char array[] = {'a', 'b', 'c', 'd', 'e'};
		for (int i = 0; i < array.length; i++) {
			System.out.println("array[" + i + "] = " + array[i]);
			if(array[i] == 'c')
				break;
		}
		
		// 2중 for문을 완전 탈출하기
		out:
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			for (int j = 0; j < 6; j++) {
				System.out.println(j);
				if(i ==3 && j == 2) {
					break out;
				}
			}
		}
		
		// 1. loop 수에 break 를 설정
		boolean b = false;
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			for (int j = 0; j < 6; j++) {
				System.out.println(j);
				if(i ==3 && j == 2) {
					break;
				}
				if(b) break;
			}
			if(b) break;	// 같은 것을 한번 더 적어준다
			
		}
		
		// 2. break outerloop;
		outerloop:
	        for (int i=0; i < 5; i++) {
	            for (int j=0; j < 5; j++) {
	                if (i * j > 6) {
	                    System.out.println("Breaking");
	                    break outerloop;
	                }
	                System.out.println(i + " " + j);
	            }
	        }
		
		
		
	}
}
