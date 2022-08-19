package sample09;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args)
	{
		
		/*
		 * Sorting :  정렬
		 * 			선택, 버블, 합병, 퀵
		 * 
		 * 1. 몇개를 정렬하시겠습니까?
		 * >> 10
		 * 2. 갯수에 맞도록 배열 할당
		 * >> new int[10]
		 * 3. 숫자들을 입력 받는다.
		 * >> 10개
		 * 4. choose ASC or DESC 
		 * 4. 정렬
		 * 5. 결과 출력
		 */
		
//		int number[] = {4,3,5,2,1};
//		for (int i = 0; i < number.length-1; i++) {
//			for (int j = i+1; j < number.length; j++) {
//				if(number[i] > number[j])	// SWAP 내림차순
//				{
//					int tmp = number[i];
//					number[i] = number[j];
//					number[j] = tmp;
//				}
//			}
//		}
//		
//		System.out.println(Arrays.toString(number));
		
		int number[];
		String numStr[];
		Scanner sc = new Scanner(System.in);
		System.out.print("몇개를 정렬하시겠습니까?  ");
		int count = sc.nextInt();
		boolean updown = true;
		int arr[] = new int[count];
		System.out.print("숫자를 입력하세요  ");
		/*
		for (int i = 0; i < count; i++) {
			arr[i] = sc.nextInt();
		}
		*/
		
		int w = 0;
		while(w < count) {
			System.out.println((w+1) + "번째 수 = ");
			String numStr = sc.next();
			
			boolean b = true;
		
			for (int i = 0; i < numStr.length(); i++) {
				int asc = (int)numStr.charAt(i);
				if(asc < 48 || asc > 57) {
					b = false;
					break;
				}
				
			}
			if(!b) {
				System.out.println("숫자만 입력해 주십시오");
				continue;
			}
			number[w] = Integer.parseInt(numStr);
			w++;
		}
		
		System.out.print("오름차순이면 1 , 내림차순이면 2 입력하시오  ");
		int way = sc.nextInt();

		// sorting
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(way == 1) {
					if(arr[i] > arr[j])	
					{
						int tmp = arr[i];
						arr[i] = arr[j];
						arr[j] = tmp;
					}
				}
				else if(way == 2) {
					if(arr[i] < arr[j])	
					{
						int tmp = arr[i];
						arr[i] = arr[j];
						arr[j] = tmp;
					}
				}
			}
		
		}
		System.out.println(Arrays.toString(arr));
	}
}
