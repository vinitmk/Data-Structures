package com.mkv.datastructures.stack;

import java.util.Stack;

public class InfixToPostfixExpression {

	private String convertInfixToPostfix(String inFix) {
		Stack<Character> stack = new Stack<>();
		StringBuilder postFix = new StringBuilder();

		for(char c: inFix.toCharArray()) {
			if(Character.isLetterOrDigit(c))
				postFix.append(c);
			else if(c == '(')
				stack.push('(');
			else if(c == ')') {
				while(!stack.isEmpty()) {
					if(stack.peek() == '(') {
						stack.pop();
						break;
					}
					postFix.append(stack.pop());
				}
			}
			else {
				while(!stack.isEmpty() && getPrecendence(stack.peek()) >= getPrecendence(c)) {
					if (stack.peek() == '(')
						break;
					postFix.append(stack.pop());
				}
				stack.push(c);
			}
		}
		while (!stack.isEmpty()) {
			if(stack.peek() == '(')
				break;
			postFix.append(stack.pop());
		}
		return postFix.toString();
	}

	private int getPrecendence(char operator) {
		switch(operator) {
			case '+':
			case '-':
				return 1;
			case '*':
			case '/':
				return 2;
			case '^':
				return 3;
			default:
				return -1;
		}
	}

	public static void main(String[] args) {

		InfixToPostfixExpression main = new InfixToPostfixExpression();
		String exp;

		exp = "A+B*C+D";
		System.out.println(main.convertInfixToPostfix(exp));

		exp = "(A+B)*(C+D)";
		System.out.println(main.convertInfixToPostfix(exp));

		exp = "A*B+C*D";
		System.out.println(main.convertInfixToPostfix(exp));

		exp = "A+B+C+D";
		System.out.println(main.convertInfixToPostfix(exp));

		exp = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println(main.convertInfixToPostfix(exp));
	}
}
