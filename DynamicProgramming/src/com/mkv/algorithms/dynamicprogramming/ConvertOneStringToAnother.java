package com.mkv.algorithms.dynamicprogramming;


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

	public static void main(String[] args) {
		ConvertOneStringToAnother main = new ConvertOneStringToAnother();
		System.out.println(main.topDownApproach("table", "tbres"));
	}
}
