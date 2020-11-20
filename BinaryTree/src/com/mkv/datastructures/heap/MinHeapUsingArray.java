package com.mkv.datastructures.heap;

public class MinHeapUsingArray<T extends Comparable<T>> {

	private T[] array;
	private int sizeOfHeap;

	MinHeapUsingArray(T[] array) {
		this.sizeOfHeap = 0;
		this.array = array;
	}

	public int sizeOfArray() {
		return array.length;
	}

	public int sizeOfTree() {
		System.out.println("Size Of Tree: " + sizeOfHeap);
		return sizeOfHeap;
	}

	public boolean isHeapEmpty() {
		if (sizeOfHeap <= 0) {
			System.out.println("Tree is empty !");
			return true;
		} else {
			System.out.println("Tree is not empty !");
			return false;
		}
	}

	public void deleteheap() {
		this.array = null;
		System.out.println("Heap has been deleted !");
	}

	void insertInHeap(T value) {
		if (array != null) {
			System.out.println("Inserting " + value + " in Heap...");
			array[++sizeOfHeap] = value;
			heapifyBottomToTop(sizeOfHeap);
			System.out.println("Inserted " + value + " successfully in Heap !");
		}
	}

	private void heapifyBottomToTop(int index) {
		int parent = index/2;
		if(index > 1) {
			if(array[index].compareTo(array[parent]) < 0) {
				T tmp = array[index];
				array[index] = array[parent];
				array[parent] = tmp;
			}
		}
		heapifyTopToBottom(parent);
	}

	private void heapifyTopToBottom(int index) {
		int left = index * 2;
		int right = (index * 2) + 1;

	}

	void extractHeadOfHeap() {}

	void printHeap() {
		System.out.println("Printing all the elements of this Heap...");
		for (int i = 1; i <= sizeOfHeap; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("\n");
	}
}
