package com.mkv.datastructures.stack;

import java.util.ArrayList;
import java.util.List;

public class StackUsingArray<T> {

	private List<T> stack;

	private void push(T data){
		if(null == stack) {
			stack = new ArrayList<>();
			stack.add(data);
		} else {
			stack.add(data);
		}
	}

	private T pop(){
		if(null == stack)
			return null;
		else
			return stack.remove(stack.size()-1);
	}

	private T peek(){
		if(null == stack)
			return null;
		else
			return stack.get(stack.size()-1);
	}


	public static void main(String[] args){
		int d;
		StackUsingArray<Integer> stack;
		stack = new StackUsingArray<>();

		stack.push(6);
		stack.push(3);
		stack.push(9);
		d = stack.pop();
		System.out.println("Popped "+ d);
		d = stack.peek();
		System.out.println("Peek "+ d);
		stack.push(18);
		d = stack.peek();
		System.out.println("Peek "+ d);
	}
}
