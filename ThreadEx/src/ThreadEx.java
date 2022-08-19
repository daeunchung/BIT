
public class ThreadEx extends Thread{
	
	String msg;
	
	public ThreadEx(String msg)
	{
		this.msg = msg;
	}
	
	
	@Override
	public void run() {
		super.run();
		
		// for for for
		for (int i = 0; i < 10; i++) {
			System.out.println(msg);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
