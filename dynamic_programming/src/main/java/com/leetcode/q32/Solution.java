package com.leetcode.q32;

import java.util.Arrays;

class Solution {
    public int longestValidParentheses(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        var s = str.toCharArray();
        var n = s.length;
        var dp = new int[n];
        dp[0] = 0;
        for (var i = 1; i < n; i++) {
            if (s[i] == '(') {
                dp[i] = 0;
            } else {
                var pre = s[i - 1];
                if (pre == '(') {
                    dp[i] = i > 2 ? 2 + dp[i - 2] : 2;
                } else {
                    var idx = i - 1 - dp[i - 1];
                    if (idx >= 0 && s[idx] == '(') {
                        dp[i] = 2 + dp[i - 1] + (idx >= 2 ? dp[idx - 1] : 0);
                    }
                }
            }
        }
        var res = 0;
        for (var len : dp) {
            res = Math.max(len, res);
        }
        return res;
    }
}
