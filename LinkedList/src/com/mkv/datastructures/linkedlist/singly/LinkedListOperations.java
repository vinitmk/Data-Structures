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
		LinkedListNode t = llMain.getHead();
		LinkedListNode node;
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
		LinkedListNode t;
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

	}

	private void print() {
		llMain.print();
	}

	private void createDataStructure(T nextInt) {
		llMain.createDataStructure(nextInt);
	}
}
