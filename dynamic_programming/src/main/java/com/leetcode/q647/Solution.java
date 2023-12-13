package com.leetcode.q647;

class Solution {
    public int countSubstrings(String s) {
        var radii = manacher(s);
        var res = 0;
        for (var radius : radii) {
            res += (radius + 1) / 2;
        }
        return res;
    }

    private char[] padding(String s) {
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

    private int centralExpand(char[] s, int pivot, int skip) {
        if (pivot < 0 || pivot >= s.length) return 0;
        if (skip < 0) throw new IllegalArgumentException();

        var n = s.length;
        int l = pivot - skip - 1, r = pivot + skip + 1, radius = skip;
        while (l >= 0 && r < n) {
            if (s[l--] != s[r++]) break;
            radius++;
        }
        return radius;
    }

    private int[] manacher(String str) {
        var s = padding(str);
        var n = s.length;
        var radii = new int[n];
        int pivot = -1, maxRight = -1;

        for (var i = 1; i < n - 1; i++) {
            if (i >= maxRight) {
                radii[i] = centralExpand(s, i, 0);
            } else {
                var mirrorRadius = radii[2 * pivot - i];
                var delta = maxRight - i;
                radii[i] = delta > mirrorRadius ? mirrorRadius : centralExpand(s, i, delta);
            }

            if (i + radii[i] > maxRight) {
                pivot = i;
                maxRight = i + radii[i];
            }
        }
        return radii;
    }
}
