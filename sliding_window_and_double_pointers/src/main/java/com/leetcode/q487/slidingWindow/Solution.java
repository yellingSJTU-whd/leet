package com.leetcode.q487.slidingWindow;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int l = 0, r = 0, order = 1, len = nums.length;
        while (r < len) {
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
