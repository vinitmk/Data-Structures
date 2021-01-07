package com.mkv.algorithms.divideandconquer;

public class LongestCommonSubsequence {

	private int findCommonSubsequence(String s1, String s2, int index1, int index2) {
		if(index1 == s1.length() || index2 == s2.length())
			return 0;
		int c1 = 0;
		if(s1.charAt(index1) == s2.charAt(index2))
			c1 = 1 + findCommonSubsequence(s1, s2, index1+1, index2+1);
		int c2 = findCommonSubsequence(s1, s2, index1+1, index2);
		int c3 = findCommonSubsequence(s1, s2, index1, index2+1);
		return Math.max(c1, Math.max(c2, c3));
	}

	public static void main(String[] args) {
		LongestCommonSubsequence main = new LongestCommonSubsequence();
		int c = main.findCommonSubsequence("houdini", "hdupti",0,0);
		System.out.println("Longest Common Subsequence is "+ c);
	}
}
