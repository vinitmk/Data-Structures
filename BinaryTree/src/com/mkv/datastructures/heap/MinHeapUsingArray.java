package com.mkv.datastructures.heap;

class MinHeapUsingArray<T extends Comparable<T>> {

	private T[] array;
	private int sizeOfHeap;

	MinHeapUsingArray(T[] array) {
		this.sizeOfHeap = 0;
		this.array = array;
	}

	private int sizeOfArray() {
		return array.length;
	}

	private int sizeOfTree() {
		System.out.println("Size Of Tree: " + sizeOfHeap);
		return sizeOfHeap;
	}

	private boolean isHeapEmpty() {
		if (sizeOfHeap <= 0) {
			System.out.println("Tree is empty !");
			return true;
		} else {
			System.out.println("Tree is not empty !");
			return false;
		}
	}

	private void deleteheap() {
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
		// We are at root of the tree. Hence no more Heapifying is required.
		if (index <= 1) {
			return;
		}
		if(array[index].compareTo(array[parent]) < 0) {
			T tmp = array[index];
			array[index] = array[parent];
			array[parent] = tmp;
		}
		heapifyBottomToTop(parent);
	}

	T extractHeadOfHeap() {
		if(sizeOfHeap == 0) {
			System.out.println("Heap is empty");
			return null;
		}
		System.out.println("Head of Heap is "+ array[1]);
		System.out.println("Extracting it now...");
		T extractedValue = array[1];
		array[1] = array[sizeOfHeap];
		sizeOfHeap--;
		heapifyTopToBottom(1);
		System.out.println("Successfully extracted value from Heap.");
		return extractedValue;
	}

	private void heapifyTopToBottom(int index) {
		int left = index * 2;
		int right = (index * 2) + 1;
		int smallestChildIndex;

		if(sizeOfHeap < left) //If there is no child of this node, then nothing to do. Just return.
			return;
		else if(sizeOfHeap == left){ //If there is only left child of this node, then do a comparison and return.
			if(array[index].compareTo(array[left]) > 0) {
				T tmp = array[index];
				array[index] = array[left];
				array[left] = tmp;
			}
			return;
		}
		else {	//If both children are present
			if(array[left].compareTo(array[right]) < 0)
				smallestChildIndex = left;	// left child is smaller
			else
				smallestChildIndex = right;	// right child is smaller

			if(array[index].compareTo(array[smallestChildIndex]) > 0) { //If Parent is greater than smallest child, then swap
				T tmp = array[index];
				array[index] = array[smallestChildIndex];
				array[smallestChildIndex] = tmp;
			}
		}
		heapifyTopToBottom(smallestChildIndex);
	}

	void printHeap() {
		System.out.println("Printing all the elements of this Heap...");
		for (int i = 1; i <= sizeOfHeap; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("\n");
	}
}
