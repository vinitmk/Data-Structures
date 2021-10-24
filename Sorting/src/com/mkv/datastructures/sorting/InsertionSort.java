package com.mkv.datastructures.sorting;

import java.util.Arrays;

class InsertionSort {

	public static void main(String[] args) {
		int[] array = {8, 7, 9, 4, 6, 5};
		new InsertionSort().insertionSort(array);
		System.out.println(Arrays.toString(array));
	}

	private void insertionSort(int[] array) {
		for(int  i = 1; i < array.length; i++) {
			int num = array[i];
			int j = i;

			while(j > 0 && array[j-1] > num) {
				array[j] = array[j-1];
				j--;
			}
			array[j] = num;
		}
	}
}
