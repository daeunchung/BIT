package work2;

import java.util.Random;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Baseball 
		 * random 3개
		 * 
		 * 1 ~ 10-> 3"
		 * 3 7 2
		 * 
		 * user input -> 3"
		 * 4 5 2 -> 1 strike (자릿수까지 일치)
		 * 1 9 3 -> 1 ball (숫자만 일치)
		 */
		
		Random rand = new Random();
		
		int arr[] = new int[3];
		int input[] = new int[3];
		int strike = 0;
		int ball = 0;
		
		arr[0] = rand.nextInt(10) + 1;
		arr[1] = rand.nextInt(10) + 1;
		while(arr[0] == arr[1]) {
			arr[1] = rand.nextInt(10) + 1;
		}
		arr[2] = rand.nextInt(10) + 1;
		while(arr[1] == arr[2] || arr[2] == arr[0]) {
			arr[2] = rand.nextInt(10) + 1;
		}
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < input.length; i++) {
			input[i] = sc.nextInt();
		}
		
		// strike 먼저 체크
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == input[i])
				strike++;
		}
		
		// ball 체크
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < input.length; j++) {
				if(arr[i] == input[j])
					ball++;
			}
		}
		
		for (int i = 0; i < arr.length; i++) { System.out.print(arr[i]); } 
		System.out.println();
		for (int i = 0; i < input.length; i++) { System.out.print(input[i]); }
		System.out.println();

		System.out.println("strike: " + strike + "개, ball: " + ball + "개");
		

		// 자바의 정석
		
	}

}
