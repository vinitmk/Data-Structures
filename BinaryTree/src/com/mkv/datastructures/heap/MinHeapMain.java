package com.mkv.datastructures.heap;

public class MinHeapMain {

	public static void main(String[] args) {
		System.out.println("Creating a blank Heap");
		int size = 10;
		MinHeapUsingArray<Integer> heap = new MinHeapUsingArray<>(new Integer[size + 1]);

		heap.insertInHeap(100);
		heap.printHeap();
		heap.insertInHeap(90);
		heap.printHeap();
		heap.insertInHeap(80);
		heap.printHeap();
		heap.insertInHeap(70);
		heap.printHeap();
		heap.insertInHeap(60);
		heap.printHeap();
		heap.insertInHeap(50);
		heap.printHeap();
		heap.insertInHeap(40);
		heap.printHeap();
		heap.insertInHeap(30);
		heap.printHeap();
		heap.insertInHeap(20);
		heap.printHeap();

		heap.extractHeadOfHeap();
		heap.printHeap();

		heap.insertInHeap(110);
		heap.printHeap();
		heap.extractHeadOfHeap();
		heap.printHeap();
	}

}
