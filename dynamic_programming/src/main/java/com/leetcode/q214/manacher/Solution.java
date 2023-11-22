package com.leetcode.q214.manacher;

import java.util.Arrays;

class Solution {
    public String shortestPalindrome(String str) {
        var radii = manacher(str);
        int idx = 0, n = radii.length;
        for (var i = (n - 1) / 2; i > 0; i--) {
            if (i == radii[i]) {
                idx = i;
                break;
            }
        }
        if (2 * idx == n - 1) {
            return str;
        }

        var builder = new StringBuilder();
        for (int i = str.length() - 1; i > (2 * idx - 1) / 2; i--) {
            builder.append(str.charAt(i));
        }
        return builder + str;
    }

    private static char[] padding(String str) {
        if (str == null || str.isEmpty()) {
            return new char[0];
        }
        var s = new char[2 * str.length() + 1];
        s[0] = '#';
        var idx = 1;
        for (char c : str.toCharArray()) {
            s[idx++] = c;
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
        for (int i = 1; i < n - 1; i++) {
            if (maxRight > i) {
                var mirrorRadius = radii[2 * center - i];
                var delta = maxRight - i;
                if (delta > mirrorRadius) {
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
