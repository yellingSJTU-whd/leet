package com.leetcode.q340;

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }
        int[] present = new int[128];
        int count = 0, ans = 0, l = 0, r = 0;
        char[] chs = s.toCharArray();
        while (r < chs.length) {
            if (present[chs[r++]]++ == 0) {
                count++;
            }
            while (count > k) {
                if (--present[chs[l++]] == 0) {
                    count--;
                }
            }
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}