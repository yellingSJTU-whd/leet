package com.leetcode.q1004.slidingWindow;

class Solution {
    public int longestOnes(int[] nums, int k) {
        int order = k, l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r++] == 0) {
                order--;
            }
            if (order < 0 && nums[l++] == 0) {
                order++;
            }
        }
        return r - l;
    }
}
