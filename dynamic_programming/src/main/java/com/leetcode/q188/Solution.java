package com.leetcode.q188;

import java.util.Arrays;

class Solution {
    public int maxProfit(int k, int[] prices) {
        var n = prices.length;
        k = Math.min(k, n / 2);
        int[] cost = new int[k + 1], profit = new int[k + 1];
        Arrays.fill(cost, prices[0]);

        for (var p : prices) {
            for (var i = 1; i <= k; i++) {
                cost[i] = Math.min(cost[i], p - profit[i - 1]);
                profit[i] = Math.max(profit[i], p - cost[i]);

            }
        }
        return profit[k];
    }
}
