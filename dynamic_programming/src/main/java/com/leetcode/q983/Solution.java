package com.leetcode.q983;

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        var n = days.length;
        var dp = new int[n];
        dp[n - 1] = Math.min(costs[0], Math.min(costs[1], costs[2]));
        for (var i = n - 2; i >= 0; i--) {
            var p0 = costs[0] + dp[i + 1];
            var p1 = costs[1] + calc(days, dp, i, 7);
            var p2 = costs[2] + calc(days, dp, i, 30);
            dp[i] = Math.min(p0, Math.min(p1, p2));
        }
        return dp[0];
    }

    private int calc(int[] days, int[] dp, int idx, int day) {
        var n = days.length;
        var ptr = idx;
        while (ptr < n && days[ptr] - days[idx] < day) {
            ptr++;
        }
        return ptr == n ? 0 : dp[ptr];
    }
}
