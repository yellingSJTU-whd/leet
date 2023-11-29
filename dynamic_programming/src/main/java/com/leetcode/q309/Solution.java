package com.leetcode.q309;

class Solution {
    public int maxProfit(int[] prices) {
        int cost = prices[0], cache = 0, profit = 0;

        for (var p : prices) {
            cost = Math.min(cost, p - cache);
            cache = profit;
            profit = Math.max(profit, p - cost);
        }
        return profit;
    }
}
