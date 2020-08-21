package com.mkv.datastructures.linkedlist;

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
	}

	private void print() {
		llMain.print();
	}

	private void createDataStructure(T nextInt) {
		llMain.createDataStructure(nextInt);
	}
}