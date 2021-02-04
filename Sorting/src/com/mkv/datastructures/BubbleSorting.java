package com.mkv.datastructures;

import java.util.Arrays;

public class BubbleSorting {


	private void sort(int[] array) {
		int temp;
		boolean flag = true;

		while(flag) {
			flag = false;
			for(int i = 0; i < array.length - 1; i++) {
        		if (array[i] > array[i + 1]) {
          			flag = true;
          			temp = array[i];
          			array[i] = array[i + 1];
          			array[i + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		BubbleSorting main = new BubbleSorting();

		int[] array = new int[]{100, 67, 89, 10, 54, 23, 11};
		main.sort(array);
		System.out.println(Arrays.toString(array));
	}
}
