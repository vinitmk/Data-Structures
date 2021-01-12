package com.mkv.algorithms.dynamicprogramming;

public class NumberFactor {

	private int topDownApproach(int n) {
		int[] dpArray = new int[n + 1];
		return getNWaysRecursive(n, dpArray);
	}

	private int getNWaysRecursive(int n, int[] dpArray) {
		if(n == 0 || n == 1 || n == 2)
			return 1;
		if(n == 3)
			return 2;
		if(dpArray[n] == 0) {
			int sumOfN1 = getNWaysRecursive(n - 1, dpArray);
			int sumOfN3 = getNWaysRecursive(n - 3, dpArray);
			int sumOfN4 = getNWaysRecursive(n - 4, dpArray);
			dpArray[n] = sumOfN1 + sumOfN3 + sumOfN4;
		}
		return dpArray[n];
	}

	private int bottomUpApproach(int n) {
		int[] dpArray = new int[n + 1];
		dpArray[0] = dpArray[1] = dpArray[2] = 1;
		dpArray[3] = 2;
		for(int i = 4; i <= n; i++)
			dpArray[i] = dpArray[i - 1] + dpArray[i - 3] + dpArray[i - 4];
		return dpArray[n];
	}


	public static void main(String[] args) {

		NumberFactor main = new NumberFactor();

		System.out.println("Number of ways for 7 is "+ main.topDownApproach(7));
		System.out.println("Number of ways for 7 is "+ main.bottomUpApproach(7));
	}
}
