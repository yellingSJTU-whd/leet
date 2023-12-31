package com.leetcode.q5.manacher;

class Solution {
    public String longestPalindrome(String str) {
        var radii = manacher(str);
        int pivot = 0, maxRadius = 0, n = radii.length;
        for (var i = 0; i < n; i++) {
            if (radii[i] > maxRadius) {
                pivot = i;
                maxRadius = radii[i];
            }
        }
        return str.substring((pivot - maxRadius) / 2, (pivot + maxRadius) / 2);
    }

    private static char[] padding(String s) {
        if (s == null || s.isEmpty()) return new char[0];

        var n = s.length();
        var origin = s.toCharArray();
        var padded = new char[2 * n + 1];

        for (var i = 0; i < n; i++) {
            padded[2 * i] = '#';
            padded[2 * i + 1] = origin[i];
        }
        padded[2 * n] = '#';
        return padded;
    }

    private static int centralExpand(char[] s, int pivot, int skip) {
        if (pivot <= 0 || pivot >= s.length - 1) return 0;
        if (skip < 0) throw new IllegalArgumentException();

        int l = pivot - skip - 1, r = pivot + skip + 1, radius = skip;
        while (l >= 0 && r < s.length) {
            if (s[l--] != s[r++]) break;
            radius++;
        }
        return radius;
    }

    private static int[] manacher(String str) {
        var s = padding(str);
        int pivot = 0, maxRight = 0, n = s.length;
        var radii = new int[n];

        for (var i = 1; i < n - 1; i++) {
            if (maxRight <= i) {
                radii[i] = centralExpand(s, i, 0);
            } else {
                var mirrorRadius = radii[2 * pivot - i];
                var delta = maxRight - i;
                radii[i] = mirrorRadius < delta ? mirrorRadius : centralExpand(s, i, delta);
            }

            if (i + radii[i] > maxRight) {
                pivot = i;
                maxRight = i + radii[i];
            }
        }
        return radii;
    }
}
