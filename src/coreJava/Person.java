package coreJava;

class Person extends Collection {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//	public void setName(String name) {
//		this.name = name;
//	}
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

	public int getAge() {
		return age;
	}

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//	public void setAge(int age) {
//		this.age = age;
//	}
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

	@Override
	public boolean equals(Object obj) {
		System.out.println("in equals");
		Person p = (Person) obj;

		return this.getName().equals(p.getName())
				&& this.getAge() == p.getAge();

	}
}
