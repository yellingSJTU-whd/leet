package com.leetcode.q139;

import java.util.List;

class Solution {
    public boolean wordBreak(String str, List<String> wordDict) {
        var s = str.toCharArray();
        var n = s.length;
        var dp = new boolean[n + 1];
        dp[0] = true;

        for (var i = 0; i <= n; i++) {
            if (!dp[i]) {
                continue;
            }
            for (var word : wordDict) {
                if (word.length() + i <= n && str.startsWith(word, i)) {
                    dp[i + word.length()] = true;
                }
            }
        }
        return dp[n];
    }
}
