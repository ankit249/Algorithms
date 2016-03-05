package com.ds.oop;

public class Person {
	String title;
	String name;
	int age;

	private volatile int hashCode = 0;

	public Person(String title, String name, int age) {
		this.title = title;
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getTitle() {
		return title;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Person)) {
			return false;
		}
		Person person = (Person) obj;
		return age == person.getAge() && name.equals(person.getName()) && title.equals(person.getTitle());

	}

	public int hashCode() {
		final int prime = 31;
		if (hashCode == 0) {

			hashCode = hashCode * prime + age;
			hashCode = hashCode * prime + name.hashCode();
			hashCode = hashCode * prime + title.hashCode();

		}
		return hashCode;
	}

	public static void main(String[] args) {
		Person p1 = new Person("Architect", "Ankit", 36);
		Person p2 = new Person("Architect", "Ankit", 36);

		System.out.println(p1.equals(p2));
		System.out.println(p1.hashCode);
		System.out.println(p2.hashCode);
	}

}
