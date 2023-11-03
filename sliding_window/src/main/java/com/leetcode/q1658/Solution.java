package com.leetcode.q1658;
class Solution {
    public int minOperations(int[] nums, int x) {
        int target = 0, sum = 0, l = 0, r = 0, res = -1;
        for (int num : nums) {
            target += num;
        }
        target -= x;
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
