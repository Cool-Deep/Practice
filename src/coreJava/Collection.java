package coreJava;

import java.util.HashSet;

class Collection {
	public static void main(String[] args) {
		HashSet<Person> set = new HashSet<>();
		
		Person p1 = new Person("Viru", 1);
		Person p2 = new Person("Viru", 2);
		Person p3 = new Person("Viru", 3);
		set.add(new Person("Viru", 23));
		set.add(new Person("Viru", 23));
		set.add(new Person("Viru", 23));
		set.add(new Person("Viru", 23));
		set.add(new Person("Viru", 23));
		set.add(new Person("Viru", 23));
		set.add(p1);
		set.add(p2);
		set.add(p3);

		for (Person c : set) {
			System.out.print(c.getName() + " ");
			System.out.println(c.getAge());
		}
	}

}