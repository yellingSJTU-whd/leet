package com.leetcode.q123;

import java.util.Arrays;

class Solution {
    public int maxProfit(int[] prices) {
        int cost1 = prices[0], profit1 = 0, cost2 = cost1, profit2 = profit1;

        for (var p : prices) {
            cost1 = Math.min(cost1, p);
            profit1 = Math.max(profit1, p - cost1);
            cost2 = Math.min(cost2, p - profit1);
            profit2 = Math.max(profit2, p - cost2);
        }
        return profit2;
    }
}
