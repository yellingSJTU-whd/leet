package com.leetcode.q713;

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1 || nums == null || nums.length == 0) {
            return 0;
        }
        int l = 0, r = 0, product = 1, res = 0;
        while (r < nums.length) {
            product *= nums[r];
            while (product >= k) {
                product /= nums[l++];
            }
            res += ++r - l;
        }
        return res;
    }
}
