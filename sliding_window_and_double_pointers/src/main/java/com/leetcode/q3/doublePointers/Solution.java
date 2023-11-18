package com.leetcode.q3.doublePointers;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        boolean[] freq = new boolean[128];
        int l = 0, r = 0, ans = 0;

        while (r < chars.length) {
            char chr = chars[r++], chl;
            if (freq[chr]) {
                while ((chl = chars[l++]) != chr) {
                    freq[chl] = false;
                }
            } else {
                freq[chr] = true;
            }
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}
