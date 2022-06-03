package sample05;
// 2022-06-03  09:00 AM

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Array : 배열, 같은 자료형의 묶음, <- 변수들
		 * 			목적 : 데이터 관리
		 * 			class, struct -> Data Transfer Object, Value Object
		 * 
		 * 			자료형 변수명[] = new 자료형[배열의 총수];
		 * 
		 * Java 의 메모리 영역 4개
		 * stack heap static sys
		 * 
		 * array [5]
		 * 동적으로 heap 에 할당, 정적으로 사용
		 * int array[] = new int[5];
		 * -> List
		 * C++ 에서는 delete[] array <- done by Garbage Collector
		 */
		
		// 다 같은 거 
//		int[] Array = new int[5];
		int Array[] = new int[5];
//		int *Array = new int[5];
		
		System.out.println(Array[0]);
		System.out.println(Array.length);
		
		int Array1[] = {2,3,5,7,9};
		
		// 배열의 얕은 복사
		int Array2[] = Array1;	// alias
		
		for(int i=0; i<Array2.length; i++)
			System.out.println(Array2[i]);
		
		Array1[2] = 2;
		System.out.println(Array2[2]);		// 3 -> 2 로 바뀌었음
		
		int number1[] = {1,2,3};
		int number2[] = {7,8,9};
		
		// swap (NOT VALUE, 주소로 swapping)
		int a,b;
		a = 1; b = 2;
		int tmp;
		tmp = a;
		a = b;
		b = tmp;
		
		// 배열 swapping
		int num1[] = number1;
		int num2[] = number2;
		int temp[];
		temp = num1;
		num1 = num2;
		num2 = temp;
		
		int numberArrayPosition[] = {1,2,3};
		int numArrPos[] = numberArrayPosition;
		
		int ArrNum[][] = null;	// #define NULL (0x0000)


	}

}
