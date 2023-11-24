package com.leetcode.q45;

class Solution {
    public int jump(int[] nums) {
        int maxReach = 0, bound = 0, res = 0, n = nums.length;
        for (var i = 0; i < n - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (i == bound) {
                bound = maxReach;
                res++;
            }
        }
        return res;
    }
}
