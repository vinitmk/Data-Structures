package com.mkv.algorithms.divideandconquer;

public class ZeroOneKnapsack {


	private int findGreatestProfit(int[] profit, int[] weights, int capacity, int currentIndex) {

		if(capacity == 0 || currentIndex < 0 || currentIndex >= profit.length)
			return 0;
		int profitCurrent = 0, profitNext;
		if(weights[currentIndex] <= capacity) {
			profitCurrent = profit[currentIndex] +
					findGreatestProfit(profit, weights, capacity - weights[currentIndex],
							currentIndex + 1);
		}
		profitNext = findGreatestProfit(profit, weights, capacity, currentIndex + 1);
		return Math.max(profitCurrent, profitNext);
	}

	public static void main(String[] args) {

		ZeroOneKnapsack main = new ZeroOneKnapsack();

		int[] profits = { 31, 26, 72, 17 };
		int[] weights = { 3, 1, 5, 2 };

		int maxProfit = main.findGreatestProfit(profits, weights, 7, 0);
		System.out.println("Max Profit "+ maxProfit);
	}
}
