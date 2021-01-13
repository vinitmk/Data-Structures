package com.mkv.algorithms.dynamicprogramming;


import java.util.Arrays;

public class ConvertOneStringToAnother {

	private int topDownApproach(String s1, String s2) {
		int[][] dpArray = new int[s1.length() + 1][s2.length() + 1];
		return getNumOfOperations(s1, s2, 0, 0, dpArray);
	}

	private int getNumOfOperations(String s1, String s2, int index1, int index2, int[][] dpArray) {
		if(dpArray[index1][index2] == 0) {
			if(index1 == s1.length())
				dpArray[index1][index2] = s2.length() - index2;
			else if(index2 == s2.length())
				dpArray[index1][index2] = s1.length() - index1;

			else if(s1.charAt(index1) == s2.charAt(index2))
				dpArray[index1][index2] = getNumOfOperations(s1, s2, index1+1, index2+1, dpArray);

			else{
				int deleteOp = getNumOfOperations(s1, s2, index1 + 1, index2, dpArray);
				int insertOp = getNumOfOperations(s1, s2, index1, index2 + 1, dpArray );
				int replaceOp = getNumOfOperations(s1, s2, index1 + 1, index2 + 1, dpArray);

				dpArray[index1][index2] = 1 + Math.min(deleteOp, Math.min(insertOp, replaceOp));
			}
		}
		return dpArray[index1][index2];
	}

	private int bottomUpApproach(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length()+1];

		for(int i = 0; i <= s1.length(); i++)
			dp[i][0] = i;

		for(int i = 0; i <= s2.length(); i++)
			dp[0][i] = i;

		printArray(dp);

		for(int i = 1; i <= s1.length(); i++) {
			for(int j = 1; j <= s2.length(); j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}
				else {
					dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
				}
			}
		}
		System.out.println("\n\n\n");
		printArray(dp);

		return dp[s1.length()][s2.length()];
	}

	private void printArray(int[][] dp) {

		for(int[] row: dp)
			System.out.println(Arrays.toString(row));

	}

	public static void main(String[] args) {
		ConvertOneStringToAnother main = new ConvertOneStringToAnother();
		//System.out.println(main.topDownApproach("table", "tbres"));
		main.bottomUpApproach("table", "tbres");
	}
}
