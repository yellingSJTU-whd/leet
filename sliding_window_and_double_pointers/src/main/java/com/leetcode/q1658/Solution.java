package com.leetcode.q1658;

class Solution {
    public int minOperations(int[] nums, int x) {
        int target = -x, l = 0, r = 0, res = -1, sum = 0;
        for (int num : nums) {
            target += num;
        }
        while (r < nums.length) {
            sum += nums[r++];
            while (sum > target && l < nums.length) {
                sum -= nums[l++];
            }
            if (sum == target) {
                res = Math.max(res, r - l);
            }
        }
        return res >= 0 ? nums.length - res : -1;
    }
}
