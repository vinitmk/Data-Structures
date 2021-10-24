package com.mkv.datastructures.sorting;

import java.util.Arrays;

public class MergeSort {

	private static int count;

	public static void main(String[] args) {

		int[] array = {10, 6, 7, 9, 5, 3, 8};
		new MergeSort().mergeSort(array);
		System.out.println(Arrays.toString(array));
	}

	private void mergeSort(int[] array) {
		int length = array.length;

		if(length < 2)
			return;

		int mid = length / 2;
		int[] leftSubArray = new int[mid];
		int[] rightSubArray = new int[length - mid];

		int l = 0, r = 0;
		for(int i = 0; i < length; i++) {
			if(i < mid)
				leftSubArray[l++] = array[i];
			else
				rightSubArray[r++] = array[i];
		}
//		System.out.println(count++ +"  "+Arrays.toString(leftSubArray));
//		System.out.println(count++ +"  "+Arrays.toString(rightSubArray));

		mergeSort(leftSubArray);
		mergeSort(rightSubArray);
		merge(array, leftSubArray, rightSubArray, mid, length - mid);
//		System.out.println(count++ +" merged  "+Arrays.toString(array));
	}

	private void merge(int[] array, int[] leftSubArray, int[] rightSubArray, int leftEnd, int rightEnd) {

		int l = 0, r = 0, i = 0;

		while(l < leftEnd && r < rightEnd) {
			if(leftSubArray[l] < rightSubArray[r])
				array[i++] = leftSubArray[l++];
			else
				array[i++] = rightSubArray[r++];
		}

		while(l < leftEnd)
			array[i++] = leftSubArray[l++];

		while (r < rightEnd)
			array[i++] = rightSubArray[r++];
	}
}
