package work;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 * 편의점
 * 지불금액 : 3210원
 * 본인 금액 : 10000원
 * 
 * 거스름 돈 ->?
 * 
 * 5000원권 ->?
 * 1000원권 ->?
 * 500원권 ->?
 * 100원권 ->?
 * 50원권 ->?
 * 10원권 ->?
 */
		Scanner sc = new Scanner(System.in);
		int pay = 3210;
		int my = 0;
		int change;
		
		System.out.println("지불 금액은 " + pay + " 입니다");
		System.out.println("금액을 넣어주세요");
		my = sc.nextInt();
		System.out.println(my + " 원 지불하셨습니다.");
		
		change = my - pay;
		System.out.println("거스름돈 5000원권은 " + change/5000 + "장 입니다");
		change = change - (change/5000) * 5000;
		System.out.println("거스름돈 1000원권은 " + change/1000 + "장 입니다");
		change = change - (change/1000) * 1000;
		System.out.println("거스름돈 100원권은 " + change/100 + "장 입니다");
		change = change - (change/100) * 100;
		System.out.println("거스름돈 50원권은 " + change/50 + "장 입니다");
		change = change - (change/50) * 50;
		System.out.println("거스름돈 10원권은 " + change/10 + "장 입니다");
		change = change - (change/10) * 10;
		
		sc.close();	
		
	
		// Random : 무작위, 난수
		// Random <--> Pattern
		
		// 0~9
		int r = (int)(Math.random() * 10);
		System.out.println("r = " + r);
		
		// 10 20 30 40 50
		r = ((int)(Math.random() * 5) + 1) * 10;	// (0 ~ 4)+1
	
		int x = (int)(Math.random() * 3) - 1;	// -1 0 +1
		int y = (int)(Math.random() * 3) - 1;	// -1 0 +1
		
		// 3 7 4 5 9
		int arr[] = {3,7,4,5,9};	// 배열로 놓고 idx 를 랜덤하게 뽑는다

	}

}
