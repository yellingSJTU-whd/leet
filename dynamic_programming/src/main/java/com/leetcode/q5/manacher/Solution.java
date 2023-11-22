package com.leetcode.q5.manacher;

import java.util.Arrays;

class Solution {
    public String longestPalindrome(String str) {
        var radii = manacher(str);
        int idx = 0, maxLen = 0, n = radii.length;
        for (var i = 0; i < n; i++) {
            if (radii[i] > maxLen) {
                idx = i;
                maxLen = radii[i];
            }
        }
        if ((idx - maxLen) % 2 == 0) {
            return str.substring((idx - maxLen) / 2, (idx + maxLen) / 2);
        }
        return str.substring((idx - maxLen - 1) / 2, (idx + maxLen - 1) / 2 + 1);
    }

    private static char[] padding(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        var s = new char[2 * str.length() + 1];
        s[0] = '#';
        var idx = 1;
        for (char ch : str.toCharArray()) {
            s[idx++] = ch;
            s[idx++] = '#';
        }
        return s;
    }

    private static int centralExpand(char[] s, int index, int skip) {
        var n = s.length;
        if (index <= 0 || index >= n - 1) {
            return 0;
        }
        int l = index - skip - 1, r = index + skip + 1, count = skip;
        while (l >= 0 && r < n) {
            if (s[l--] != s[r++]) break;
            count++;
        }
        return count;
    }

    private static int[] manacher(String str) {
        var s = padding(str);
        int center = 0, maxRight = 0, n = s.length;
        var radii = new int[n];
        for (var i = 1; i < n - 1; i++) {
            if (maxRight > i) {
                var mirrorRadius = radii[2 * center - i];
                var delta = maxRight - i;
                if (mirrorRadius < delta) {
                    radii[i] = mirrorRadius;
                } else {
                    radii[i] = centralExpand(s, i, delta);
                }
            } else {
                radii[i] = centralExpand(s, i, 0);
            }

            if (i + radii[i] > maxRight) {
                center = i;
                maxRight = i + radii[i];
            }
        }
        return radii;
    }
}
