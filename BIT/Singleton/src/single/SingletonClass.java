package single;

public class SingletonClass {

	private static SingletonClass sc = null;
	
	public int num;
	
	private SingletonClass() {
		// TODO Auto-generated constructor stub
		
		// 생성을 하지 못하도록 막아놓는것 
	}
	
	public static SingletonClass getInstance()		// 어디서나 생성할 수 있도록 만들어 주어야함
	{
		if(sc == null) {
			sc = new SingletonClass();
		}
		return sc;
	}
}
