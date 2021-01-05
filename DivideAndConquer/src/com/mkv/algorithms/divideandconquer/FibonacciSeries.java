package com.mkv.algorithms.divideandconquer;

public class FibonacciSeries {

	private int fibonacciSeries(int n) {
		if( n == 1)
			return 0;
		if( n == 2)
			return 1;
		return fibonacciSeries(n-1) + fibonacciSeries(n-2);

	}

	public static void main(String[] args) {
		FibonacciSeries main  = new FibonacciSeries();

		int n = main.fibonacciSeries(10);
		System.out.println("Fibonacci element "+ n);

	}
}
