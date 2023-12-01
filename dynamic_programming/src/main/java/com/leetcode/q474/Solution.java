package com.leetcode.q474;

class Solution {
    int zeros = 0, ones = 0;

    public int findMaxForm(String[] strs, int m, int n) {
        var dp = new int[m + 1][n + 1];
        for (String str : strs) {
            countZerosAndOnes(str);
            for (var i = m; i >= zeros; i--) {
                for (var j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private void countZerosAndOnes(String str) {
        var s = str.toCharArray();
        zeros = 0;
        ones = 0;
        for (var ch : s) {
            if (ch == '0') zeros++;
            if (ch == '1') ones++;
        }
    }
}
