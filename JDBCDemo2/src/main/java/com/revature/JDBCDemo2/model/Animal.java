package com.revature.JDBCDemo2.model;

public class Animal {
	private int id;
	private String name;
	private int age;
	private int legs;

	public Animal(int id, String name, int age, int legs) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.legs = legs;
	}

	public Animal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getLegs() {
		return legs;
	}

	public void setLegs(int legs) {
		this.legs = legs;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", name=" + name + ", age=" + age + ", legs=" + legs + "]";
	}

}
