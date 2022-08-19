
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// 싱글 스레드
		Thread thread0 = new ThreadEx("하이");

		// 멀티 스레드
		Thread thread1 = new ThreadEx("퐁");
		Thread thread2 = new ThreadEx("당");
		Thread thread3 = new ThreadEx("!");
		
		thread1.start();
		thread2.start();
		thread3.start();

	}

}
