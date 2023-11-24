package com.leetcode.q152;

class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], n = nums.length, res = nums[0];
        for (var i = 1; i < n; i++) {
            int curr = nums[i], cache = max;
            max = Math.max(Math.max(max * curr, min * curr), curr);
            min = Math.min(Math.min(min * curr, cache * curr), curr);
            res = Math.max(max, res);
        }
        return res;
    }
}
