package com.leetcode.q1234;

class Solution {
    public int balancedString(String s) {
        int[] freq = new int[26];
        int len = s.length(), threshold = len / 4, l = 0, r = 0, res = len;
        for (int i = 0; i < len; i++) {
            freq[s.charAt(i) - 'A']++;
        }
        while (r < len) {
            freq[s.charAt(r++)-'A']--;
            while (l < len
                    && freq['Q' - 'A'] <= threshold
                    && freq['W' - 'A'] <= threshold
                    && freq['E' - 'A'] <= threshold
                    && freq['R' - 'A'] <= threshold) {
                res = Math.min(res, r - l);
                freq[s.charAt(l++)-'A']++;
            }
        }
        return res;
    }
}
