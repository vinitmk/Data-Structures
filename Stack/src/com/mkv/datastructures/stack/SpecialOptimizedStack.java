package com.mkv.datastructures.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

public class SpecialOptimizedStack<T> {

	private Stack<T> stack;
	private Set<T> set;

	private SpecialOptimizedStack() {
		stack = new Stack<>();
		set = new TreeSet<>();
	}

	private void push(T data) {
		stack.push(data);
		set.add(data);
	}

	private T pop() {
		T d = stack.pop();
		set.remove(d);
		return d;
	}

	private T getMin() {
		return set.iterator().next();
	}

	public static void main(String[] args) {
		SpecialOptimizedStack<Integer> stack = new SpecialOptimizedStack<>();

		stack.push(49);
		stack.push(80);
		stack.push(56);
		stack.push(18);
		stack.push(77);
		stack.push(10);

		System.out.println(stack.getMin());
		System.out.println(stack.pop());
		System.out.println(stack.getMin());
		System.out.println(stack.pop());

	}

}
