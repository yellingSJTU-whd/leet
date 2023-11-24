package com.leetcode.q42.doublePointers;

class Solution {
    public int trap(int[] height) {
        int res = 0, n = height.length, l = 0, r = n - 1, leftExtremum = 0, rightExtremum = 0;
        while (l < r) {
            int left = height[l], right = height[r];
            if (left < right) {
                if (left > leftExtremum) {
                    leftExtremum = left;
                } else {
                    res += leftExtremum - left;
                }
                l++;
            } else {
                if (right > rightExtremum) {
                    rightExtremum = right;
                } else {
                    res += rightExtremum - right;
                }
                r--;
            }
        }
        return res;
    }
}
