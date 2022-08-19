package main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * (java)                                         web(json)
		 * HashMap : 사전
		 * 
		 * 사과 : apple
		 * key value -> 한쌍으로 관리된다 (pair)
		 * Tree 구조 (not 선형구조)
		 * 
		 * TreeMap : HashMap + sorting
		 * 
		 * 
		 */
		
//		HashMap<Integer, String> hMap = new HashMap<Integer, String>();
		
		Map<Integer, String> hMap = new HashMap<Integer, String>();
		
//		Map<Integer, String> hMap = new TreeMap<Integer, String>();
		
		// 추가
		hMap.put(1001, "Tigers");
		hMap.put(1002, "Lions");
		hMap.put(1003, "Twins");
		
//		String value = hMap.get(1002);
//		System.out.println(value);
		
		System.out.println(hMap.size());
		
		// 출력
		// 이터레이터 : 반복자(=포인터) ==> DB에서의 cursor
		Iterator<Integer> it = hMap.keySet().iterator();
		while(it.hasNext()) {
			Integer key = it.next();
			String value = hMap.get(key);
			System.out.println(key + " : " + value);
		}
		
		hMap.put(1002, "Giants");	//  key 값은 중복될 수 없기 때문에 수정된다
		
		// 삭제
		String delValue = 
		hMap.remove(1003);
		System.out.println("삭제데이터: " + delValue);
		
		// 검색
		boolean b = hMap.containsKey(1002);
		if(b == true)
		{
			String s = hMap.get(1002);
			System.out.println("value:" + s);
			
		}
		// 수정
		hMap.replace(1001, "eagles");
		
//		it = hMap
				
		// HashMap key : String
		// Integer, String, MyData
//		Map<String, Object> map = new HashMap<String, Object>();
		//instanceof
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("apple", "사과");
		map.put("dragonFruit", "용과");
		map.put("orange", "오렌지");
		map.put("lemon", "레몬");
		map.put("melon", "멜론");
		
		Iterator<String> it1 = map.keySet().iterator();
		while(it1.hasNext()) {
			String k = it1.next();
			String v = map.get(k);
			System.out.println("키 : " + k + " 값: "+ v);
		}
		
		// TreeMap
		TreeMap<String, String> tMap = new TreeMap<String, String>(map);

		// 내림차순
		Iterator<String> itKey = tMap.descendingKeySet().iterator();
		
		// 오름차순
//		Iterator<String> itKey = tMap.keySet().iterator();
		while(itKey.hasNext()) {
			String k = itKey.next();
			String v = map.get(k);
			System.out.println("키 : " + k + " 값: "+ v);
		}

	}

}

// addressBook 을 list 로 옮기기 DTO 다 만들어줘야함 과제 - 
