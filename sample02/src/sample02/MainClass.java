package sample02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainClass {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// input (console)
		Scanner sc = new Scanner(System.in);
		sc.close();
		
		// boolean
//		boolean b;
//		System.out.println("b = ");
//		b = sc.nextBoolean();
//		System.out.println("input b = " + b);
		
		// integer
//		int num;
//		System.out.println("num = ");
//		num = sc.nextInt();
//		System.out.println("input num = " + num);
		
		// double
//		double d;
//		System.out.println("d = ");
//		d = sc.nextDouble();
//		System.out.println("input d = " + d);
		
		// String 
//		String str;
//		System.out.println("str = ");
//		str = sc.next();
//		System.out.println("input str = " + str);
		

//		System.out.println("str = ");
//		try {
//			String strr = br.readLine();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		// String 2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("strr = ");
		String strrr = br.readLine();
		System.out.println("input str = " + strrr);
		
		/*
		 * Scanner 와 BufferedReader 의 차이점 : 
		 */
		
		
	}

}
