package com.leetcode.q516;

class Solution {
    public int longestPalindromeSubseq(String str) {
        var s = str.toCharArray();
        var n = s.length;
        var dp = new int[n];
        dp[n - 1] = 1;

        for (int i = n - 2, buttonLeft = 1, cache; i >= 0; i--) {
            for (var j = i; j < n; j++) {
                cache = dp[j];
                if (i == j)
                    dp[j] = 1;
                else if (i + 1 == j)
                    dp[j] = s[i] == s[j] ? 2 : 1;
                else if (s[i] == s[j])
                    dp[j] = buttonLeft + 2;
                else
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                buttonLeft = cache;
            }
        }
        return dp[n - 1];
    }
}
