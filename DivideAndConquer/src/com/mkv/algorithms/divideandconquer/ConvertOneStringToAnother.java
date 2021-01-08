package com.mkv.algorithms.divideandconquer;

public class ConvertOneStringToAnother {

	private int minimumEditOperations(String s1, String s2) {
		return findEditOperations(s1, s2, 0, 0);
	}

	private int findEditOperations(String s1, String s2, int index1, int index2) {

		if(index1 == s1.length()) // if we have reached the end of s1, then insert all the remaining characters of s2
			return s2.length() - index2;
		if(index2 == s2.length()) // if we have reached the end of s2, then delete all the remaining characters of s1
			return s1.length() - index1;

		if(s1.charAt(index1) == s2.charAt(index2)) // If the strings have a matching character, recursively match for the remaining lengths.
			return findEditOperations(s1, s2, index1 + 1, index2 + 1);
		int c1 = 1 + findEditOperations(s1, s2, index1 + 1, index2); // perform deletion
		int c2 = 1 + findEditOperations(s1, s2, index1, index2 + 1); // perform insertion
		int c3 = 1 + findEditOperations(s1, s2, index1 + 1, index2 + 1); // perform replacement
		return Math.min(c1, Math.min(c2, c3));
	}


	public static void main(String[] args) {
		ConvertOneStringToAnother main = new ConvertOneStringToAnother();
		System.out.println(main.minimumEditOperations("table", "tbres"));
	}
}
