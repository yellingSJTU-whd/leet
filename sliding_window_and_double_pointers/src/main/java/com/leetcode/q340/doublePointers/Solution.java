package com.leetcode.q340.doublePointers;

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] freq = new int[128];
        int l = 0, r = 0, cardinality = 0, res = 0;

        while (r < chars.length) {
            if (freq[chars[r++]]++ == 0) {
                cardinality++;
            }
            while (cardinality > k) {
                if (--freq[chars[l++]] == 0) {
                    cardinality--;
                }
            }
            res = Math.max(res, r - l);
        }
        return res;
    }
}