package com.mkv.datastructures.linkedlist.singly;

public class PalindromeLinkedList<T> {
	private LinkedListMain<T> list;
	private LinkedListNode<T> left;

	private PalindromeLinkedList() {
			list = new LinkedListMain<>();
	}
	private void insertInLinkedList(T data) {
		list.createDataStructure(data);
	}


	private boolean isPalindromeRecursive() {
		return checkPalindrome(list.getHead());
	}

	private boolean checkPalindrome(LinkedListNode<T> right) {
		left = list.getHead();

		if(right == null)
			return true;

		boolean isPalindrome = checkPalindrome(right.next);
		if(!isPalindrome)
			return false;

		boolean isPalindrome1 = false;
		if(right.data == left.data)
			isPalindrome1 = true;

		left = left.next;
		return isPalindrome1;

	}

	public static void main(String[] args) {
		PalindromeLinkedList<Character> main = new PalindromeLinkedList<>();
		main.insertInLinkedList('A');
		main.insertInLinkedList('B');
		main.insertInLinkedList('C');
		main.insertInLinkedList('R');
		main.insertInLinkedList('A');
		main.insertInLinkedList('D');
		main.insertInLinkedList('A');
		main.insertInLinkedList('R');
		main.insertInLinkedList('C');
		main.insertInLinkedList('B');
		main.insertInLinkedList('A');

		System.out.println(" is Palindrome "+ main.isPalindromeRecursive());
	}
}
