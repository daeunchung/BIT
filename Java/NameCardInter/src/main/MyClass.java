package main;

import cls.PrintEmailCard;
import cls.PrintNameCard;
import cls.PrintPhoneCard;

public class MyClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NameCard ncard = new NameCard("성춘향", "234", "sch@daum.net");
		
		ncard.setPrintNameCard(new PrintNameCard());
		ncard.print();
		
		ncard.setPrintNameCard(new PrintPhoneCard());
		ncard.print();
		
		ncard.setPrintNameCard(new PrintEmailCard());
		ncard.print();
	}

}
