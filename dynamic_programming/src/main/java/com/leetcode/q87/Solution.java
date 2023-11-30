package com.leetcode.q87;

class Solution {
    public boolean isScramble(String str1, String str2) {
        char[] s1 = str1.toCharArray(), s2 = str2.toCharArray();
        var n = s1.length;
        var dp = new boolean[n][n][n + 1];
        for (var i = 0; i < n; i++) {
            for (var j = 0; j < n; j++) {
                if (s1[i] == s2[j]) {
                    dp[i][j][1] = true;
                }
            }
        }

        for (var len = 1; len <= n; len++) {
            for (var i = 0; i <= n - len; i++) {
                for (var j = 0; j <= n - len; j++) {
                    for (var k = 1; k < len; k++) {
                        var p0 = dp[i][j][k] && dp[i + k][j + k][len - k];
                        var p1 = dp[i][j + len - k][k] && dp[i + k][j][len - k];
                        if (p0 || p1) {
                            dp[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }
}
