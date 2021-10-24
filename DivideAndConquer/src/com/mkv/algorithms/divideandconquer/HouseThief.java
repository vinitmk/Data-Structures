package com.mkv.algorithms.divideandconquer;

public class HouseThief {

	private int getMaximumValue(int[] houseValues, int currentIndex) {
		if(currentIndex >= houseValues.length)
			return 0;

		int currentHouseValue = houseValues[currentIndex] + getMaximumValue(houseValues, currentIndex + 2);
		int nexHouseValue = getMaximumValue(houseValues, currentIndex+1);
		int val = Math.max(currentHouseValue, nexHouseValue);
		System.out.print("  "+ val);
		return val;
	}

	public static void main(String[] args) {
		HouseThief main = new HouseThief();
		int[] houses = {6, 7, 1, 30, 8, 2, 4};
		int totalValue = main.getMaximumValue(houses,0);
		System.out.println("Total Value "+ totalValue);

		houses = new int[] {20, 5, 1, 13, 6, 11, 40};
		totalValue = main.getMaximumValue(houses,0);
		System.out.println("Total Value "+ totalValue);
	}
}
