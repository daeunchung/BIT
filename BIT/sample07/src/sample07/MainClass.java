package sample07;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// for loop
		// for
		// foreach
		
		int Arr[] = {1,2,3};
		for(int num : Arr)
		{
			System.out.println(num);
		}

		/*
		 * do while 문
		 * 
		 * 초기화
		 * do{
		 * 		처리
		 * 		연산
		 * } while(조건식)
		 */
		int w3 = 0;
		do {
			System.out.println("w3:" + w3);
			w3++;
			
		}while(w3<5);
	}

}
