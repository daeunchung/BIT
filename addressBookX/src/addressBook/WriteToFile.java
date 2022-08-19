package addressBook;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileWriter myWriter;
		try {
			myWriter = new FileWriter("filename.txt");
			myWriter.write("File in Java might be tricky, but it is fun enough!");
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("An error occurred.");
			e.printStackTrace();
		}


	}

}
