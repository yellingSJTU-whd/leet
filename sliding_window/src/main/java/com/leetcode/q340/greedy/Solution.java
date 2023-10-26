package com.leetcode.q340.greedy;

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] freq = new int[128];
        int order = k, l = 0, r = 0;
        while (r < s.length()) {
            if (freq[s.charAt(r++)]++ == 0) {
                order--;
            }
            if (order < 0 && --freq[s.charAt(l++)] == 0) {
                order++;
            }
        }
        return s.length() - l;
    }
}
