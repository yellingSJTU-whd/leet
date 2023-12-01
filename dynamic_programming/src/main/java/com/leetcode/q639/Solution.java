package com.leetcode.q639;

class Solution {
    public int numDecodings(String str) {
        long seed = 1000000007;
        var s = str.toCharArray();
        var n = s.length;
        long lastLast = 1, last = switch (s[n - 1]) {
            case '*' -> 9;
            case '0' -> 0;
            default -> 1;
        };

        for (var i = n - 2; i >= 0; i--) {
            long curr;
            if (s[i] == '0')
                curr = 0;
            else if (s[i] != '*') {
                curr = last;
                if (s[i + 1] == '*') curr += lastLast * switch (s[i]) {
                    case '1' -> 9;
                    case '2' -> 6;
                    default -> 0;
                };
                else if ((s[i] - '0') * 10 + s[i + 1] - '0' <= 26)
                    curr += lastLast;
            } else {
                curr = 9 * last;
                if (s[i + 1] == '*')
                    curr += 15 * lastLast;
                else
                    curr += lastLast * (s[i + 1] - '0' < 7 ? 2 : 1);
            }
            curr %= seed;
            lastLast = last;
            last = curr;
        }
        return (int) last;
    }
}
