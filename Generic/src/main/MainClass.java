package main;

import java.util.ArrayList;
import java.util.List;


public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 
		 * Generic : 자료형의 변수
		 * 			같은 클래스에서 다양한 자료 (Integer) 형을 사용하고 싶을 때 정의하는 요소
		 * 
		 * 			template(=형태)
		 * 
		 * 
		 */
//		Box<int> box = new Box<int>(123);
		Box<Integer> box = new Box<>(123);
		System.out.println(box.getTemp() + 124);
		
		Box<String> sbox = new Box<String>("hello");
		System.out.println(box.getTemp() + 124);

		Boxmap<String, Integer> bmap = new Boxmap<>("홍길동", 245);
		System.out.println(bmap.getName());
		System.out.println(bmap.getValue());

		
//		ArrayList<Integer> list = new ArrayList<Integer>();
	
		
		List<Integer> list = new ArrayList<Integer>();
		
		// 추가
		Integer in = new Integer(111);
		list.add(in);
		
		list.add(222);
		
		list.add(new Integer(333));
		
		int len = list.size();
		
		System.out.println("목륵의 크기 : " + len);
		for (int i = 0; i < len; i++) {
			System.out.println(list.get(i));
		}
		
		// 원하는 위치에 추가 (1번지에 200을 추가)
		list.add(1, 200);
		
		for (Integer integer : list) {
			System.out.println(integer);
		}
		
		// 삭ㅈㅔ  // 2가지 element 를 직접, 또는 index 로 알려주기
		list.remove(2);
		
		
		// 검색
		int index = list.indexOf(333);
		System.out.println(index);
		
		index  = -1;
		for (int i = 0; i < list.size(); i++) {
			Integer v = list.get(i);
			if(v == 200) {
				index = i;
				break;
			}
		}
		System.out.println(index);
		
		// 수정
		list.set(2, 666);
		
		for (Integer integer : list) {
			System.out.println(integer);
			
		}
	
		
		
		List<MyData> objlist = new ArrayList<MyData>();
		
				
		// 추가 5개
		objlist.add(new MyData("가"));
		objlist.add(new MyData("나"));
		objlist.add(new MyData("다"));
		objlist.add(new MyData("라"));
		objlist.add(new MyData("마"));
		
		// 원하는 위치에 추가
		objlist.add(2, new MyData("바"));
		
		// 검색 이름(동일
		objlist.get(2);
		// 수정
		objlist.set(2, new MyData("사"));
		// 삭제
		objlist.remove(2);
		
		
		for (MyData md : objlist) {
			System.out.println(md);
			
		}
	
	}
}

class Boxmap<K, V> {
	K name;
	V value;
	public Boxmap(K name, V value) {
		this.name = name;
		this.value = value;
	}
	public K getName() {
		return name;
	}
	public void setName(K name) {
		this.name = name;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
}

class Box<T>{
	
	T temp;
	
	public Box(T temp) {
		this.temp = temp;
	}

	public T getTemp() {
		return temp;
	}

	public void setTemp(T temp) {
		this.temp = temp;
	}
	
}