package com.leetcode.q5.dp;

class Solution {
    public String longestPalindrome(String str) {
        char[] s = str.toCharArray();
        int len = 1, start = 0, n = s.length;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < n; j++) {
                if (s[i] == s[j] && (j <= i + 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;

                    if (j - i + 1 > len) {
                        len = j - i + 1;
                        start = i;
                    }
                }
            }
        }
        return str.substring(start, start + len);
    }
}
