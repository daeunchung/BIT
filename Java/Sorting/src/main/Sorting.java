package main;

import java.util.Arrays;
import java.util.Scanner;

public class Sorting {

	// 정렬할 숫자변수
	int number[] = null;
	boolean updown;
	
	// 처리
	// 1. 초기화
	public void init()
	{
		updown = true;
	}
	// 2. 입력
	public void input()
	{
		Scanner sc = new Scanner(System.in);
		int count;
		
		//			총수
		System.out.println("정렬할 갯수 = ");
		//			숫자를 
		//			오름/내림
	}
	
	// 3. 정렬
	public void sorting()
	{
		
	}
	
	// 4. 결과출력
	public void result()
	{
		if(updown)
		{
			System.out.println("오름차순 정렬: ");
		}else {
			System.out.println("내림차순 정렬: ");
		}
		System.out.println(Arrays.toString(number));
	}
}
