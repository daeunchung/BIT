package server;
import java.util.Vector;

/*
 * 롯데 e커머스 정다은 
 * 2022-06-15
 */

public class Room {//대화방의 정보표현 객체
    String title;//방제목
    int count;//방 인원수
    String boss;//방장(방 개설자)
    Vector<Service> userV;//userV: 같은 방에 접속한 Client정보 저장

    public Room() {
    	userV = new Vector<>();
	} 
}