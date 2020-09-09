package com.mkv.datastructures.stack;

import java.util.Stack;

public class QueueUsingStacks<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	private QueueUsingStacks() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}

	private void enqueue(T data) {
		stack1.push(data);
	}

	private T dequeue() {
		if(stack1.isEmpty() && stack2.isEmpty())
			return null;
		if(stack2.isEmpty())
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		return stack2.pop();
	}

	public static void main(String[] args) {
		QueueUsingStacks<Integer> queue = new QueueUsingStacks<>();

		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);

		System.out.println(queue.dequeue());
		queue.enqueue(6);
		System.out.println(queue.dequeue());
		queue.enqueue(7);
		System.out.println(queue.dequeue());
		queue.enqueue(8);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}

}
