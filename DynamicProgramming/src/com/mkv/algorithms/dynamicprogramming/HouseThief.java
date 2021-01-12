package com.mkv.algorithms.dynamicprogramming;

import java.util.Arrays;

public class HouseThief {

	private int topDownApproach(int[] houses) {
		int[] dpArray = new int[houses.length];
		return getMaxValueRecursive(houses, 0, dpArray);
	}

	private int getMaxValueRecursive(int[] houses, int currentIndex, int[] dpArray) {
		if(currentIndex >= houses.length)
			return 0;
		if(dpArray[currentIndex] == 0) {
			int currentHouseValue = houses[currentIndex] + getMaxValueRecursive(houses, currentIndex + 2, dpArray);
			int nextHouseValue = getMaxValueRecursive(houses, currentIndex + 1, dpArray);
			dpArray[currentIndex] = Math.max(currentHouseValue, nextHouseValue);
		}
		return dpArray[currentIndex];
	}

	private int bottomUpApproach(int[] houses) {
		int[] dpArray = new int[houses.length + 1];
		dpArray[houses.length] = 0;
		dpArray[houses.length - 1] = houses[houses.length - 1];
		for(int i = houses.length - 2; i >= 0; i--) {
			dpArray[i] = Math.max(dpArray[i+1], (dpArray[i+2] + houses[i]));
			//System.out.println(Arrays.toString(dpArray));
		}
		//System.out.println(Arrays.toString(dpArray));
		return dpArray[0];
	}

	public static void main(String[] args) {
		HouseThief main = new HouseThief();
		int[] houses = {6, 7, 1, 30, 8, 2, 4};
		System.out.println("Max Value recursive " + main.topDownApproach(houses));
		System.out.println("Max Value iterative " + main.bottomUpApproach(houses));

		houses = new int[] {20, 5, 1, 13, 6, 11, 40};
		System.out.println("Max Value recursive " + main.topDownApproach(houses));
		System.out.println("Max Value iterative " + main.bottomUpApproach(houses));

		houses = new int[] {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
		System.out.println("Max Value recursive " + main.topDownApproach(houses));
		System.out.println("Max Value iterative " + main.bottomUpApproach(houses));
	}
}
