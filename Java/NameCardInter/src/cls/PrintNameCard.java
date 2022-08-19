package cls;

import inter.PrintNameInterface;
import main.NameCard;

public class PrintNameCard implements PrintNameInterface{

	public void print(NameCard nc)
	{
		System.out.println("이름: " + nc.name);
	}
}
