package com.mkv.datastructures.linkedlist.singly;

public class LinkedListNode<T> {

	T data;
	LinkedListNode next;

	public LinkedListNode(T data){
		this.data = data;
	}

	public T getData(){
		return data;
	}

	public LinkedListNode getNext(){
		return next;
	}

	public void setNext(LinkedListNode next){
		this.next = next;
	}
}
