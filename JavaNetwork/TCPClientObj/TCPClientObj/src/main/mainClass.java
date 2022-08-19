package main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		InetSocketAddress sockAddr = new InetSocketAddress("192.168.2.40", 9000);
		
		Socket socket = new Socket();
		
		try {
			socket.connect(sockAddr);
			
			InetAddress inetAddr;
			if((inetAddr = socket.getInetAddress()) != null) {
				System.out.println("연결:" + inetAddr);
			}else {
				System.out.println("연결되지 않았습니다");
			}
			
			while(true) {
				System.out.print("이름:");
				String name = sc.next();
				
				MemberDto dto = new MemberDto(0, name);
				
				// send
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				oos.writeObject(dto);
				oos.flush();
				
				// recv			
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				MemberDto _dto = (MemberDto)ois.readObject();
				
				System.out.println("Server로부터 전송된 dto:" + _dto.toString());
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 				
		

	}

}
