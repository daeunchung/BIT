import cls.Human;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 절차지향적 순서 중시
		 * 1 -> 2 -> 3 -> 
		 * 장점 : 속도가 빠르다
		 * 
		 * 5만 라인을 초과하는 순간 작성자ㅏ가 힘들어 진다
		 * 
		 * OOP Object Oriented Programming -> C++
		 * 
		 * int human[][] = {
		 * 	{name, age, address}, -> item -> pointer
		 * 	{name, age, address},
		 * 	{name, age, address}
		 */

		// 자바에서는 무조건 객체 생성을 해줘야 사용가능하다  // h : instance, object, 객체 (class 변수)
		Human h = new Human();
		h.name = "홍길동";
		h.age = 24;
		h.address = "서울시";
	}

}
