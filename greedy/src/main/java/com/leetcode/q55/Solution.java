package com.leetcode.q55;

class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0, n = nums.length;
        for (var i = 0; i < n - 1; i++) {
            if (maxReach < i || maxReach >= n - 1) break;
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return maxReach >= n - 1;
    }
}
