package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		
		List<addressDTO> list = new ArrayList<>();
		
//		System.out.println("<< menu >>");
//		System.out.println("1. 추가");
		/*	String human[][] = {
		{ "홍길동", "24", "1234567", "서울시", "친구" },
		{ "성춘향", "16", "2345678", "남원시", "동생" },
		{ "홍두께", "22", "3456789", "전주시", "동문" },
		{ "홍길동", "27", "5678901", "판교", "상사" },
	};*/
		list.add(new addressDTO("홍길동", "24", "1234567", "서울시", "친구"));
		list.add(new addressDTO("성춘향", "16", "2345678", "남원시", "동생"));
		list.add(new addressDTO("홍두께", "22", "3456789", "전주시", "동문"));
		list.add(new addressDTO("홍길동", "27", "5678901", "판교", "상사"));
		
//		System.out.println("2. 삭제");
		System.out.println("삭제할 이름을 입력하시오 : ");
		Scanner sc = new Scanner(System.in);
		String delKey = sc.next();
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getName().equals(delKey)) {
				System.out.println(list.get(i).getName() + "가 삭제되었습니다. ");
				list.remove(i);
			}
		}		
		
//		System.out.println("3. 검색");
		System.out.println("검색할 이름을 입력하시오 : ");
		String searchKey = sc.next();
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getName().equals(searchKey)) {
				System.out.println(list.get(i).toString());
			}
		}
		
//		System.out.println("4. 수정");
		System.out.println("수정할 이름을 입력하시오 : ");
		String updateKey = sc.next();
		
		System.out.println("이름을 입력하시오: ");
		String newName = sc.next();
		System.out.println("나이를 입력하시오: ");
		String newAge = sc.next();
		System.out.println("번호을 입력하시오: ");
		String newPhone = sc.next();
		System.out.println("지역을 입력하시오: ");
		String newAddr = sc.next();
		System.out.println("관계를 입력하시오: ");
		String newRelationship = sc.next();
		
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getName().equals(updateKey)) {
				list.set(i, new addressDTO(newName, newAge, newPhone, newAddr, newRelationship));
				System.out.println(list.get(i).getName() + "이 수정되었습니다. ");
				break;
			}
		}
		
//		System.out.println("5. 출력");
		for (addressDTO addressDTO : list) {
			System.out.println(addressDTO.toString());
		}
		
//		System.out.println("6. 저장");
		// 응 ? 
		
//		System.out.println("7. 종료");
	}
}
