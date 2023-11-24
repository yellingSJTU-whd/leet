package com.leetcode.q121;

class Solution {
    public int maxProfit(int[] prices) {
        int lowest = prices[0], res = 0, n = prices.length;
        for (var i = 1; i < n; i++) {
            var curr = prices[i];
            if (curr < lowest) {
                lowest = curr;
            } else {
                res = Math.max(res, curr - lowest);
            }
        }
        return res;
    }
}
