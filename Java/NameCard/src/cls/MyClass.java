package cls;

public class MyClass {

	public static void main(String[] args) {
		
		NameCard ncard = new NameCard("홍길동", "123", "hgd@naver.com");
		
		ncard.setPrintNameCard(new PrintNameCard());
		
		ncard.print();
		
		ncard.setPrintNameCard(new PrintPhoneCard());
		ncard.printPhone();
	}
}
