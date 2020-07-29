package com.mkv.datastructures.linkedlist;

import java.util.Random;
import java.util.Scanner;

import com.mkv.datastructures.common.IOHandler;

public class LinkedListMain implements IOHandler<Integer> {

	private LinkedListNode head;

	@Override
	public void print() {
		if(null == head)
			return;
		LinkedListNode node = head;
		while(null != node){
			System.out.println(node.data);
			node = node.next;
		}
	}

	@Override
	public void createDataStructure(Integer data) {
		if(null == head)
			head = new LinkedListNode(data);
		else{
			LinkedListNode node = head;
			while(node.next != null)
				node = node.next;
			node.next = new LinkedListNode(data);
		}
	}

	public static void main(String[] args) {
		int data;
		Random num = new Random();
		LinkedListMain llMain = new LinkedListMain();
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
