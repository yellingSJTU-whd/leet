package com.leetcode.q159.doublePointers;

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char[] chars = s.toCharArray();
        int[] freq = new int[128];
        int l = 0, r = 0, cardinality = 0;

        while (r < chars.length) {
            if (freq[chars[r++]]++ == 0) {
                cardinality++;
            }
            if (cardinality > 2 && --freq[chars[l++]] == 0) {
                cardinality--;
            }
        }
        return r - l;
    }
}
