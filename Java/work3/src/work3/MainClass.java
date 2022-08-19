package work3;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 
		 * 학생 성적관리
		 * 
		 * >> 학생수 물어봐서
		 * >> 이차원 배열에 고정 할당
		 * 
		 * 입력 받기
		 * 학생이름, 번호, 국어, 영어, 수학 
		 * 
		 * 국어의 최고점수는 몇점? 누구?
		 * 
		 * 영어의 최하점수는 몇점? 누구?
		 * 
		 * 각 학생들의 총점, 평균
		 * 
 		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("학생 수를 입력하세요 : ");
		int count = sc.nextInt();
		
		String students[][] = new String[count+1][2];
		int scores[][] = new int[count][3];
		
		for(int i=0; i< count; i++)
		{
			System.out.print("학생이름, 번호, 국어점수, 수학점수, 영어점수를 입력하세요 : ");

			students[i][0] = sc.next();
			students[i][1] = sc.next();
			scores[i][0] = sc.nextInt();
			scores[i][1] = sc.nextInt();
			scores[i][2] = sc.nextInt();
		}
		
		int gukIdx = 0; int gukMax = -1;
		for(int i=0; i< count; i++)
		{
			if(gukMax < scores[i][0])
			{
				gukIdx = i;
				gukMax = scores[i][0];
			}
		}

		int engIdx = 0; int engMin = 500;
		for(int i=0; i< count; i++)
		{
			if(engMin > scores[i][2])
			{
				engIdx = i;
				engMin = scores[i][2];
			}
		}

		System.out.println("국어 점수 최고점은 " + scores[gukIdx][0] + "점 이며, " + students[gukIdx][0] + "학생 이다.");
		System.out.println("영어 점수 최하점은 " + scores[engIdx][2] + "점 이며, " + students[engIdx][0] + "학생 이다.");
		
		for(int i=0; i< count; i++)
		{
			int total = scores[i][0] + scores[i][1]+ scores[i][2];
			int avg = total / 3;
			System.out.println(students[i][0] + "학생 총점은 " + total + "점 이며, 평균은 " + avg + "점 이다.");
		}
	}

}
