package com.leetcode.q44;

import java.util.Arrays;

class Solution {
    public boolean isMatch(String s, String p) {
        return doMatch(s.toCharArray(), p.toCharArray());
    }

    private static boolean doMatch(char[] s, char[] p) {
        int n = s.length, m = p.length;
        var dp = new boolean[m + 1];
        dp[m] = true;
        for (var j = m - 1; j >= 0; j--) {
            if (p[j] == '*') {
                dp[j] = dp[j + 1];
            }
        }
        for (var i = n - 1; i >= 0; i--) {
            boolean buttonRight = dp[m], cache;
            dp[m] = false;
            for (var j = m - 1; j >= 0; j--) {
                cache = dp[j];
                if (p[j] == '*') {
                    dp[j] = dp[j] || dp[j + 1];
                } else {
                    dp[j] = (p[j] == '?' || s[i] == p[j]) && buttonRight;
                }
                buttonRight = cache;
            }
        }
        return dp[0];
    }
}
