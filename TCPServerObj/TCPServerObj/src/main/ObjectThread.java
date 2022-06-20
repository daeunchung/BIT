package main;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ObjectThread extends Thread {

	Socket socket;
	int MemberNum;
	
	public ObjectThread(Socket socket, int MemberNum) {
		this.socket = socket;
		this.MemberNum = MemberNum;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		try {
			while(true) {
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				MemberDto dto = (MemberDto)ois.readObject();
				
				System.out.println("client로 부터 Obj:" + dto.toString());
				
				dto.setNumber(MemberNum);
				
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				oos.writeObject(dto);
				oos.flush();				
			}
		
		}catch (Exception e) {
			
		}
		
	}
	
	
}
