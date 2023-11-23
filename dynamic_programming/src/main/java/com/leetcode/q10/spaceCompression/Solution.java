package com.leetcode.q10.spaceCompression;

import java.util.Arrays;

class Solution {
    public boolean isMatch(String s, String p) {
        return doMatch(s.toCharArray(), p.toCharArray());
    }

    private static boolean doMatch(char[] s, char[] p) {
        int n = s.length, m = p.length;
        var dp = new boolean[2][m + 1];
        dp[1][m] = true;
        for (var j = m - 1; j >= 0; j--) {
            dp[1][j] = j < m - 1 && p[j + 1] == '*' && dp[1][j + 2];
        }
        for (var i = n - 1; i >= 0; i--) {
            for (var j = m - 1; j >= 0; j--) {
                if (j < m - 1 && p[j + 1] == '*') {
                    var p0 = dp[0][j + 2];
                    var p1 = (p[j] == '.' || s[i] == p[j]) && dp[1][j];
                    dp[0][j] = p0 || p1;
                } else {
                    dp[0][j] = (p[j] == '.' || s[i] == p[j]) && dp[1][j + 1];
                }
            }
            System.arraycopy(dp[0], 0, dp[1], 0, m + 1);
        }
        return dp[0][0];
    }
}
