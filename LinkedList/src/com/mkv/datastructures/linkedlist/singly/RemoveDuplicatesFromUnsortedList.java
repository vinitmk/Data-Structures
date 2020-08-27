package com.mkv.datastructures.linkedlist.singly;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromUnsortedList<T> {
	private LinkedListMain<T> list;

	private RemoveDuplicatesFromUnsortedList() {
		list = new LinkedListMain<>();
	}

	private void insertIntoLinkedList(T data) {
		list.createDataStructure(data);
	}

	private void removeDuplicates() {
		LinkedListNode<T> current = list.getHead();
		LinkedListNode<T> previous = null;
		Set<T> set = new HashSet<>();

		while(current != null) {
			if(set.contains(current.data)) {
				previous.next = current.next;
			}
			else {
				set.add(current.data);
				previous = current;
			}
			current = current.next;
		}
		list.print();
	}

	public static void main(String[] args) {
		RemoveDuplicatesFromUnsortedList<Integer> main = new RemoveDuplicatesFromUnsortedList<>();

		main.insertIntoLinkedList(12);
		main.insertIntoLinkedList(25);
		main.insertIntoLinkedList(55);
		main.insertIntoLinkedList(100);
		main.insertIntoLinkedList(55);
		main.insertIntoLinkedList(25);
		main.insertIntoLinkedList(12);
		main.insertIntoLinkedList(12);
		main.insertIntoLinkedList(100);

		main.removeDuplicates();
	}

}
