package net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import view.ClientFrame;
import view.IdFrame;

public class WriteClass {

	Socket socket;
	ClientFrame cf;
	
	public WriteClass(Socket socket, ClientFrame cf) {		
		this.socket = socket;
		this.cf = cf;
	}
	
	public void sendMessage() {
		
		try {
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			
			String msg = "";
			
			String id = IdFrame.tf.getText();
			
			// 첫번째 전송
			if(cf.isFirst) {
				InetAddress iaddr = socket.getLocalAddress();
				String ip = iaddr.getHostAddress();	// xxx.xxx.xxx.xxx					
				msg = "[" + id + "]님 로그인(" + ip + ")";
			}			
			// 그외 전송
			else {				
				msg = "[" + id + "]" + cf.textF.getText();
			}
			
			// server로 전송
			pw.println(msg);
			pw.flush();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
}






