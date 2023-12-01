package com.leetcode.q139;

import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        var n = s.length();
        var dp = new boolean[n + 1];
        dp[0] = true;

        for (var i = 0; i <= n; i++) {
            if (!dp[i]) {
                continue;
            }
            for (var word : wordDict) {
                if (word.length() + i <= n && s.startsWith(word, i)) {
                    dp[i + word.length()] = true;
                }
            }
        }
        return dp[n];
    }
}
