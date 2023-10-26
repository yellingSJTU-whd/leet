package com.leetcode.q424;

class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int l = 0, r = 0, order = -1;
        while (r < s.length()) {
            order = Math.max(order, ++freq[s.charAt(r++) - 'A']);
            if (r - l - order > k) {
                --freq[s.charAt(l++) - 'A'];
            }
        }
        return s.length() - l;
    }
}
