package cls;

import single.SingletonClass;

public class YouClass {

	private int tag;


	public void setTag(int tag) {
		this.tag = tag;
	}


	@Override
	public String toString() {
		return "YouClass [tag=" + tag + "]";
	}
	
	public void func()
	{
		SingletonClass sc = SingletonClass.getInstance();
		tag = sc.num;	// Youclass 에서는 MyClass 에서 넘겨준 테구룰 number 로 받는다
	}
}
