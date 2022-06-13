package threadex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ServerThread extends Thread {

	Socket socket;
	List<Socket> list;
	
	public ServerThread(Socket socket, List<Socket> list) {
		this.socket = socket;
		this.list = list;
	}

	@Override
	public void run() {		
		super.run();
		
		try {
			
			while(true) {
		
				// 수신(recv)
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String str = reader.readLine();					
				System.out.println("client로부터 받은 메시지:" + str);
												
				// 송신(send)
				for (Socket s : list) {
					if(socket != s) {
						PrintWriter writer = new PrintWriter(s.getOutputStream());
						writer.println(str);
						writer.flush();
					}
				}				
				
				Thread.sleep(300);				
			}
		
		} catch (IOException e) {			
			e.printStackTrace();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}		
	}
	
	
}
