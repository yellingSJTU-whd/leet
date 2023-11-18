package com.leetcode.q3.slidingWindow;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chs = s.toCharArray();
        int[] freq = new int[128];
        int l = 0, r = 0, duplicate = 0;

        while (r < chs.length) {
            if (freq[chs[r++]]++ == 1) {
                duplicate++;
            }
            if (duplicate > 0 && --freq[chs[l++]] == 1) {
                duplicate--;
            }
        }
        return r - l;
    }
}