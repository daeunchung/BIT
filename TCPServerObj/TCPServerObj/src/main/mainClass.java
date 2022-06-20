package main;

import java.net.ServerSocket;
import java.net.Socket;

public class mainClass {

	public static void main(String[] args)throws Exception {
		
		int MemberNum = 0;
		
		ServerSocket serSocket = new ServerSocket(9000);
		
		while(true) {
			System.out.println("대기중...");
			Socket socket = serSocket.accept();
			
			MemberNum++;
			
			new ObjectThread(socket, MemberNum).start();
		}

	}

}




