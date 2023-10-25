package com.leetcode.q159;

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] present = new int[128];
        char[] chs = s.toCharArray();
        int replica = 0, res = 0, l = 0, r = 0;
        while (r < chs.length) {
            if (present[chs[r++]]++ == 0) {
                replica++;
            }
            while (replica > 2) {
                if (--present[chs[l++]] == 0) {
                    replica--;
                }
            }
            res = Math.max(res, r - l);
        }
        return res;
    }
}
