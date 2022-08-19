import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class RoomController implements Runnable {

//	RoomService rService;
	ServerSocket ss;
	List<ChatServer> roomList;

	
	// Constructor
	public RoomController()
	{
		try {
			roomList = new ArrayList<ChatServer>();

			ss = new ServerSocket();
			System.out.println("채팅 서버 서비스 중...");
			new Thread(this).run(); // 한개만
			
		} catch (IOException e) {
			e.printStackTrace();
		}


	}
	
	public void addNewChatRoom(int portNum)
	{
		ChatServer chatSer = new ChatServer(portNum);	// roomList port Number = 9000
		roomList.add(chatSer);
		
	}
	
	@Override
	public void run() {
	}


	// RoomController 의 run 메서드
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		while(true)
//		{
//			try {
////				Socket socket = ss.accept();
//				ChatServer chatSer = new ChatServer(9000);	// roomList port Number = 9000
////				rService = new RoomService(socket);
////				rService.start();
//				chatSer.start();
//				chatSer.portNumber = chatSer.in.readLine(); // 접속자 이름 읽기
////				System.out.println(chatSer.portNumber);
//
//				roomList.add(chatSer);
//
//			} catch (Exception e) {
//				System.out.println("ChatServer run err : " + e);
////				 TODO Auto-generated catch block
////				e.printStackTrace();
//			}
//		}
//	}
	
	
	
//	class RoomService extends Thread {
//		
//		String chatRoomNum;		// portNum 으로 받아줍니다
//		BufferedReader in;
//		OutputStream out;
//		Socket socket;
//		
//		// RoomService 생성자
//		public RoomService(Socket socket) {
//			this.socket = socket;
//			try {
//
//				in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "euc-kr"));
//				out = socket.getOutputStream();
//
//			} catch (Exception e) {
//				System.out.println("Room Service err : " + e);
//			}
//		}
//		
//		
//		@Override
//		public void run() {		// RoomService 의 run 메서드
//			while(true) {
//				
//				String chatRoomPortNum;
//				try {
//					chatRoomPortNum = in.readLine();
//					int crPortNum = Integer.parseInt(chatRoomPortNum);
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		
//		}
//		
//	}
	
	
	public static void main(String[] args) {
		new RoomController();
		
		
	}
}

