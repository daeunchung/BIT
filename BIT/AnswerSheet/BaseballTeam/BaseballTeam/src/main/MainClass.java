package main;

import java.util.Scanner;

import dao.BaseballDao;
import dao.BaseballDaoImpl;

public class MainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BaseballDao dao = new BaseballDaoImpl();

		while(true) {
			System.out.println("menu ---------------------------");
			System.out.println("1.선수추가");
			System.out.println("2.선수삭제");
			System.out.println("3.선수검색");
			System.out.println("4.선수수정");
			System.out.println("5.선수출력");
			System.out.println("6.선수저장");
			System.out.println("7.타율순위");
			System.out.println("8.종료");
			System.out.print(">>>>> ");
			
			int work = sc.nextInt();
			
			switch(work) {
				case 1:
					dao.insert();
					break;
				case 2:
					dao.delete();
					break;
				case 3:
					dao.select();
					break;
				case 4:
					dao.update();
					break;
				case 5:
					dao.allprint();
					break;
				case 6:
					dao.dataSave();
					break;
				case 7:
					dao.hitRanking();					
					break;
				case 8:					
					System.exit(0);					
					break;			
			}					
		}			
	}
}







