package com.leetcode.q62;

import java.util.Arrays;

class Solution {
    public int uniquePaths(int m, int n) {
        var dp = new int[n];
        Arrays.fill(dp, 1);
        for (var i = m - 2; i >= 0; i--) {
            for (var j = n - 2; j >= 0; j--) {
                dp[j] += dp[j + 1];
            }
        }
        return dp[0];
    }
}
