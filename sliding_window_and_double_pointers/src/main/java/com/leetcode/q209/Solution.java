package com.leetcode.q209;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = nums.length, sum = 0, l = 0, r = 0;
        while (r < nums.length) {
            sum += nums[r++];
            while (sum >= target) {
                res = Math.min(res, r - l);
                sum -= nums[l++];
            }
        }
        return res > nums.length ? 0 : res;
    }
}
