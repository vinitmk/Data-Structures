package com.mkv.algorithms.divideandconquer;

public class LongestPalindromicSubstring {

	private int longestPalindrome(String s) {
		return findLengthOfPalindrome(s, 0, s.length()-1);
	}

	private int findLengthOfPalindrome(String s, int start, int end) {
		if(start > end)
			return 0;
		if(start == end)
			return 1;

		int c1 = 0;
		if(s.charAt(start) == s.charAt(end)) {
			int remainingLength = end - start - 1;
			if(remainingLength == findLengthOfPalindrome(s, start+1, end-1))
				c1 = 2 + remainingLength;
		}
		int c2 = findLengthOfPalindrome(s, start+1, end);
		int c3 = findLengthOfPalindrome(s, start, end-1);
		return Math.max(c1, Math.max(c2, c3));
	}

	public static void main(String[] args) {
		LongestPalindromicSubstring main = new LongestPalindromicSubstring();
		int c = main.longestPalindrome("MQADASM");
		System.out.println("Longest Palindrome substring "+ c);
	}
}
