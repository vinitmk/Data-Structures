package com.mkv.datastructures.linkedlist.singly;

public class LinkedListNode<T> {

	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data){
		this.data = data;
	}

	public T getData(){
		return data;
	}

	public LinkedListNode<T> getNext(){
		return next;
	}

	public void setNext(LinkedListNode<T> next){
		this.next = next;
	}
}
