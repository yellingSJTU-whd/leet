package com.leetcode.q42.dp;

class Solution {
    public int trap(int[] height) {
        int res = 0, max = 0, n = height.length;
        int[] left = new int[n], right = new int[n];
        for (var i = 0; i < n; i++) {
            max = Math.max(max, height[i]);
            left[i] = max;
        }
        max = 0;
        for (var i = n - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            right[i] = max;
        }
        for (var i = 0; i < n; i++) {
            res += Math.min(left[i], right[i]) - height[i];
        }
        return res;
    }
}
