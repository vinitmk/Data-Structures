package com.mkv.datastructures.linkedlist.singly;

public class SwapLinkedListNodes<T> {

	private void swapNodes(LinkedListMain<T> list, T x, T y) {
		LinkedListNode<T> temp1 = null, temp2 = null;
		LinkedListNode<T> node = list.getHead();

		while(node != null && node.next != null) {
			if(node.next.data == x) {
				temp1 = node;
			}
			if(node.next.data == y) {
				temp2 = node;
			}
			node = node.next;
		}
		if(temp1 != null && temp2 != null) {
			node = temp1.next;
			temp1.next = temp2.next;
			temp2.next = node;

			node = temp1.next.next;
			temp1.next.next = temp2.next.next;
			temp2.next.next = node;
		}
	}


	public static void main(String[] args) {
		SwapLinkedListNodes<Integer> main = new SwapLinkedListNodes<>();
		LinkedListMain<Integer> list = new LinkedListMain<>();

		list.createDataStructure(55);
		list.createDataStructure(65);
		list.createDataStructure(75);
		list.createDataStructure(85);
		list.createDataStructure(95);
		list.createDataStructure(105);
		list.createDataStructure(115);
		list.print();
		main.swapNodes(list, 55, 115);
		list.print();

	}
}
