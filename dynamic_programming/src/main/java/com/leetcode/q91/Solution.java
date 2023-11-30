package com.leetcode.q91;

class Solution {
    public int numDecodings(String str) {
        var s = str.toCharArray();
        var n = s.length;
        var dp = new int[n + 1];
        dp[n] = 1;
        for (var i = n - 1; i >= 0; i--) {
            if (s[i] == '0') {
                dp[i] = 0;
                continue;
            }
            dp[i] = dp[i + 1];
            if (i <= n - 2) {
                var decimal = (s[i] - '0') * 10 + s[i + 1] - '0';
                if (decimal <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }
}
