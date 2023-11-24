package com.leetcode.q122;

class Solution {
    public int maxProfit(int[] prices) {
        int pre = prices[0], benefit = 0, n = prices.length;
        for (var i = 1; i < n; i++) {
            var curr = prices[i];
            if (curr > pre) {
                benefit += curr - pre;
            }
            pre = curr;
        }
        return benefit;
    }
}
