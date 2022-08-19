
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Exception != error
		 * 
		 * 1~10 -> 'A' == 65
		 * 
		 * ex) 
		 * number -> A B C
		 * array -> index 범위초과  [0] ~ [9] -> [10]
		 * class -> 없음
		 * file -> 없음
		 * 
		 * 형식 : 
		 * try{
		 * 
		 *  // 예외가 발생될 가능성이 있는 코드
		 *  } catch(예외클래스1 e) {
		 *   	메시지를 출력
		 *  } catch(예외클래스2 e) {
		 *   	메시지를 출력
		 *  } catch(예외클래스3 e) {
		 *   	메시지를 출력
		 *  } finally {
		 *  	무조건 실행
		 * 		rollback
		 *  }
		 * 
		 * 
		 * void method() throws 예외클래스 {
		 * 
		 * }
		 */
		
//		int array[] = {1, 2, 3};
//		
//		try {
//			for (int i = 0;  i < 4; i ++) {
//				System.out.println(array[i]);
//			}
//		} catch(ArrayIndexOutOfBoundsException e) {
////			System.out.println("배열 범위 초과");
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//			
////			return ;
//			
//		} catch(Exception e) {
//			// TODO : handle exception
//		} finally {
//			
//			System.out.println("finally!!!!");
//		}
//		System.out.println("end");
		
		method();
		
		try {
			callClass();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	// Unhandled type 이라서 try catch 로 감싼다.

	}
	
	static void method() throws IndexOutOfBoundsException
	{
		int array[] = {1, 2, 3};
	
		for (int i = 0;  i < 4; i ++) {
			System.out.println(array[i]);
		}
	}
	
	static void callClass() throws ClassNotFoundException
	{
		Class.forName("myclass");
		System.out.println("callClass()");
	}

}
