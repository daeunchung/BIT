import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer extends Thread {// implements Runnable {

	String portNumber;
	ServerSocket ss;
	Service service;
	List<Service> list = new ArrayList<>();
	
	BufferedReader in;
	OutputStream out;
	Socket soc;
	

	// Constructor
	public ChatServer(int portNum) {
		try {
			ss = new ServerSocket(portNum);
			System.out.println("채팅 서버 서비스 중...");
			new Thread(this).start();	// 멀티쓰레드 실행

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("CharServer error : " + e);
		}

	}

	@Override
	public void run() { // ChatServer 의 run
		while (true) {

			try {
				// client 에게서 받은 소켓으로 서비스를 만들어 주었음
				Socket socket = ss.accept();
				service = new Service(socket);
				// 멀티쓰레드 service 를 동작 시작
				service.start();
				service.chat_name = service.in.readLine(); // 접속자 이름 읽기
				System.out.println(service.chat_name);

				service.messageSend("/c" + service.chat_name);
				for (Service ser : list) {
					ser.messageSend("/c" + service.chat_name);
					service.messageSend("/c" + service.chat_name);
				}

				list.add(service);

			} catch (Exception e) {
				System.out.println("ChatServer run err : " + e);
//				 TODO Auto-generated catch block
//				e.printStackTrace();
			}

		}

	}

	
	
	// client 별 처리를 위한 내부 클래스
	class Service extends Thread {

		String chat_name;
		BufferedReader in;
		OutputStream out;
		Socket socket;

		public Service(Socket socket) {
			// TODO Auto-generated constructor stub
			this.socket = socket;
			try {

				in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "euc-kr"));
				out = socket.getOutputStream();

			} catch (Exception e) {
				System.out.println("Service err : " + e);
			}
		}

		@Override
		public void run() {	// Service 의 run()

			while(true) {
				try {
					String msg = in.readLine();
					if(msg == null || msg.equals("")) continue;
					
					if(msg.charAt(0) == '/') {
						if(msg.charAt(1) == 'r') {	// "/r" 치면 대화면 변경
							messageAll("/r" + chat_name + "-" + msg.substring(2));
							chat_name = msg.substring(2);
							
						}else if(msg.charAt(1) == 'q') { // "/q" 치면 퇴장
							try {
								messageAll("/q" + chat_name);
								list.remove(this);
								in.close();
								out.close();
								socket.close();
							}catch (Exception e) {
								// TODO: handle exception
							}
							break;
							
						}
						
						else if(msg.charAt(1) == 's') {	// 귓속말		/s이름-메시지
							String name = msg.substring(2, msg.indexOf('-')).trim();
							for (Service ser : list) {
								if(name.equals(ser.chat_name)) {
									ser.messageSend((chat_name + ">(secret)" +
											msg.substring(msg.indexOf('-') + 1)));
								}
								
							}
							
						}
						
					}
					else {	// 일반 메세지
						messageAll(chat_name + ">" + msg);
						
					}
				} catch(Exception e) {
					break;
				}
			}
		}
		

		// ChatServer 의 messageAll() : 채팅방 안에있는 모든 접속자에게 메시지 보내는 메서드
		public void messageAll(String msg) {
			try {
				for (int i = 0; i < list.size(); i++) {
					Service ser = list.get(i);
					ser.messageSend(msg);
				}
			} catch (Exception e) {
				System.out.println("Service err : " + e);
			}

		}

		public void messageSend(String msg) {
			// TODO Auto-generated method stub

			try {
				out.write((msg + "\n").getBytes("euc-kr"));
			} catch (Exception e) {
				System.out.println("messageSend err : " + e);
			}

		}

	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		
//		/*
//		 * 일단 먼저 9000 포트 붙어서 채팅 목록 창 만들어 주고 나서 
//		 */
//		
//		
//		for(int i=9001; i<=9005; i++)
//			new ChatServer(i);
//
//	}

}
