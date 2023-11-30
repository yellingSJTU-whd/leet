package com.leetcode.q97;

class Solution {
    public boolean isInterleave(String str1, String str2, String str3) {
        char[] s1 = str1.toCharArray(), s2 = str2.toCharArray(), s3 = str3.toCharArray();
        int n = s1.length, m = s2.length;
        if (s3.length != n + m) {
            return false;
        }
        var dp = new boolean[m + 1];
        dp[0] = true;
        for (var j = 1; j <= m; j++) {
            dp[j] = s2[j - 1] == s3[j - 1] && dp[j - 1];
        }

        for (var i = 1; i <= n; i++) {
            dp[0] = s1[i - 1] == s3[i - 1] && dp[0];
            for (var j = 1; j <= m; j++) {
                var p0 = s1[i - 1] == s3[i + j - 1] && dp[j];
                var p1 = s2[j - 1] == s3[i + j - 1] && dp[j - 1];
                dp[j] = p0 || p1;
            }
        }
        return dp[m];
    }
}
