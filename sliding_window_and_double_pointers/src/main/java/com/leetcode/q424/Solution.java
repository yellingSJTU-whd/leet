package com.leetcode.q424;

class Solution {
    public int characterReplacement(String s, int k) {
        char[] chars = s.toCharArray();
        int[] freq = new int[26];
        int l = 0, r = 0, order = -1;

        while (r < chars.length) {
            order = Math.max(order, ++freq[chars[r++] - 'A']);
            if (r - l - order > k) {
                --freq[chars[l++] - 'A'];
            }
        }
        return chars.length - l;
    }
}
