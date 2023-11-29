package com.leetcode.q714;

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int cost = prices[0] + fee, profit = 0;

        for (var p : prices) {
            cost = Math.min(cost, p - profit + fee);
            profit = Math.max(profit, p - cost);
        }
        return profit;
    }
}
