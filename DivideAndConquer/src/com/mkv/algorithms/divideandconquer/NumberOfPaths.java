package com.mkv.algorithms.divideandconquer;

public class NumberOfPaths {

	private int numberOfPaths(int[][] array, int cost) {
		return paths(array, array.length-1, array[0].length-1, cost);
	}

	private int paths(int[][] array, int row, int column, int cost) {
		if(cost < 0)
			return 0;
		if(row == 0 && column == 0)
			return array[row][column] == cost ? 1 : 0;

		if(row == 0)
			return paths(array, 0, column-1, cost-array[row][column]);
		if(column == 0)
			return paths(array, row-1, 0, cost-array[row][column]);

		int pathFromPreviousRow = paths(array, row-1, column, cost-array[row][column]);
		int pathFromPreviousColumn = paths(array, row, column-1, cost-array[row][column]);
		return pathFromPreviousColumn+ pathFromPreviousRow;
	}

	public static void main(String[] args) {
		int[][] array = {
				{ 4, 7, 1, 6 },
				{ 5, 7, 3, 9 },
				{ 3, 2, 1, 2 },
				{ 7, 1, 6, 3 } };
		int cost = 25;
		NumberOfPaths main = new NumberOfPaths();
		int paths = main.numberOfPaths(array, cost);
		System.out.println("Paths = "+ paths);
	}
}
