package com.leetcode.q485;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int l = 0, r = 0, res = 0, len = nums.length;
        while (l < len) {
            r = l;
            while (r < len && nums[r] == 1) {
                r++;
            }
            res = Math.max(res, r - l);
            l = r + 1;
        }
        return res;
    }
}
