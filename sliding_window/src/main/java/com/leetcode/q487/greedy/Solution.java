package com.leetcode.q487.greedy;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int order = 1, l = 0, r = 0;
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
