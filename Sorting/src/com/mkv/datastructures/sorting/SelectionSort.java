package com.mkv.datastructures.sorting;

import java.util.Arrays;

public class SelectionSort {

	private void sort(int[] array) {
		int temp, minIndex;
		for(int i = 0; i < array.length; i++) {
			minIndex = i;
			for(int j = i+1; j < array.length; j++) {
				if(array[j] < array[minIndex])
					minIndex = j;
			}
			if(minIndex != i) {
				temp = array[minIndex];
				array[minIndex] = array[i];
				array[i] = temp;
			}
		}
	}

	public static void main(String[] args) {
		SelectionSort main = new SelectionSort();

		int[] array = new int[]{100, 67, 89, 10, 54, 23, 11};
		main.sort(array);
		System.out.println(Arrays.toString(array));
	}
}
