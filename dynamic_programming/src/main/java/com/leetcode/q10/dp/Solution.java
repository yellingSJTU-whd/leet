package com.leetcode.q10.dp;

class Solution {
    public boolean isMatch(String s, String p) {
        return doMatch(s.toCharArray(), p.toCharArray());
    }

    private static boolean doMatch(char[] s, char[] p) {
        int n = s.length, m = p.length;
        var dp = new boolean[n + 1][m + 1];
        dp[n][m] = true;
        for (var j = m - 1; j >= 0; j--) {
            dp[n][j] = j < m - 1 && p[j + 1] == '*' && dp[n][j + 2];
        }

        for (var i = n - 1; i >= 0; i--) {
            for (var j = m - 1; j >= 0; j--) {
                if (j < m - 1 && p[j + 1] == '*') {
                    var p0 = dp[i][j + 2];
                    var p1 = (p[j] == '.' || s[i] == p[j]) && dp[i + 1][j];
                    dp[i][j] = p0 || p1;
                } else {
                    dp[i][j] = (p[j] == '.' || s[i] == p[j]) && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}
