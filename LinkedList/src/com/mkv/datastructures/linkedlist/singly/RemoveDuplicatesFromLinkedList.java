package com.mkv.datastructures.linkedlist.singly;

public class RemoveDuplicatesFromLinkedList<T> {
	private LinkedListMain<T> list;

	private RemoveDuplicatesFromLinkedList() {
		list = new LinkedListMain<>();
	}

	private void insertInLinkedList(T data) {
		list.createDataStructure(data);
	}

	private void removeDuplicates() {
		LinkedListNode<T> t = list.getHead();
		LinkedListNode<T> tmp = t.next;
		while(tmp != null) {
			if(t.data == tmp.data) {
				tmp = tmp.next;
			}
			else {
				t.next = tmp;
				t = t.next;
			}
		}

		t.next = null;
		list.print();
	}

	public static void main(String[] args) {
		RemoveDuplicatesFromLinkedList<Integer> main = new RemoveDuplicatesFromLinkedList<>();

		main.insertInLinkedList(11);
		main.insertInLinkedList(11);
		main.insertInLinkedList(11);
		main.insertInLinkedList(23);
		main.insertInLinkedList(23);
		main.insertInLinkedList(45);
		main.insertInLinkedList(45);
		main.insertInLinkedList(45);
		main.insertInLinkedList(60);

		main.removeDuplicates();
	}
}
