package com.leetcode.q325;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> preSum = new HashMap<>(nums.length);
        preSum.put(0, -1);
        for (int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            preSum.putIfAbsent(sum, i);
            if (preSum.containsKey(sum - k)) {
                res = Math.max(res, i - preSum.get(sum - k));
            }
        }
        return res;
    }
}