package com.leetcode.q340.slidingWindow;

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] freq = new int[128];
        int order = k, l = 0, r = 0;

        while (r < chars.length) {
            if (freq[chars[r++]]++ == 0) {
                order--;
            }
            if (order < 0 && --freq[chars[l++]] == 0) {
                order++;
            }
        }
        return s.length() - l;
    }
}
