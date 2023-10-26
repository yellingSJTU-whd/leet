package com.leetcode.q485;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, sum = 0;
        for (int num : nums) {
            if (num == 1) {
                res = Math.max(res, ++sum);
            } else {
                sum = 0;
            }
        }
        return res;
    }
}
