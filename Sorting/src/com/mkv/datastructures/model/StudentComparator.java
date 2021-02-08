package com.mkv.datastructures.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentComparator {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();

		list.add(new Student(19, "Steve", 86));
		list.add(new Student(19, "Joe Rogan", 67));
		list.add(new Student(18, "Steve", 96));
		list.add(new Student(17, "Bob Woodward", 75));
		list.add(new Student(20, "Kyle Adams", 90));

//		Collections.sort(list, new Comparator<Student>(){
//			@Override
//			public int compare(Student s1, Student s2) {
//				if(s1.name.equalsIgnoreCase(s2.name))
//					return s1.age - s2.age;
//				return s1.name.compareTo(s2.name);
//			}
//		});

//		Collections.sort(list, (s1, s2) -> s1.name.compareTo(s2.name));

		list.sort(Comparator.comparing(Student::getName).thenComparing(Student::getAvgMarks).reversed());
		list.forEach(System.out::println);
	}
}
