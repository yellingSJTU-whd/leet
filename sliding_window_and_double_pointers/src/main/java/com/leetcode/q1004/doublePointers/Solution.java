package com.leetcode.q1004.doublePointers;

class Solution {
    public int longestOnes(int[] nums, int k) {
        int count = 0, l = 0, r = 0, res = 0;
        while (r < nums.length) {
            if (nums[r++] == 0) {
                count++;
            }
            while (count > k) {
                if (nums[l++] == 0) {
                    count--;
                }
            }
            res = Math.max(res, r - l);
        }
        return res;
    }
}
