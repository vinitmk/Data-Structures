package com.mkv.datastructures.model;


public class Student {

	private int age;
	private String name;
	private int avgMarks;

	Student(int age, String name, int avgMarks) {
		this.age = age;
		this.name = name;
		this.avgMarks = avgMarks;
	}

	String getName() {
		return name;
	}

	int getAvgMarks() {
		return avgMarks;
	}

	@Override
	public String toString() {
		return "Student{" +
				"age=" + age +
				", name='" + name + '\'' +
				", avgMarks=" + avgMarks +
				'}';
	}
}
