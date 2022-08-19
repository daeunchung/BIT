package fileWrite;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class MainClass {
	public static void main(String[] args) throws Exception{
		
		File file = new File("C:\\Temp\\newfile.txt");
		
		FileWriter fWriter;
		
//		fWriter = new FileWriter(file);
//		fWriter.write("hello" + "\n");
//		fWriter.write("안녕하세요");
//		fWriter.close();
		
		// 추가기입
//		fWriter = new FileWriter(file, true);
//		fWriter.write("반갑습니다");
//		fWriter.close();
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		pw.println("안녕하세요");
		pw.print("Hello");
		pw.println("반갑습니다");
		pw.close();
		
	}
}
