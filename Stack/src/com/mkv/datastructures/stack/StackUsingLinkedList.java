package com.mkv.datastructures.stack;

import com.mkv.datastructures.linkedlist.LinkedListNode;


public class StackUsingLinkedList<T> {
	private LinkedListNode<T> top;

	private void push(T d){
		if(null == top)
			top = new LinkedListNode<>(d);
		else {
			LinkedListNode<T> node = new LinkedListNode<>(d);
			node.setNext(top);
			top = node;
		}
	}

	private T pop(){
		if(null == top)
			return null;
		T data = top.getData();
		top = top.getNext();
		return data;
	}

	private T peek(){
		if(null != top)
			return top.getData();
		return null;
	}

	public static void main(String[] args){
		StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<>();

		stack.push(6);
		stack.push(3);
		stack.push(9);
		System.out.println("Popped "+ stack.pop());
		System.out.println("Peek "+ stack.peek());
		stack.push(18);
		System.out.println("Peek "+ stack.peek());
		System.out.println("Popped "+ stack.pop());
		System.out.println("Popped "+ stack.pop());
		System.out.println("Popped "+ stack.pop());
	}
}
