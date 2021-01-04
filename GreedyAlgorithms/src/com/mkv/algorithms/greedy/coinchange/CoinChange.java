package com.mkv.algorithms.greedy.coinchange;

import java.util.Arrays;

public class CoinChange {

	private void findChange(int[] coins, int amount) {

		Arrays.sort(coins);
		int index = coins.length-1;
		do {
			int coinValue = coins[index];
			index--;
			int maxAmt = (amount / coinValue) * coinValue;
			if (maxAmt > 0) {
				System.out.println("coinValue " + coinValue + " no." + maxAmt / coinValue);
				amount -= maxAmt;
			}

		}
		while (amount != 0);
	}


	public static void main(String[] args) {

		CoinChange main = new CoinChange();
		int [] coins = {1, 2, 5, 10, 50, 100, 500,2000};
		int amount = 2758;
		System.out.println("Coins available: "+Arrays.toString(coins));
		System.out.println("Target amount: "+ amount);
		main.findChange(coins, amount);
	}
}
