package com.leetcode.q213;

import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        var n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(nums[0] + best(nums, 2, n - 2), best(nums, 1, n - 1));
    }

    private int best(int[] nums, int l, int r) {
        if (l > r) {
            return 0;
        }
        if (l == r) {
            return nums[l];
        }
        if (l + 1 == r) {
            return Math.max(nums[l], nums[r]);
        }

        var n = r - l + 1;
        var dp = new int[n];
        dp[0] = nums[l];
        dp[1] = Math.max(nums[l], nums[l + 1]);
        for (var i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i + l] + dp[i - 2], dp[i - 1]);
        }
        return dp[n - 1];
    }
}
