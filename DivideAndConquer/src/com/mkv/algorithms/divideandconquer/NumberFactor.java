package com.mkv.algorithms.divideandconquer;

// Given N, count the number of ways to express N as sum of 1, 3 and 4.

public class NumberFactor {

	private int getNWays(int n) {

		if(n == 0 || n == 1 || n == 2) // {}, {1}, {1,1}
			return 1;
		if(n == 3) // {1,1,1} and {3}
			return 2;
		int sumOfN1 = getNWays(n-1); //
		int sumOfN3 = getNWays(n-3);
		int sumOfN4 = getNWays(n-4);
		return sumOfN1 + sumOfN3 + sumOfN4;
	}

	public static void main(String[] args) {
		NumberFactor main = new NumberFactor();

		System.out.println(main.getNWays(4));
		System.out.println(main.getNWays(5));
		System.out.println(main.getNWays(6));
	}
}
