package com.leetcode.q53;

class Solution {
    public int maxSubArray(int[] nums) {
        int preSum = nums[0], res = nums[0], n = nums.length;
        for (var i = 1; i < n; i++) {
            preSum = nums[i] + Math.max(preSum, 0);
            res = Math.max(res, preSum);
        }
        return res;
    }
}
