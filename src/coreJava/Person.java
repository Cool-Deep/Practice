package coreJava;

class Person extends Collection {
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("in equals");
		Person p = (Person) obj;

		return this.getName().equals(p.getName())
				&& this.getAge() == p.getAge();

	}
}
