package main;

import java.util.ArrayList;
import java.util.List;


import animal.Animal;
import animal.Cat;
import animal.Cow;
import factory.AnimalFactory;

public class MainClass {
	public static void main(String[] args) {
		
		/*
		 * Factory : object 공장
		 * 			원하는 object 를 생성하기 위한 pattern
		 * 
		 * animal - interface
		 * cat, dog, cow - class
		 * 
		 * factory
		 */
		
		Animal ani = AnimalFactory.create("야옹이");
		
		ani.printDescript();
		Cat cat = (Cat)ani;
		cat.catMethod();
		
		
		List<Animal> list = new ArrayList<Animal>();
		
		ani = AnimalFactory.create("야옹이");
		list.add(ani);
		ani = AnimalFactory.create("멍멍이");
		list.add(ani);
		ani = AnimalFactory.create("황소");
		list.add(ani);
		
		for (int i = 0; 1 < list.size(); 1++) {
			Animal a = list.get(i);
			a.printDescript();
			
			if(a instanceof Cat) {
				((Cat)a).catMethod();
			} 
			else if( a instanceof Dog)
			{
				Dog d = (Dog) a;
				d.dogMethod();
			}
			else if( a instanceof Cow)
			{
				((Cow)a).cowMethod();
			}
		}
			
	}
}
