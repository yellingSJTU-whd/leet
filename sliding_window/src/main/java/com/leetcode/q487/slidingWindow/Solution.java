package com.leetcode.q487.slidingWindow;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length, res = 0, preZero = -1, l = 0, r = 0;
        while (r < len) {
            if (nums[r] == 0) {
                if (preZero >= 0 && preZero < len - 1) {
                    l = preZero + 1;
                }
                preZero = r;
            }
            res = Math.max(res, ++r-l);
        }
        return res;
    }
}