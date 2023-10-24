package com.leetcode.q713;

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1 || nums == null || nums.length == 0) {
            return 0;
        }
        int prd = 1, count = 0, l = 0, r = 0;
        while (r < nums.length) {
            prd *= nums[r];
            while (prd >= k) {
                prd /= nums[l++];
            }
            count += (r++) - l + 1;
        }
        return count;
    }
}
