package addressBook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		/*
		 * 주소록
		 * 
		 * column : 이름, 나이, 전화번호, 주소, 메모
		 * 2차원 배열 : row = 100"
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
		File file = new File("C:\\Temp\\address.txt");

		int input = 0;
		while(true) {
			Scanner sc = new Scanner(System.in);
			switch (input) {
			case 1:
				func1();
				break;
			case 2:
				func2();
				break;
			case 3:
				func3();
				break;
			case 4:
				func4();
				break;
			case 5:
				func5();
				break;
			case 6:
				func6();
				break;
			case 7:
				func7();
				break;
			default:
				exit();
			}
		}
	}
	
	static void func1()
	{
	FileWriter fWriter;
		
		fWriter = new FileWriter(file);
		fWriter.write("hello" + "\n");
		fWriter.write("안녕하세요");
		fWriter.close();
		
		// 추가기입/		fWriter = new FileWriter(file, true);
		fWriter.write("반갑습니다");
		fWriter.close();
	}
}
//
		File file = new File("C:\\Temp\\address.txt");
//		
//		// 한글자씩 읽기
////		FileReader fr = new FileReader(file);
////		int ch;// = fr.read();
////		while(ch != -1)
////		{
////			System.out.println((char)ch);
////			// ch = fr.read();
////		}
////		fr.close();
//		
//		// 한문장으로 읽기
//		BufferedReader br = new BufferedReader(new FileReader(file));
//		
//		String str = "";
//		while((str = br.readLine()) != null) {
//			
//		}
//		br.close();
//		
//		String arr[][] = new String[100][2];
//		
//
//	}
//
//}
