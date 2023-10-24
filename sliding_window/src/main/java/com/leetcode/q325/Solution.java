package com.leetcode.q325;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        Map<Integer, Integer> preSum = new HashMap<>(nums.length);
        preSum.put(0, -1);
        for (int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            System.out.println(sum);
            if (!preSum.containsKey(sum)) {
                preSum.put(sum, i);
            }
            if (preSum.containsKey(sum - k)) {
                res = Math.max(res, i - preSum.get(sum - k));
            }
        }
        return res;
    }
}