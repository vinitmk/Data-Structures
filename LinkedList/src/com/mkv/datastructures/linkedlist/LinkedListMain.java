package com.mkv.datastructures.linkedlist;

import java.util.Random;

public class LinkedListMain<T> {

	private LinkedListNode<T> head;

	public LinkedListNode<T> getHead(){
		return head;
	}

	public void setHead(LinkedListNode<T> head){
		this.head = head;
	}

	private void print() {
		if(null == head)
			return;
		LinkedListNode node = head;
		while(null != node){
			System.out.println(node.data);
			node = node.next;
		}
	}

	private void createDataStructure(T data) {
		if(null == head)
			head = new LinkedListNode<>(data);
		else{
			LinkedListNode node = head;
			while(node.next != null)
				node = node.next;
			node.next = new LinkedListNode<>(data);
		}
	}

	public static void main(String[] args) {
		int data;
		Random num = new Random();
		LinkedListMain<Integer> llMain = new LinkedListMain<>();
		for(int i = 0; i < 10; i++){
			llMain.createDataStructure(num.nextInt(99));
		}

/*
	Scanner scanner = new Scanner(System.in);
		System.out.println("Input data for Linked List ");
		while(scanner.hasNext()){
			data = scanner.nextInt();
			llMain.createDataStructure(data);
		}
*/
		llMain.print();
	}
}
