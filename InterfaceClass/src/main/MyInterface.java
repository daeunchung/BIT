package main;

public interface MyInterface {

//	private int number;	// 변수, 일반 메서드 추가 불가능
	
//	public void func() {}
	
	// 오직 껍데기 프로토타입 선언만이 가능하다
	
	public void method(int n);
	
	
	// 생성 불가능
	// MyInterface myInter = new MyInterface();
	MyInterface myInter = new MyInterface() {
		
		@Override
		public void method(int n) {
			// TODO Auto-generated method stub
			
		}
	};
}
