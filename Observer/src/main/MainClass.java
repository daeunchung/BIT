package main;

import java.util.Observable;
import java.util.Observer;

import cls.MyClass;
import observer.ObserverA;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Observer : 정찰 or 감시
		 * 
		 * 
		 */
		MyClass cls = new MyClass();
		cls.addObserver(new ObserverA());
		
		cls.notifyObservers("password:abc123");
		
	}

}
