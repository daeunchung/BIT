package threadex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ServerThread extends Thread{
	
	Socket socket;
	
	List<Socket> list;

	public ServerThread(Socket socket, List<Socket> list) {
		this.socket = socket;
		this.list = list;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		try {
			
			while(true)
			{
				
				// 수신(recv)
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String str = reader.readLine();	// 직접 수신
				System.out.println("client로부터 받은 메시지 : " + str);
				
				for (Socket s : list) {
					
					if(socket != s) {
						// 송신(send)
						PrintWriter writer = new PrintWriter(socket.getOutputStream());
						writer.println(str);
						writer.flush();
					}
				}
				
				Thread.sleep(300);

			}
			
		} catch (Exception e) {
			System.out.println("연결이 끊긴 IP :  " + socket.getInetAddress());
			list.remove(socket);
			
			// 접속되어 있는 남아있는 클라이언트를 출력
			for (Socket s : list) {
				System.out.println("접속되어 있는 IP " + s.getInetAddress() 
				+ " Port No: " + s.getPort());
			}
			
			try {
				socket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
//			catch (IOException e) {
//			e.printStackTrace();
//			
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
	}
}

