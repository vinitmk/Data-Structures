package com.mkv.datastructures.linkedlist.singly;

import java.util.Random;

public class LinkedListOperations<T> {

	private LinkedListMain<T> llMain;

	private LinkedListOperations() {
		llMain = new LinkedListMain<>();
	}

	private void insertAtBeginningOfList(T num) {
		System.out.println("Inserting "+ num+" at the beginning");
		LinkedListNode<T> node = new LinkedListNode<>(num);
		node.next = llMain.getHead();
		llMain.setHead(node);
	}

	private void insertAtEndOfList(T num) {
		System.out.println("Inserting "+ num+" at the end");
		llMain.createDataStructure(num);
	}

	private void insertNthPosition(T num, int n) {
		LinkedListNode<T> t = llMain.getHead();
		LinkedListNode<T> node;
		System.out.println("Inserting "+ num +" at position "+n);
		if(n == 0 ) {
			node = new LinkedListNode<>(num);
			node.next = llMain.getHead();
			llMain.setHead(node);
		}

		while(--n > 1) {
			t = t.next;
		}
		node = new LinkedListNode<>(num);
		node.next = t.next;
		t.next = node;
	}

	private void deleteNthPosition(int position) {
		System.out.println("Deleting from position "+position);
		LinkedListNode<T> t;
		if( position == 1) {
			t = llMain.getHead().getNext();
			llMain.setHead(t);
		}
		else {
			t = llMain.getHead();
			while(--position > 1) {
				t = t.next;
			}
			t.next = t.next.next;
		}
	}

	private int linkedListLength() {
		int count = 0;
		LinkedListNode<T> t = llMain.getHead();
		while(t != null) {
			count++;
			t = t.next;
		}
		return count;
	}

	private int linkedListLengthRecursive() {
		int length;
		length = calcLength(llMain.getHead());
		return length;
	}

	private int calcLength(LinkedListNode<T> head) {
		if(head == null)
			return 0;
		return 1 + calcLength(head.next);
	}

	private void printMiddleOfLinkedList() {
		LinkedListNode<T> fast = llMain.getHead();
		LinkedListNode<T> slow = llMain.getHead();

		while(null != fast && null != fast.next) {
			fast = fast.next.next;
			slow = slow.next;

		}
		System.out.println("Middle of LinkedList is "+slow.data);
	}

	private boolean detectLoopInLinkedList() {
		// createLoopInLinkedList();
		LinkedListNode<T> fast = llMain.getHead();
		LinkedListNode<T> slow = llMain.getHead();

		while (fast != null && slow != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow)
				return true;
		}
		return false;
	}

	private void createLoopInLinkedList() {
		LinkedListNode<T> t = llMain.getHead();
		while(t.next != null)
			t = t.next;
		t.next = llMain.getHead();
	}

	private int countLoopLength() {
		int count = 0;
		// createLoopInLinkedList();
		if(detectLoopInLinkedList()) {
			LinkedListNode<T> fast = llMain.getHead();
			LinkedListNode<T> slow = llMain.getHead();
			while (fast != null && slow != null && fast.next != null) {
				fast = fast.next.next;
				slow = slow.next;
				if(fast == slow)
					break;
			}
			if(slow != null)
				slow = slow.next;
			count++;
			while(slow != null && fast != slow) {
				slow = slow.next;
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		LinkedListOperations<Integer> main = new LinkedListOperations<>();

		Random num = new Random();
		for(int i = 0; i < 10; i++){
			main.createDataStructure(num.nextInt(1000));
		}
		main.print();
		main.insertAtBeginningOfList(num.nextInt(1000));
		main.print();
		main.insertAtEndOfList(num.nextInt(1000));
		main.print();
		main.insertNthPosition(num.nextInt(1000), num.nextInt(10));
		main.print();
		main.deleteNthPosition(num.nextInt(10));
		main.print();
		System.out.println("Length of LinkedList "+main.linkedListLength());
		System.out.println("Length of LinkedList "+main.linkedListLengthRecursive());
		main.printMiddleOfLinkedList();
		System.out.println("Loop exists "+ main.detectLoopInLinkedList());
		System.out.println("Loop exists "+ main.detectLoopInLinkedList() +" with size "+ main.countLoopLength());
	}

	private void print() {
		llMain.print();
	}

	private void createDataStructure(T nextInt) {
		llMain.createDataStructure(nextInt);
	}
}
