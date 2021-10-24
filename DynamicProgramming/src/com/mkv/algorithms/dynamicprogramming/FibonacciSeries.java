package com.mkv.algorithms.dynamicprogramming;

public class FibonacciSeries {

    private int fibonnaciRecursive(int n) {
        if(n < 2)
            return n;
        return fibonnaciRecursive(n-1) + fibonnaciRecursive(n - 2);
    }

    private int fibonnaciRecursiveWithMemoization(int[] dp, int n) {
        if(n < 2)
            return n;
        if(dp[n] != 0)
            return dp[n];
        dp[n] =  fibonnaciRecursive(n-1) + fibonnaciRecursive(n - 2);
        return dp[n];
    }

    private int fibonacciWithTabulation(int[] dp, int n) {

        if(n < 2)
            return n;
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 50;
        FibonacciSeries main = new FibonacciSeries();
        long startTime = System.currentTimeMillis();
        int result = main.fibonnaciRecursive(10);
        long processingTime = System.currentTimeMillis() - startTime;
        System.out.println(" result: " + result + " time: "+ processingTime);

        int[] dp = new int[n+1];
        startTime = System.currentTimeMillis();
        result = main.fibonnaciRecursiveWithMemoization(dp, n);
        System.out.println(" result: " + result + " time: "+ (System.currentTimeMillis() - startTime));

        dp = new int[n+1];
        startTime = System.currentTimeMillis();
        result = main.fibonacciWithTabulation(dp, n);
        System.out.println(" result: " + result + " time: "+ (System.currentTimeMillis() - startTime));
    }
}
