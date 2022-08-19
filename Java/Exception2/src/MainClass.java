import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//NullPointerException
		String str = null;	// 객체가 아예 생성되지 않았음
		String str1 = "";	// c++ 이면 String str1 = new String(""); 생성자로 생성된 꼴
		
		try {
			
			System.out.println(str.length());
		} catch (NullPointerException e)
		{
			System.out.println("str은 null입니다.");
			str = "hello";
		}
		System.out.println("str = " + str);
		
		// ArrayIndexOutOfBoundsException
		
		int arr[] = {1, 2, 3};
		try {
			arr[3] = 4;
		} catch (ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
		} catch(Exception e) {
			
			
		}
		
		// FileNotFoundException
		
		File file = new File("C:\\xxx");
		FileInputStream is;
		
		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// NumberFormatException
		
		try {
			int i = Integer.parseInt("12a34");
		} catch(NumberFormatException e) {
			e.printStackTrace();
			System.out.println("숫자가 아닙니다");
		}
	}

}
