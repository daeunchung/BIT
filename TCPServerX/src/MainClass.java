import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		06-13
		
       TCP: Transission Control Protocol 전송 제어 규약
       Server: TCP, web(tomcat),Database
       
        종단 시스템: host 
                 PC, Smart phone, Scanner, printer
                 
        Router : hardware s
                 host 간에 상호 데이터를 교환할 수 있도록 하는 장비
                 
        Inter network : 포괄적인 통신
        
        통신규약
        TCP - Transmission Control Protocol 동기 통신
        UDP - User Datagram protocol         비동기 통신

        7 Layer
        
        1계층 - 물리계층(physical Layer)
        2계층 - 데이터링크 계층(Data Link Layer) 주소를 헤더에 첨부
        3계층 - 네트워크 계층(Network Layer) 네트워크 IP -> Address
        4계층 - 전송계층(Transport Layer) 네트워크 port 
        5계층 - 세션 계층(Session Layer)  세션을 동기화
        6계층 - 표현 계층(Presentation Layer) 보안, 압축, 확장
        7계층 - 응용 계층(Application Layer) 프로그램
	        
		
		
		TCP 에서 체크하는 내용 
		카카오톡 전송되지 않았음 (전송실패 메시지 체크같은거 tcp에서 한다)
		
		TCP 
		신사적인 Protocol, 신뢰할 수 있는 규약
		전화 -> 상대방 -> 연결 -> 통신 start
		동기화 : send -> recv 처리순서가 맞아야 한다.
		데이터의 경계가 없다. 용량 제한이 없음 (보내고 나서 다 확인한다)
		따라서 채팅(문자열 전송), object 전송(class 자체를 전송)
		
		
		UDP
		비 연결형 Protocol
		편지, 지상파방송
		데이터의 경계가 있다.
		1대 1통신 (unicast)
		1대 다   (broadcast)
		다 대 다 (multicast)
		
		rpg 게임? 게임서버는 udp 게임 내에 채팅은 tcp
	
		Packet(응용)
		제어정보, 데이터(문자열, object) 결합된 형태로 전송
		IP , Port, String : 
			
		IP : Internet Protocol => 주소
		IPv4 : xxx.xxx.xxx.xxx -> 0~255
		IPv6 : xxx.xxx.xxx.xxx.xxx.xxx 
		
		127.0.0.1 자기자신의 접속주소
		Port Number
		IP 주소는 internet에 존재하는 host(PC) 를 식별할 수 있으나
		최종주체인 프로세스(프로그램)을 식별하지 못하기 때문에
		프로세스를 구별하기 위한 지정한 수치(0~1024) 외의 숫자를 지정한다.
		
		Socket
		통신의 주체, 통신을 하기 위한 오브젝트
		IP, TCP/UDP 정보를 가진다.
		
		통신 순서
		서버가 먼저 보내는 경우 절대 없음 (TCP 서버는 항.상. 받을 준비를 하고 있어야함)
		
				server                         client
		1.      Socket 버전확인          		1. Socket 버전확인 
		2.		Binding -> IP, Port	
		3.		Listener
		4.		Accept		<----------		2. Connect
		
				1) recv <-----------------  send(write)
				2) send ------------------>  recv(read)
				
		DNS(Domain Name System ) 
				
				
				cmd
	ipconfig
	netstat
	ping www.naver.com 
		 */
		
		// client 정보를 담는 소켓
		Socket clientSocket = null;
		try {
			
			// 윈도우에서 네트워크 프로그래밍 시에 코드가 매우 길고 복잡하다
			// 자바에서는 이를 ServerSocket (import java.net.ServerSocket) 로 
			// 1.버전확인 2. binding 3. listening 단계 모두 해결
			// 문지기 소켓
			ServerSocket serSocket = new ServerSocket(9000);
			
			List<Socket> list = new ArrayList<Socket>();
			
			
//			while(true) {
				
				System.out.println("접속 대기중...");
				// client 가 보낸 모든 정보를 다 가지고 있는 곳이 clientSocket
				clientSocket = serSocket.accept();
				
				list.add(clientSocket);
				
				// 접속 client 확인
				System.out.println("client IP: " + clientSocket.getInetAddress() 
						+ " Port:" + clientSocket.getPort());
//			}
			
			while(true)
			{
				
				// 수신(recv)
				BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				String str = reader.readLine();	// 직접 수신
				System.out.println("client로부터 받은 메시지 : " + str);
				
				// 송신(send)
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
				writer.println(str);
				writer.flush();
				
				Thread.sleep(300);

			}
			
//			clientSocket.close();
//			serSocket.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

		
	}

}
