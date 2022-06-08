package addressBook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class MainClass {

	// 주소록 만들기
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 주소록
		 * 
		 * column : 이름, 나이, 전화번호, 주소, 메모
		 * 2차원 배열 : row = 100" -> list & 
		 * 
		 * 데이터 파일에서 불러오기 -> 2차원 배열안에 넣기 
		 * 
		 * Menu
		 * 1. 인명추가
		 * 2. 인명삭제
		 * 3. 검색 이름, (전화번호)
		 * 4. 수정
		 * 5. 모든 데이터 출력
		 * 6. 데이터 저장
		 * 7. 종료
		 * 
		 */

		String human[][] = new String[100][5];
//		String human[][] = {
//				{"홍길동", "24", "123-4567", "서울시", "친구"},
//				{"방정환", "34", "123-4567", "세종시", "동생"},
//				{"김김김", "24", "155-5567", "서울시", "친구"},
//				{"김김김", "70", "000-0000", "서울시", "상사"}
//		};
		
		
		// TODO : main
		String[][] human = load("accountBook");
		int humanCount = human.length;
//		int humanCount = 0;
		while(true)
		{
			System.out.println("<<menu>>");
			System.out.println("1. 추가");
			System.out.println("2. 삭제");
			System.out.println("3. 검색");
			System.out.println("4. 수정");
			System.out.println("5. 출력");
			System.out.println("6. 저장");
			System.out.println("7. 종료");
			
			System.out.println("메뉴번호를 입력해 주십시오 >> ");
			int number = sc.nextInt();
			
			switch(number)
			{
			case 1:
				insert(human, humanCount);
				break;
			case 2:
				delete(human);
				break;
			case 3:
				select(human);
				break;
			case 4:
				update(human);
				break;
			case 5:
				print(human);
				break;
			case 6:
				save(human, humanCount);
				break;
			case 7:
				
			}
		}
		
		print(human);
//		insert(human, humanCount);
//		delete(human);
//		update(human);
		select(human);
		print(human);
	}
	
	// CRUD - create read update delete
	// DAO - Data Access Object

	static int insert(String[][] human, int humanCount) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름 = ");
		String name = sc.next();
		System.out.println("나이 = ");
		int age = sc.nextInt();
		System.out.println("전화번호 = ");
		String phone = sc.next();
		System.out.println("주소 = ");
		String address = sc.next();
		System.out.println("메모 = ");
		String memo = sc.next();
		
		human[humanCount][0] = name;
		human[humanCount][1] = age + "";
		human[humanCount][2] = phone;
		human[humanCount][3] = address;
		human[humanCount][4] = memo;
		
		
		humanCount++;
		return humanCount;
	}

	static void delete(String[][] human)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("삭제하고 싶은 이름 = ");
		String name = sc.next();
		
		int index = search(human, name);
		if(index == -1)
		{
			System.out.println("정보를 찾을 수 없습니다. ");
			return;
		} else {
			human[index][0] = "";
			human[index][1] = "";
			human[index][2] = "";
			human[index][3] = "";
			human[index][4] = "";
		}

	}
	static void select(String[][] human)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("검색하고 싶은 이름 = ");
		String name = sc.next();
		
		String findMember[][] = searchAll(human, name);
		
		if(findMember == null) {
			System.out.println("정보를 찾을 수 없습니다.");
			return;
		}
		
		for (int i = 0; i < findMember.length; i++) {
			System.out.println(Arrays.toString(findMember[i]));
		}
	}
	
	
	static void update(String[][] human)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("수정하고 싶은 이름 = ");
		String name = sc.next();
		
		int index = search(human, name);
		if(index == -1)
		{
			System.out.println("정보를 찾을 수 없습니다. ");
			return;
		} 
		System.out.println("수정할 전화번호 = ");
		String phone = sc.next();
		
		human[index][2] = phone;
		System.out.println("정상 수정되었습니다. ");

	}
	
	static int search(String[][] human, String name)
	{
		int index = -1;
		
		for (int i = 0; i < human.length; i++) {
			if(human[i][0] != null && human[i][0].equals(name)) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	static String[][] searchAll(String[][] human, String name)
	{
		int count = 0;
		// 카운터
		for (int i = 0; i < human.length; i++) {
			if(human[i][0] != null && human[i][0].equals(name)) {
				count++;
			}
		}
		
		if(count == 0) 
			return null;
		
		// 할당
		String findMember[][] = new String[count][5];
		int cou = 0;
		
		// 데이터 저장
		for (int i = 0; i < human.length; i++) {
			if(human[i][0] != null && human[i][0].equals(name)) {
				findMember[cou] = 
						human[i][0] + "-" 
						+ human[i][1] + "-" 
						+ human[i][2] + "-" 
						+ human[i][3] + "-" 
						+ human[i][4];
				cou++;
			}
		}
		
		
	}
	static void print(String[][] human)
	{
//		for (int i = 0; i < human.length; i++) {
//			for (int j = 0; j < human[i].length; j++) {
//				if(human[i][j] != null &&!human[i][j].equals(""))
//				System.out.print(human[i][j] + " ");
//			}
//			System.out.println();
//		}
		for (int i = 0; i < human.length; i++) {
			if(human[i][0] != null && !human[i][0].equals(""))
				System.out.println(Arrays.toString(human[i]));
		}
	}
	
	static void save(String[][] human, String filename)
	{
		
		int count = 0;
		for (int i = 0; i < human.length; i++) {
			if(human[i] != null && !human[i][0].equals(""))
			{
				count++;
				System.out.println(Arrays.toString(human[i]));
			}
		}
		
		// 상대경로와 절대경로 중에서 절대경로를 많이 사용
		// TODO : save(String[][] , String )
		File file = new File("C:\\Temp\\" + filename + ".txt");
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			
			for (int i = 0; i < findMember.length; i++) {
				pw.println(findMember[i]);
				
			}
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static String[][] load(String filename)
	{
		File file = new File("C:\\Temp\\" + filename + ".txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
//			int count = 0;
			String str = "";
			while((str = br.readLine() != null))
			{
				String data[] = str.split("-");
				
				human[count][0] = data[0];
				human[count][1] = data[1];
				human[count][2] = data[2];
				human[count][3] = data[3];
				human[count][4] = data[4];
			}
				
			br.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch()
		{
			
		}
		return null;
	}
}
