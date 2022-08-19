package main;

import java.util.ArrayList;
import java.util.List;

import person.Person;
import types.AbstractItem;
import types.Atype;
import types.Btype;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person person = null;
		
		person.create(new Atype());
//		
//		person.m_weapon.drawWeapon();
//		person.m_bomb.drawBomb();
		
		List<Person> list = new ArrayList<Person>();
		 
		Person person1 = null;
		
		person1 = new Person();
		
		AbstractItem item = null;
		item = new Atype();
		person.create(item);
		list.add(person);
		
		item = new Btype();
		person = new Person();
		person.create(item);
		list.add(person)	;
		
		item = new Atype();
		person = new Person();
		person.create(item);
		list.add(person);
		
		for (Person p : list) {
			p.m_weapon.drawWeapon();
			p.m_bomb.drawBomb();
		}
		
	}

}


