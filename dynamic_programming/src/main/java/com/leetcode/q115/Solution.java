package com.leetcode.q115;

class Solution {
    public int numDistinct(String str, String target) {
        char[] s = str.toCharArray(), t = target.toCharArray();
        int n = s.length, m = t.length;
        var dp = new int[m + 1];
        dp[0] = 1;

        for (var i = 1; i <= n; i++) {
            for (var j = m; j >= 1; j--) {
                if (s[i - 1] == t[j - 1]) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[m];
    }
}
