package com.mkv.algorithms.dynamicprogramming;

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

    public static void main(String[] args) {
        KnapSack ks = new KnapSack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
