package com.leetcode.q72;

class Solution {
    public int minDistance(String word1, String word2) {
        char[] from = word1.toCharArray(), to = word2.toCharArray();
        int n = from.length, m = to.length;
        var dp = new int[m + 1];
        for (var j = 1; j <= m; j++) {
            dp[j] = j;
        }

        for (int i = 1, topLeft, cache; i <= n; i++) {
            dp[0] = i;
            topLeft = i - 1;
            for (var j = 1; j <= m; j++) {
                cache = dp[j];
                if (from[i - 1] == to[j - 1]) {
                    dp[j] = topLeft;
                } else {
                    // 替换from[i-1] 为 to[j-1], from[i-2] -> to[j-2]
                    var p0 = topLeft + 1;
                    // 删除to[j-1], from[i-1] -> to[j-2]
                    var p1 = dp[j - 1] + 1;
                    // 删除from[i-1], from[i-2] -> to[j-1]
                    var p2 = dp[j] + 1;
                    dp[j] = Math.min(p0, Math.min(p1, p2));
                }
                topLeft = cache;
            }
        }
        return dp[m];
    }
}
