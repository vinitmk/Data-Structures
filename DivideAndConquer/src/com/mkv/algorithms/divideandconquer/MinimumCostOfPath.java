package com.mkv.algorithms.divideandconquer;

public class MinimumCostOfPath {

	private int findCost(int[][] array) {
		return findCostPath(array, array.length-1, array[0].length-1);
	}

	private int findCostPath(int[][] array, int row, int column) {
		if (row == -1 || column == -1)   //BASE CASE
			return Integer.MAX_VALUE;
		if(row == 0 && column == 0)
			return array[0][0];
		int minCost1 = findCostPath(array, row-1, column);
		int minCost2 = findCostPath(array, row, column-1);
		int minCost = Math.min(minCost1, minCost2);
		int currentCost = array[row][column];
		return currentCost + minCost;
	}

	public static void main(String[] args) {

		int[][] array =
				{
						{ 4, 7, 8, 6, 4 },
						{ 6, 7, 3, 9, 2 },
						{ 3, 8, 1, 2, 4 },
						{ 7, 1, 7, 3, 7 },
						{ 2, 9, 8, 9, 3 }
				};
		MinimumCostOfPath main = new MinimumCostOfPath();
		System.out.println("Minimum cost = "+ main.findCost(array));
	}
}
