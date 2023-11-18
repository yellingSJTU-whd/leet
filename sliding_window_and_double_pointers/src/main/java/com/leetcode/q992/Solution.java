package com.leetcode.q992;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarrayWithMostKCardinality(nums, k) - subarrayWithMostKCardinality(nums, k - 1);
    }

    private int subarrayWithMostKCardinality(int[] nums, int k) {
        if (k <= 0) {
            return 0;
        }

        int len = nums.length, cardinality = 0, l = 0, r = 0, res = 0;
        int[] freq = new int[len + 1];
        while (r < len) {
            if (freq[nums[r++]]++ == 0) {
                cardinality++;
            }
            while (cardinality > k) {
                if (--freq[nums[l++]] == 0) {
                    cardinality--;
                }
            }
            res += r - l;
        }
        return res;
    }
}
