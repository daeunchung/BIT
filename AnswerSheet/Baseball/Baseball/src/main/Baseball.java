package main;

import java.util.Arrays;
import java.util.Scanner;

public class Baseball {
	
	Scanner sc = new Scanner(System.in);
	
	int r_num[] = null;
	boolean clear;
	
	// init
	// 	random -> 3"
	public void init() {
		r_num = new int[3];
		clear = false;
		
		random();
	}
	
	public void random() {
		boolean swit[] = new boolean[10]; 
		
		int w = 0;		
		while(w < 3) {
			int r = (int)(Math.random() * 10); // 0 ~ 9
			if(swit[r] == false) {
				swit[r] = true;		// 00010 00000
				r_num[w] = r + 1;				// 1 ~ 10
				w++;
			}
		}
		
		System.out.println(Arrays.toString(r_num));
	}
		
	// loop -> 10회
	public void loop() {
		int u_num[] = new int[3];
				
		int w = 0;
		while(w < 10) {
			
			// user input
			for(int i = 0;i < u_num.length; i++) {
				System.out.print((i + 1) + "번째 수 = ");
				u_num[i] = sc.nextInt();
			}			
			
			// finding
			int strike = 0;
			int ball = 0;
			
			// ball
			for (int i = 0; i < u_num.length; i++) {
				for (int j = 0; j < u_num.length; j++) {
					if(u_num[i] == r_num[j] && i != j) {
						ball++;
					}
				}
			}
			// strike
			for (int i = 0; i < u_num.length; i++) {
				if(u_num[i] == r_num[i]) {
					strike++;
				}
			}
			
			if(strike > 2) {
				clear = true;
				break;
			}
			
			// message
			System.out.println(strike + "스트라이크 " + ball + "볼입니다");
			
			w++;
		}		
	}
		
	// release
	// 	result
	public void result() {
		if(clear) {
			System.out.println("Game Clear!");
		}else {
			System.out.println("Game Over~");
		}
	}
	
	public void game() {
		while(true) {
			init();
			loop();
			result();
			
			System.out.print("play again(y/n) = ");
			String nextGame = sc.next();
		
			if(!nextGame.equals("y")) {
				System.out.println("Good Bye");
				break;
			}
			
			System.out.println("Next Game Start!!!");			
		}
	}
}





