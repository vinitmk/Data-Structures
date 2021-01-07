package com.mkv.algorithms.divideandconquer;

public class LongestPalindromicSubsequence {

	private int findPalindromicSubsequenceLength(String s) {
		return palindromeLength(s, 0, s.length()-1);
	}

	private int palindromeLength(String s, int start, int end) {
		if(start > end)
			return 0;
		if(start == end) // It's a palindrome of 1 character
			return 1;
		int c1 = 0;
		if(s.charAt(start) == s.charAt(end))
			c1 = 2 + palindromeLength(s, start+1, end-1);
		int c2 = palindromeLength(s, start+1, end);
		int c3 = palindromeLength(s, start, end-1);
		return Math.max(c1, Math.max(c2, c3));
	}

	public static void main(String[] args) {
		LongestPalindromicSubsequence main = new LongestPalindromicSubsequence();
		int c = main.findPalindromicSubsequenceLength("elrmenmet");
		System.out.println("Longest Palindrome Subsequence "+ c);
	}
}
