package com.mkv.datastructures.linkedlist;

import java.util.Scanner;

public class LinkedListMain<T> {

	private LinkedListNode<T> head;

	private void print() {
		if(null == head)
			return;
		LinkedListNode<T> node = head;
		while(null != node){
			System.out.println(node.data);
			node = node.next;
		}
	}


	private void createDataStructure(T data) {
		if(null == head)
			head = new LinkedListNode<>(data);
		else{
			LinkedListNode<T> node = head;
			while(node.next != null)
				node = node.next;
			node.next = new LinkedListNode<>(data);
		}
	}

	public static void main(String[] args) {
		int data;
		LinkedListMain<Integer> llMain = new LinkedListMain<>();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Input data for Linked List ");
		while(scanner.hasNext()){
			data = scanner.nextInt();
			llMain.createDataStructure(data);
		}

		llMain.print();
	}
}
