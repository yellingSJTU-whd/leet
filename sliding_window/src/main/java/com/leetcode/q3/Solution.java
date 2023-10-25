package com.leetcode.q3;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] present = new boolean[128];
        int l = 0, r = 0, ans = 0;
        while (r < s.length()) {
            char chr = s.charAt(r);
            if (present[chr]) {
                while (s.charAt(l) != chr) {
                    present[s.charAt(l++)] = false;
                }
                l++;
            } else {
                present[chr] = true;
            }
            r++;
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}