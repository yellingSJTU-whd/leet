package com.leetcode.q159.slidingWindow;

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char[] chars = s.toCharArray();
        int[] freq = new int[128];
        int l = 0, r = 0, cardinality = 0, res = 0;

        while (r < chars.length) {
            if (freq[chars[r++]]++ == 0) {
                cardinality++;
            }
            while (cardinality > 2) {
                if (--freq[chars[l++]] == 0) {
                    cardinality--;
                }
            }
            res = Math.max(res, r - l);
        }
        return res;
    }
}
