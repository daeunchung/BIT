package fileIO;

import java.io.File;
import java.io.IOException;

public class MainClass {

	public static void main(String[] args) // throws Exception
	{
		// TODO Auto-generated method stub
		/*
		 * 저장매체 : 파일, Database
		 * 
		 * *.txt, 
		 * *.java, *.cpp, dll, lib
		 * 				*.jar
		 * 				*.xml
		 * 				*.json
		 * 		
		 * 
		 * dll = Dynamic Link Library -> 동적파일 / 메모리를 다량 필요로함
		 * 
		 * lib = Library -> 정적 파일
		 * 
		 * program -> 1 -> 2 -> 3
		 * 
		 */
		
		File file = new File("C:\\");
		
//		String filelist[] = file.list();
//		for (int i = 0; i < filelist.length; i++) {
//			System.out.println(filelist[i]);
//			
//		}
//		File fileList[] = file.listFiles();
//		for (int i = 0; i < fileList.length; i++) {
//			if(fileList[i].isFile()) {
//				System.out.println("[파일]" + fileList[i].getName());
//			}
//			else if(fileList[i].isDirectory()) {
//				System.out.println("[폴더]" + fileList[i].getName());
//			}else {
//				System.out.println("[?]" + fileList[i].getName());
//
//			}
//		}
		
		// 파일 생성
		File newfile = new File("C:\\Temp\\newfile.txt");		// 파일포인터만 만들어 준것
		try {
			newfile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		if(newfile.createNewFile()) {
//			System.out.println("파일 생성 성공 !");
//		}else  {
//			System.out.println("파일 생성 실패 !");
//		}
		
		// 폴더 생성
		File newDir = new File("C:\\Temp\\sub\\Dir");
		if(newDir.mkdir()) {
			System.out.println("폴더 생성 성공!");
			
		}
		else {
			System.out.println("폴더 생성 실패!");
		}
		
		// 파일 존재 여부
		if(newfile.exists()) {
			System.out.println("파일이 존재합니다.");
		}
		
		// 읽기 전용
//		newfile.setReadOnly();
		// 쓰기 전용
		newfile.setWritable(true);
		// 삭제
		newfile.delete();
		
;	}

}
