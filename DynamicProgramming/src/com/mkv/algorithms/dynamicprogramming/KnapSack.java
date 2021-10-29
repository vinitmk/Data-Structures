package com.mkv.algorithms.dynamicprogramming;

import java.util.Arrays;

public class KnapSack {

    private int solveKnapsack(int[] profits, int[] weights, int capacity) {
        return solveKnapsackRecursive(profits, weights, capacity, profits.length - 1);
    }

    private int solveKnapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {

        if(profits.length == 0 || weights.length == 0 || capacity <= 0 || currentIndex < 0)
            return 0;

        int profit1 = 0;
        if(weights[currentIndex] <= capacity)
            profit1 = profits[currentIndex] + solveKnapsackRecursive(profits, weights, capacity - weights[currentIndex], currentIndex - 1);
            int profit2 =  solveKnapsackRecursive(profits, weights, capacity, currentIndex - 1);
            return Math.max(profit1, profit2);
    }

    private int solveKnapsackMemoization(int[] profits, int[] weights, int capacity, int currentIndex, int[][] dp) {
        if(profits.length == 0 || weights.length == 0 || capacity == 0 || currentIndex < 0)
            return 0;

        if(dp[currentIndex][capacity] != 0)
            return dp[currentIndex][capacity];

        int profit1 = 0;
        if(weights[currentIndex] <= capacity)
            profit1 = profits[currentIndex] + solveKnapsackMemoization(profits, weights, capacity - weights[currentIndex], currentIndex - 1, dp);

        int profit2 = solveKnapsackMemoization(profits, weights, capacity, currentIndex - 1, dp);
        dp[currentIndex][capacity] = Math.max(profit1, profit2);
        return dp[currentIndex][capacity];
    }

    private int solveKnapsackTabulation(int[] profits, int[] weights, int capacity) {
        int[][] dp = new int[profits.length + 1][capacity+1];

        // Initialization
        Arrays.fill(dp[0], 0);
        for(int row = 0; row < dp.length; row++)
            dp[row][0] = 0;

        for(int i = 1; i < profits.length+1; i++)
            for(int c = 1; c < capacity+1 ; c++) {
                int profit1 = 0, profit2;
                if(weights[i - 1] <= c)
                    profit1 = profits[i-1] + dp[i-1][c - weights[i-1]];
                profit2 = dp[i-1][c];
                dp[i][c] = Math.max(profit1, profit2);
            }

        for(int[] row: dp)
            System.out.println(Arrays.toString(row));

        return dp[profits.length][capacity];

    }

    public static void main(String[] args) {
        KnapSack ks = new KnapSack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsackRecursive(profits, weights, 7, profits.length - 1);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsackRecursive(profits, weights, 6, profits.length - 1);
        System.out.println("Total knapsack profit ---> " + maxProfit);

        // Memoization
        int[][] dp = new int[profits.length + 1][7+1];
        //Arrays.fill(dp, -1);
        maxProfit = ks.solveKnapsackMemoization(profits, weights, 7, profits.length - 1, dp);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        dp = new int[profits.length + 1][6+1];
        //Arrays.fill(dp, -1);
        maxProfit = ks.solveKnapsackMemoization(profits, weights, 6, profits.length - 1, dp);
        System.out.println("Total knapsack profit ---> " + maxProfit);

        // Tabulation
        maxProfit = ks.solveKnapsackTabulation(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsackTabulation(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
