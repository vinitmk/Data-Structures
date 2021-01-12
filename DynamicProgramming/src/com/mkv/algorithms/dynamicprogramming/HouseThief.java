package com.mkv.algorithms.dynamicprogramming;

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

	public static void main(String[] args) {
		HouseThief main = new HouseThief();
		int[] houses = {6, 7, 1, 30, 8, 2, 4};
		System.out.println("Max Value " + main.topDownApproach(houses));

		houses = new int[] {20, 5, 1, 13, 6, 11, 40};
		System.out.println("Max Value " + main.topDownApproach(houses));

	}
}
