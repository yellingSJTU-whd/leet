package com.leetcode.q340;

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }
        int[] freq = new int[128];
        int cardinality = 0, res = 0, l = 0, r = 0;
        while (r < s.length()) {
            if (freq[s.charAt(r++)]++ == 0) {
                cardinality++;
            }
            while (cardinality > k) {
                if (--freq[s.charAt(l++)] == 0) {
                    cardinality--;
                }
            }
            res = Math.max(res, r - l);
        }
        return res;
    }
}